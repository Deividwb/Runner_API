package br.com.dwb.RunnerAPI.controller;

import br.com.dwb.RunnerAPI.entity.Runner;
import br.com.dwb.RunnerAPI.service.RunnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/runners")
public class RunnerController {

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Runner save (@RequestBody Runner runner){
        return runnerService.save(runner);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Runner> listAllRunners(){
        return runnerService.listAllRunners();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Runner listRunnerById(@PathVariable ("id") Long id) {
        return runnerService.ListRunnerById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Runner not found"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void upDateRunner(@PathVariable ("id") Long id, @RequestBody Runner runner) {
        runnerService.ListRunnerById(id)
                .map(runnerBase ->{
                    modelMapper.map(runner, runnerBase);
                    runnerService.save(runnerBase);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Runner not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRunner(@PathVariable ("id") Long id) {
        runnerService.ListRunnerById(id)
                .map(runners ->{
                    runnerService.deleteRunner(runners.getId());
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Runner not found"));
    }

}

