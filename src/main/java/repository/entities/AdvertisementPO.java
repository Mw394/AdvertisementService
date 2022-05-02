package repository.entities;
import model.Advertisement;
import model.Category;
import org.hibernate.annotations.Type;
import service.request.CreateAdvertisementRequest;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "AD")
@NamedQueries({
        @NamedQuery(name = "AdvertisementPO.getAdvertisements", query = "SELECT a FROM AdvertisementPO a"),
        @NamedQuery(name = "AdvertisementPO.findByCategoryAndType", query = "SELECT a from AdvertisementPO a WHERE a.category=:category AND a.type=:type"),
        @NamedQuery(name = "AdvertisementPO.findByCategory", query = "SELECT a FROM AdvertisementPO  a WHERE a.category=:category"),
        @NamedQuery(name = "AdvertisementPO.findByType", query = "SELECT a FROM AdvertisementPO  a WHERE a.type=:type"),
        @NamedQuery(name = "AdvertisementPO.findByID", query =  "SELECT a FROM AdvertisementPO  a WHERE a.id=:id")

})
public class AdvertisementPO {

    public static final String CATEGORY_PARAM = "category";
    public static final String TYPE_PARAM = "type";
    public static final String FIND_BY_TYPE = "AdvertisementPO.findByType";
    public static final String FIND_BY_CATEGORY = "AdvertisementPO.findByCategory";
    public static final String FIND_BY_CATEGORY_AND_TYPE = "AdvertisementPO.findByCategoryAndType";
    public static final String GET_ALL = "AdvertisementPO.getAdvertisements";
    public static final String GET_BY_ID = "AdvertisementPO.findByID";
    public static final String ID_PARAM = "id";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40", nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY", columnDefinition = "varchar(40)", nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", columnDefinition = "varchar(10)", nullable = false)
    private model.Type type;

    @Column(name = "HEADER_TEXT", columnDefinition = "varchar(40)", nullable = false)
    private String headerText;

    @Column(name = "TEXT", columnDefinition = "varchar(200)")
    private String text;

    @Column(name = "MOBILE", columnDefinition = "varchar(11)", nullable = false)
    private String mobile;

    @Column(name = "IMGURL", columnDefinition = "varchar(500)")
    private String imgURL;

    @Column(name = "PRICE", columnDefinition = "decimal(10,2)", nullable = false)
    private Double price;

    public AdvertisementPO() {
        // JPA
    }

    public AdvertisementPO(UUID id, Category category, model.Type type, String headerText, String text, String mobile, String imgURL, Double price) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.text = text;
        this.mobile = mobile;
        this.imgURL = imgURL;
        this.price = price;
    }

    public AdvertisementPO(CreateAdvertisementRequest createAdvertisementRequest) {
        this.category = createAdvertisementRequest.getCategory();
        this.type = createAdvertisementRequest.getType();
        this.headerText = createAdvertisementRequest.getHeaderText();
        this.text = createAdvertisementRequest.getText();
        this.mobile = createAdvertisementRequest.getMobile();
        this.imgURL = createAdvertisementRequest.getImgURL();
        this.price = createAdvertisementRequest.getPrice();
    }

    public UUID getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public model.Type getType() {
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

    public Advertisement toAdvertisement() {
        return new Advertisement(new model.Id(id),category,type,headerText,text,price,imgURL,mobile);
    }
}
