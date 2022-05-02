package service;

import model.Advertisement;
import model.Category;
import repository.Repository;
import service.request.CreateAdvertisementRequest;
import service.request.GetAdvertisementRequest;
import service.request.GetAdvertisementsRequest;
import service.request.UpdateAdvertisementRequest;
import service.response.*;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Dependent
public class AdvertisementService {

    private final Repository repository;

    @Inject
    public AdvertisementService(Repository repository) {
        this.repository = repository;
    }

    public CreateAdvertisementResponse createAdvertisement(CreateAdvertisementRequest createAdvertisementRequest) {
        System.out.println(createAdvertisementRequest.getHeaderText());
        Advertisement advertisement = repository.createAdvertisement(createAdvertisementRequest);
        return new CreateAdvertisementResponse(advertisement);
    }

    public GetAdvertisementsResponse getAdvertisements(GetAdvertisementsRequest request) {
        List<Advertisement> advertisementList = repository.getAdvertisements(request);
        return new GetAdvertisementsResponse(advertisementList);
    }

    public UpdateAdvertisementResponse updateAdvertisement(UpdateAdvertisementRequest request) {
        Advertisement advertisement = repository.updateAdvertisement(request);
        if (advertisement == null) {
            return new UpdateAdvertisementResponse(true, null);
        } else {
            return new UpdateAdvertisementResponse(false, advertisement);
        }
    }

    public GetAdvertisementResponse getAdvertisement(GetAdvertisementRequest request) {
        Advertisement advertisement = repository.getAdvertisement(request);
        return new GetAdvertisementResponse(advertisement);
    }

    public GetCategoriesResponse getCategories() {
        HashMap<Category, Integer> categoryIntegerHashMap = repository.getCategories();
        return new GetCategoriesResponse(categoryIntegerHashMap);
    }
}
