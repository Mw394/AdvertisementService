package service.response;

import model.Advertisement;

import java.util.List;

public class GetAdvertisementsResponse {

    private final List<Advertisement> advertisementList;

    public GetAdvertisementsResponse(List<Advertisement> advertisementList) {
        this.advertisementList = advertisementList;
    }

    public List<Advertisement> getAdvertisementList() {
        return advertisementList;
    }
}
