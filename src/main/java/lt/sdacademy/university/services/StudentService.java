package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.StudyType;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }

    public List<StudentEntity> getStudentsByGender(Gender gender) {
        return studentRepository.findAllByPersonGender(gender);
    }

    public List<StudentEntity> getStudentsByStudyProgram(String studyProgram) {
        return studentRepository.findAllByStudyProgram(studyProgram);
    }

    public List<StudentEntity> getStudentsByStudyType(StudyType studyType) {
        return studentRepository.findAllByStudyType(studyType);
    }

    public List<StudentEntity> getStudentsByStudyTypeModule(StudyType studyType, String title) {
        return studentRepository.findAllByStudyTypeModule(studyType, title);
    }
}
