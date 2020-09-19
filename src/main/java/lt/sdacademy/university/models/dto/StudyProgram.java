package lt.sdacademy.university.models.dto;

import java.util.List;

public class StudyProgram {

    private Long id;

    private String title;

    private List<String> modules;

    public StudyProgram() {
    }

    public StudyProgram(Long id, String title, List<String> modules) {
        this.id = id;
        this.title = title;
        this.modules = modules;
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

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }
}
