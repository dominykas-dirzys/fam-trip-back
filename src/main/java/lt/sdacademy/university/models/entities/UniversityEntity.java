package lt.sdacademy.university.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "university")
public class UniversityEntity extends AbstractEntity {

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "university", orphanRemoval = true)
    private List<StudyProgramEntity> studyPrograms = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<StudyProgramEntity> getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(List<StudyProgramEntity> studyPrograms) {
        this.studyPrograms = studyPrograms;
    }
}
