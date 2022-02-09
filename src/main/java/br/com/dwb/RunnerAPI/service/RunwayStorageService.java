package br.com.dwb.RunnerAPI.service;

import br.com.dwb.RunnerAPI.entity.RunwayStorage;
import br.com.dwb.RunnerAPI.repository.RunwayStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RunwayStorageService {

    @Autowired
    private RunwayStorageRepository runwayStorageRepository;

    public RunwayStorage save (RunwayStorage runwayStorage) {
        return runwayStorageRepository.save(runwayStorage);
    }

    public List<RunwayStorage> listAllRunWaysStorage(){
        return runwayStorageRepository.findAll();
    }

    public Optional<RunwayStorage> ListRunWaysStorageById(Long id){
        return runwayStorageRepository.findById(id);
    }

    public void deleteRunWayStorage(Long id){
        runwayStorageRepository.deleteById(id);
    }
}
