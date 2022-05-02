package service.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import model.Category;
import model.Type;

public class GetAdvertisementsRequest {

    private final Category category;
    private final Type type;

    public GetAdvertisementsRequest(Category category, Type type) {
        this.category = category;
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }
}
