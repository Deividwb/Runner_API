package br.com.dwb.RunnerAPI.service;

import br.com.dwb.RunnerAPI.dto.RunwayStorageDto;
import br.com.dwb.RunnerAPI.entity.RunwayStorage;
import br.com.dwb.RunnerAPI.repository.RunwayStorageRepository;
import br.com.dwb.RunnerAPI.repository.StorageRepository;
import br.com.dwb.RunnerAPI.response_dto.StorageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RunwayStorageService {

    @Autowired
    private RunwayStorageRepository runwayStorageRepository;
    private StorageRepository storageRepository;

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

    public List<RunwayStorageDto> listAllStorageDto() {
        return runwayStorageRepository.finAllDto();
    }

    public StorageResponseDto saveStorageDto(StorageResponseDto storageResponseDto){
        return storageRepository.save(storageResponseDto);
    }
}
