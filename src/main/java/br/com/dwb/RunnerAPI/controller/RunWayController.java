package br.com.dwb.RunnerAPI.controller;

import br.com.dwb.RunnerAPI.entity.Runway;
import br.com.dwb.RunnerAPI.service.RunwayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/runways")
public class RunWayController {

    @Autowired
    private RunwayService runwayService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Runway save (@RequestBody Runway runway){
        return runwayService.save(runway);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Runway> listAllRunWays(){
        return runwayService.listAllRunWays();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Runway listRunWaysById(@PathVariable("id") Long id) {
        return runwayService.ListRunWaysById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Runner not found"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void upDateRunner(@PathVariable ("id") Long id, @RequestBody Runway runway) {
        runwayService.ListRunWaysById(id)
                .map(runwayBase ->{
                    modelMapper.map(runway, runwayBase);
                    runwayService.save(runwayBase);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Runner not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRunway(@PathVariable ("id") Long id) {
        runwayService.ListRunWaysById(id)
                .map(runway ->{
                    runwayService.deleteRunWay(runway.getId());
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Runner not found"));
    }
}
