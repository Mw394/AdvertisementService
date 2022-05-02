package service.response;

import model.Advertisement;

public class UpdateAdvertisementResponse {

    private final boolean deleted;
    private final Advertisement advertisement;

    public UpdateAdvertisementResponse(boolean deleted, Advertisement advertisement) {
        this.deleted = deleted;
        this.advertisement = advertisement;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }
}
