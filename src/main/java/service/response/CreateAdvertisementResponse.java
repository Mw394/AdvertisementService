package service.response;

import model.Advertisement;
import model.Category;
import model.Id;
import model.Type;

public class CreateAdvertisementResponse {

    private Id id;
    private Category category;
    private Type type;
    private String headerText;
    private String text;
    private Double price;
    private String imgURL;
    private String mobile;

    public CreateAdvertisementResponse(Advertisement advertisement) {
        this.id = advertisement.getId();
        this.category = advertisement.getCategory();
        this.headerText = advertisement.getHeaderText();
        this.imgURL = advertisement.getImgURL();
        this.mobile = advertisement.getMobile();
        this.price = advertisement.getPrice();
        this.text = advertisement.getText();
        this.type = advertisement.getType();
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

    public Double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getMobile() {
        return mobile;
    }

    public Id getId() {
        return id;
    }
}
