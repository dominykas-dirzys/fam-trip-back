package lt.sdacademy.university.services;

import lt.sdacademy.university.models.entities.ModuleEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ModuleService {
    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<ModuleEntity> getModules() {
        return moduleRepository.findAll();
    }

    public List<ModuleEntity> getModulesByTitle(String title) {
        return moduleRepository.findAllByTitle(title);
    }

    public List<ModuleEntity> getModulesByTitleNot(String title) {
        return moduleRepository.findAllByTitleNot(title);
    }

    public List<ModuleEntity> getModulesByTitleIn(Collection<String> titles) {
        return moduleRepository.findAllByTitleIn(titles);
    }

    public List<ModuleEntity> getModulesByTitleLike(String title) {
        return moduleRepository.findAllByTitleLike(title);
    }

    public List<ModuleEntity> getModulesByTitleContains(String title) {
        return moduleRepository.findAllByTitleContains(title);
    }

    public ModuleEntity save(ModuleEntity moduleEntity) {
        return moduleRepository.save(moduleEntity);
    }
}
