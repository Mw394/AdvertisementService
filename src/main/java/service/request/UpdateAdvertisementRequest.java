package service.request;

import model.Category;
import model.Id;
import model.Type;
import resources.dto.dtoAdvertisement;

public class UpdateAdvertisementRequest {

    private final Id id;
    private final Category category;
    private final Type type;
    private final String headerText;
    private final String text;
    private final String mobile;
    private final String imgURL;
    private final Double price;
    private final boolean delete;


    public UpdateAdvertisementRequest(dtoAdvertisement dtoAdvertisement, boolean delete) {
        this.id = new Id(dtoAdvertisement.getId());
        this.category = dtoAdvertisement.getCategory();
        this.type = dtoAdvertisement.getType();
        this.headerText = dtoAdvertisement.getHeaderText();
        this.text = dtoAdvertisement.getText();
        this.mobile = dtoAdvertisement.getMobile();
        this.imgURL = dtoAdvertisement.getImgURL();
        this.price = dtoAdvertisement.getPrice();
        this.delete = delete;
    }

    public Id getId() {
        return id;
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

    public boolean isDelete() {
        return delete;
    }

    public Double getPrice() {
        return price;
    }
}
