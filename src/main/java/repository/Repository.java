package repository;

import model.Advertisement;
import model.Category;
import model.Id;
import model.Type;
import repository.entities.AdvertisementPO;
import service.request.CreateAdvertisementRequest;
import service.request.GetAdvertisementRequest;
import service.request.GetAdvertisementsRequest;
import service.request.UpdateAdvertisementRequest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Transactional
public class Repository {

    private final EntityManager entityManager;

    @Inject
    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Advertisement createAdvertisement(CreateAdvertisementRequest createAdvertisementRequest) {
        AdvertisementPO adPO = new AdvertisementPO(createAdvertisementRequest);
        entityManager.persist(adPO);
        System.out.println(adPO.toAdvertisement().getId().getRaw());
        return adPO.toAdvertisement();
    }

    public Advertisement getAdvertisement(GetAdvertisementRequest request) {
        Advertisement advertisement = entityManager.createNamedQuery(AdvertisementPO.GET_BY_ID, AdvertisementPO.class).setParameter(AdvertisementPO.ID_PARAM, request.getUuid()).getSingleResult().toAdvertisement();
        return advertisement;
    }

    public List<Advertisement> getAdvertisements(GetAdvertisementsRequest request) {
        List<Advertisement> advertisements = new ArrayList<>();

        if (request.getCategory() != null || request.getType() != null) {

            Category category = request.getCategory();

            Type type = request.getType();

            if (category == null) {
                // Finds all Ads where type matches
                advertisements.addAll(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_TYPE, AdvertisementPO.class).setParameter(AdvertisementPO.TYPE_PARAM, type).
                        getResultList().stream().map(AdvertisementPO::toAdvertisement).collect(Collectors.toList()));

            } else if (type == null){
                // Find all Ads where category matches
                advertisements.addAll(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY, AdvertisementPO.class).setParameter(AdvertisementPO.CATEGORY_PARAM, category).
                        getResultList().stream().map(AdvertisementPO::toAdvertisement).collect(Collectors.toList()));

            } else {
                // Find all Ads where type & category matches
                advertisements.addAll(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY_AND_TYPE, AdvertisementPO.class).setParameter(AdvertisementPO.CATEGORY_PARAM, category).setParameter(AdvertisementPO.TYPE_PARAM, type).
                        getResultList().stream().map(AdvertisementPO::toAdvertisement).collect(Collectors.toList()));
            }
        } else {
            // returns all ads.
            advertisements.addAll(entityManager.createNamedQuery(AdvertisementPO.GET_ALL, AdvertisementPO.class).
                    getResultList().stream().map(AdvertisementPO::toAdvertisement).collect(Collectors.toList()));
        }
        return advertisements;
    }

    public Advertisement updateAdvertisement(UpdateAdvertisementRequest request) {
        Advertisement advertisement = null;
        if (request.isDelete()) {
            AdvertisementPO toDelete = entityManager.find(AdvertisementPO.class, request.getId().getUuid());
            entityManager.remove(toDelete);
        } else {
            AdvertisementPO advertisementPO = new AdvertisementPO(new Id(request.getId().getRaw()).getUuid(), request.getCategory(), request.getType(), request.getHeaderText(), request.getText(), request.getMobile(), request.getImgURL(), request.getPrice());
            AdvertisementPO updatedAdvertisementPO = entityManager.merge(advertisementPO);
            advertisement = updatedAdvertisementPO.toAdvertisement();
        }
        return advertisement;
    }

    public HashMap<Category, Integer> getCategories() {
        List<Advertisement> advertisementList = entityManager.createNamedQuery(AdvertisementPO.GET_ALL, AdvertisementPO.class).
                getResultList().stream().map(AdvertisementPO::toAdvertisement).collect(Collectors.toList());
        HashMap<Category, Integer> categoryIntegerHashMap = new HashMap<>();
        List<Category> categories = List.of(Category.values());
        for (Advertisement advertisement : advertisementList) {
            if (categoryIntegerHashMap.containsKey(advertisement.getCategory())) {
                int count = categoryIntegerHashMap.get(advertisement.getCategory());
                count++;
                categoryIntegerHashMap.put(advertisement.getCategory(), count);
            } else {
                categoryIntegerHashMap.put(advertisement.getCategory(), 1);
            }
        }
        for (Category category: categories) {
            if (!categoryIntegerHashMap.containsKey(category)) {
                categoryIntegerHashMap.put(category, 0);
            }
        }
        return categoryIntegerHashMap;
    }
}
