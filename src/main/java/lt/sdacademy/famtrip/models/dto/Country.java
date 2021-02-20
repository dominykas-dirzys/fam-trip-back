package lt.sdacademy.famtrip.models.dto;

public class Country {
    private Long id;
    private String title;

    public Country() {
    }

    public Country(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
