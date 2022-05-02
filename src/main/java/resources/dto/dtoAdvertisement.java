package resources.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import model.Category;
import model.Type;

import javax.ws.rs.DefaultValue;

public class dtoAdvertisement {

    private String id;
    private Category category;
    private Type type;
    private String headerText;
    private String text;
    private Double price;
    private String imgURL;
    private String mobile;

    // Constructor to be used when creating new Advertisement
    @JsonCreator
    public dtoAdvertisement(@DefaultValue("") @JsonProperty("id") String id, @JsonProperty("category") Category category, @JsonProperty("type") Type type,
                            @JsonProperty("headerText") String headerText, @JsonProperty("text") String text, @JsonProperty("price") Double price,
                            @DefaultValue("") @JsonProperty("imgURL") String imgURL, @JsonProperty("mobile") String mobile) {
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.text = text;
        this.price = price;
        this.imgURL = imgURL;
        this.mobile = mobile;
        this.id = id;
    }

    public String getId() {
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
