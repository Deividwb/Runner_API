package br.com.dwb.RunnerAPI.controller;

import br.com.dwb.RunnerAPI.dto.RunwayStorageDto;
import br.com.dwb.RunnerAPI.entity.RunwayStorage;
import br.com.dwb.RunnerAPI.response_dto.StorageResponseDto;
import br.com.dwb.RunnerAPI.service.RunwayService;
import br.com.dwb.RunnerAPI.service.RunwayStorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/runways-storage")
public class RunwayStorageController {

    @Autowired
    private RunwayStorageService runwayStorageService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StorageResponseDto save(@RequestBody StorageResponseDto storageResponseDto) {
        return runwayStorageService.saveStorageDto(storageResponseDto);

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public RunwayStorage save(@RequestBody RunwayStorage runwayStorage) {
//        return runwayStorageService.save(runwayStorage);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<RunwayStorage> listAllRunWaysStorage(){
//        return runwayStorageService.listAllRunWaysStorage();
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RunwayStorageDto> listStorageDto() {
        return runwayStorageService.listAllStorageDto();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RunwayStorage listRunWaysStorageById(@PathVariable("id") Long id) {
        return runwayStorageService.ListRunWaysStorageById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Runways-Sorage not found"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void upDateRunWayStorage(@PathVariable("id") Long id, @RequestBody RunwayStorage runwayStorage) {
        runwayStorageService.ListRunWaysStorageById(id)
                .map(runwayStorageBase -> {
                    modelMapper.map(runwayStorage, runwayStorageBase);
                    runwayStorageService.save(runwayStorageBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Runways-Sorage not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRunwayStorage(@PathVariable("id") Long id) {
        runwayStorageService.ListRunWaysStorageById(id)
                .map(runwayStorage -> {
                    runwayStorageService.deleteRunWayStorage(runwayStorage.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Runways-Sorage not found"));
    }


}
