package lt.sdacademy.famtrip.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class HotelEntity extends AbstractEntity {

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "country", length = 50, nullable = false)
    private String country;

    @Column(name = "city_region", length = 100, nullable = false)
    private String cityRegion;

    @Column(name = "official_rating", length = 50, nullable = false)
    private String officialRating;

    @Column(name = "inspection_score", nullable = false)
    private int inspectionScore;

    @Column(name = "food_quality", length = 50)
    private String foodQuality;

    @Column(name = "territory_size", length = 50)
    private String territorySize;

    @Column(name = "water_slides", nullable = false)
    private boolean waterSlides;

    @Column(name = "spa", nullable = false)
    private boolean spa;

    @Column(name = "distance_to_beach")
    private int distanceToBeach;

    @Column(name = "distance_from_airport")
    private double distanceFromAirport;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

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

    public String getCityRegion() {
        return cityRegion;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    public String getOfficialRating() {
        return officialRating;
    }

    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    public int getInspectionScore() {
        return inspectionScore;
    }

    public void setInspectionScore(int inspectionScore) {
        this.inspectionScore = inspectionScore;
    }

    public String getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(String foodQuality) {
        this.foodQuality = foodQuality;
    }

    public String getTerritorySize() {
        return territorySize;
    }

    public void setTerritorySize(String territorySize) {
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

    public int getDistanceToBeach() {
        return distanceToBeach;
    }

    public void setDistanceToBeach(int distanceToBeach) {
        this.distanceToBeach = distanceToBeach;
    }

    public double getDistanceFromAirport() {
        return distanceFromAirport;
    }

    public void setDistanceFromAirport(double distanceFromAirport) {
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
}
