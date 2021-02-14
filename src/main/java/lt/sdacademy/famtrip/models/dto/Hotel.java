package lt.sdacademy.famtrip.models.dto;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RecommendedTo;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.entities.CityEntity;

import java.util.List;

public class Hotel {

    private Long id;
    private CityEntity city;
    private String name;
    private HotelRating officialRating;
    private Byte inspectionScore;
    private FoodQuality foodQuality;
    private Size territorySize;
    private boolean waterSlides;
    private boolean spa;
    private Integer distanceToBeach;
    private Double distanceFromAirport;
    private String remarks;
    private User author;
    private List<Room> rooms;
    private List<RecommendedTo> recommendedTos;
    private List<HotelLabel> labels;
    private List<CuisineType> cuisineTypes;

    public Hotel() {
    }

    public Hotel(Long id, CityEntity city, String name, HotelRating officialRating, Byte inspectionScore, FoodQuality foodQuality, Size territorySize, boolean waterSlides, boolean spa, Integer distanceToBeach, Double distanceFromAirport, String remarks, User author, List<Room> rooms, List<RecommendedTo> recommendedTos, List<HotelLabel> labels, List<CuisineType> cuisineTypes) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.officialRating = officialRating;
        this.inspectionScore = inspectionScore;
        this.foodQuality = foodQuality;
        this.territorySize = territorySize;
        this.waterSlides = waterSlides;
        this.spa = spa;
        this.distanceToBeach = distanceToBeach;
        this.distanceFromAirport = distanceFromAirport;
        this.remarks = remarks;
        this.author = author;
        this.rooms = rooms;
        this.recommendedTos = recommendedTos;
        this.labels = labels;
        this.cuisineTypes = cuisineTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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
