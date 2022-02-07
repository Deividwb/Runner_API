package br.com.dwb.RunnerAPI.service;

import br.com.dwb.RunnerAPI.entity.Runway;
import br.com.dwb.RunnerAPI.repository.RunwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RunwayService {

    @Autowired
    private RunwayRepository runwayRepository;

    public Runway save (Runway runWays) {
        return runwayRepository.save(runWays);
    }

    public List<Runway> listAllRunWays(){
        return runwayRepository.findAll();
    }

    public Optional<Runway> ListRunWaysById(Long id){
        return runwayRepository.findById(id);
    }

    public void deleteRunWay(Long id){
        runwayRepository.deleteById(id);
    }
}

