package service.response;

import model.Advertisement;

public class GetAdvertisementResponse {

    private Advertisement advertisement;

    public GetAdvertisementResponse(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }
}
