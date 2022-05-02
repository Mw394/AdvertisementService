package service.request;

import java.util.UUID;

public class GetAdvertisementRequest {

    private UUID uuid;

    public GetAdvertisementRequest(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }

    public UUID getUuid() {
        return uuid;
    }
}
