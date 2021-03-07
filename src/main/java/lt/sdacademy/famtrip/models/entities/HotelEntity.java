package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RecommendedTo;
import lt.sdacademy.famtrip.models.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class HotelEntity extends AbstractEntity {

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

    @Column(name = "official_rating", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private HotelRating officialRating;

    @Column(name = "inspection_score", nullable = false)
    private Byte inspectionScore;

    @Column(name = "food_quality", length = 50)
    @Enumerated(EnumType.STRING)
    private FoodQuality foodQuality;

    @Column(name = "territory_size", length = 50)
    @Enumerated(EnumType.STRING)
    private Size territorySize;

    @Column(name = "water_slides", nullable = false)
    private boolean waterSlides;

    @Column(name = "spa", nullable = false)
    private boolean spa;

    @Column(name = "distance_to_beach")
    private Integer distanceToBeach;

    @Column(name = "distance_from_airport")
    private Double distanceFromAirport;

    @Column(name = "remarks", columnDefinition = "text")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "id")
    private List<RoomEntity> rooms = new ArrayList<>();

    @ElementCollection(targetClass = RecommendedTo.class)
    @JoinTable(name = "hotel_recommended_to", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "title", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<RecommendedTo> recommendedTos = new ArrayList<>();

    @ElementCollection(targetClass = HotelLabel.class)
    @JoinTable(name = "hotel_label", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "title", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<HotelLabel> labels = new ArrayList<>();

    @ElementCollection(targetClass = CuisineType.class)
    @JoinTable(name = "hotel_cuisine_type", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "title", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<CuisineType> cuisineTypes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public HotelRating getOfficialRating() {
        return officialRating;
    }

    public void setOfficialRating(HotelRating officialRating) {
        this.officialRating = officialRating;
    }

    public Byte getInspectionScore() {
        return inspectionScore;
    }

    public void setInspectionScore(Byte inspectionScore) {
        this.inspectionScore = inspectionScore;
    }

    public FoodQuality getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(FoodQuality foodQuality) {
        this.foodQuality = foodQuality;
    }

    public Size getTerritorySize() {
        return territorySize;
    }

    public void setTerritorySize(Size territorySize) {
        this.territorySize = territorySize;
    }

    public boolean isWaterSlides() {
        return waterSlides;
    }

    public void setWaterSlides(boolean waterSlides) {
        this.waterSlides = waterSlides;
    }

    public boolean isSpa() {
        return spa;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public Integer getDistanceToBeach() {
        return distanceToBeach;
    }

    public void setDistanceToBeach(Integer distanceToBeach) {
        this.distanceToBeach = distanceToBeach;
    }

    public Double getDistanceFromAirport() {
        return distanceFromAirport;
    }

    public void setDistanceFromAirport(Double distanceFromAirport) {
        this.distanceFromAirport = distanceFromAirport;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms.clear();
        this.rooms.addAll(rooms);
//        this.rooms = rooms;
    }

    public List<RecommendedTo> getRecommendedTos() {
        return recommendedTos;
    }

    public void setRecommendedTos(List<RecommendedTo> recommendedTos) {
        this.recommendedTos = recommendedTos;
    }

    public List<HotelLabel> getLabels() {
        return labels;
    }

    public void setLabels(List<HotelLabel> labels) {
        this.labels = labels;
    }

    public List<CuisineType> getCuisineTypes() {
        return cuisineTypes;
    }

    public void setCuisineTypes(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }
}
