package model;

public class Advertisement {

    private final Id id;
    private Category category;
    private Type type;
    private String headerText;
    private String text;
    private Double price;
    private String imgURL;
    private String mobile;

    public Advertisement(Id id, Category category, Type type, String headerText, String text, Double price, String imgUrl, String mobile) {
        this.id =  id;
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.text = text;
        this.price = price;
        this.imgURL = imgUrl;
        this.mobile = mobile;
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

    public Double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getMobile() {
        return mobile;
    }
}
