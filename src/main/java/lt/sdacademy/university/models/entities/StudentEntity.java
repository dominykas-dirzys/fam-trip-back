package lt.sdacademy.university.models.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lt.sdacademy.university.models.StudyType;

@Entity
@Table(name = "student")
public class StudentEntity extends AbstractEntity {

    @Column(name = "date_started", nullable = false)
    private LocalDate dateStarted;

    @Column(name = "study_type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyType studyType;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "study_program_id", nullable = false)
    private StudyProgramEntity studyProgram;

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public StudyProgramEntity getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgramEntity studyProgram) {
        this.studyProgram = studyProgram;
    }
}
