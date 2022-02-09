package br.com.dwb.RunnerAPI.controller;

import br.com.dwb.RunnerAPI.entity.Runway;
import br.com.dwb.RunnerAPI.entity.RunwayStorage;
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
    public RunwayStorage save (@RequestBody RunwayStorage runwayStorage){
        return runwayStorageService.save(runwayStorage);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RunwayStorage> listAllRunWaysStorage(){
        return runwayStorageService.listAllRunWaysStorage();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RunwayStorage listRunWaysStorageById(@PathVariable("id") Long id) {
        return runwayStorageService.ListRunWaysStorageById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Runways-Sorage not found"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void upDateRunner(@PathVariable ("id") Long id, @RequestBody Runway runway) {
        runwayStorageService.ListRunWaysStorageById(id)
                .map(runwayStorageBase ->{
                    modelMapper.map(runway, runwayStorageBase);
                    runwayStorageService.save(runwayStorageBase);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Runways-Sorage not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRunway(@PathVariable ("id") Long id) {
        runwayStorageService.ListRunWaysStorageById(id)
                .map(runwayStorage ->{
                    runwayStorageService.deleteRunWayStorage(runwayStorage.getId());
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Runways-Sorage not found"));
    }
}
