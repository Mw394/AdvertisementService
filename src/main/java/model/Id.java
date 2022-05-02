package model;

import java.util.UUID;

public class Id {

    private final UUID uuid;

    public Id(UUID uuid) {
        this.uuid = uuid;
    }

    public Id(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getRaw() {
        return uuid.toString();
    }
}
