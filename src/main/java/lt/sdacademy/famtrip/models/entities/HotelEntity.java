package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

    @Column(name = "official_rating", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private HotelRating officialRating;

    @Column(name = "inspection_score", nullable = false)
    private Integer inspectionScore;

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

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotel_recommended_to", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "recommended_to_id"))
    private List<RecommendedToEntity> recommendedTos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotel_cuisine_type", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "cuisine_type_id"))
    private List<CuisineTypeEntity> cuisineTypes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotel_label", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<LabelEntity> labels = new ArrayList<>();

    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "id")
    private List<RoomEntity> rooms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Integer getInspectionScore() {
        return inspectionScore;
    }

    public void setInspectionScore(Integer inspectionScore) {
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

    public List<CuisineTypeEntity> getCuisineTypes() {
        return cuisineTypes;
    }

    public void setCuisineTypes(List<CuisineTypeEntity> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    public List<LabelEntity> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelEntity> labels) {
        this.labels = labels;
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

    public List<RecommendedToEntity> getRecommendedTos() {
        return recommendedTos;
    }

    public void setRecommendedTos(List<RecommendedToEntity> recommendedTos) {
        this.recommendedTos = recommendedTos;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }
}
