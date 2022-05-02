package service.request;

import model.Category;
import model.Id;
import model.Type;
import resources.dto.dtoAdvertisement;

public class CreateAdvertisementRequest {

    private final Category category;
    private final Type type;
    private final String headerText;
    private final String text;
    private final String mobile;
    private final String imgURL;
    private final Double price;

    public CreateAdvertisementRequest(dtoAdvertisement dtoAdvertisement) {
        this.category = dtoAdvertisement.getCategory();
        this.type = dtoAdvertisement.getType();
        this.headerText = dtoAdvertisement.getHeaderText();
        this.text = dtoAdvertisement.getText();
        this.mobile = dtoAdvertisement.getMobile();
        this.imgURL = dtoAdvertisement.getImgURL();
        this.price = dtoAdvertisement.getPrice();
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getText() {
        return text;
    }

    public String getMobile() {
        return mobile;
    }

    public String getImgURL() {
        return imgURL;
    }

    public Double getPrice() {
        return price;
    }
}
