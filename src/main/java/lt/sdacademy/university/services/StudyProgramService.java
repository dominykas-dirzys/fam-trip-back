package lt.sdacademy.university.services;

import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.repositories.StudyProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramService {

    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramService(StudyProgramRepository studyProgramRepository) {
        this.studyProgramRepository = studyProgramRepository;
    }

    public StudyProgramEntity save(StudyProgramEntity studyProgram) {
        return studyProgramRepository.save(studyProgram);
    }

    public StudyProgramEntity getStudyProgramByTitle(String title) {
        return studyProgramRepository.findOneByTitle(title);
    }

    public List<StudyProgramEntity> getStudyProgramByModuleTitle(String title) {
        return studyProgramRepository.findAllByModuleTitle(title);
    }
}
