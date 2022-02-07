package br.com.dwb.RunnerAPI.service;

import br.com.dwb.RunnerAPI.entity.Runner;
import br.com.dwb.RunnerAPI.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class RunnerService {

    @Autowired
    private RunnerRepository runnerRepository;

    public Runner save (Runner runner) {
        return runnerRepository.save(runner);
    }

    public List <Runner> listAllRunners(){
        return runnerRepository.findAll();
    }

    public Optional <Runner> ListRunnerById(Long id){
        return runnerRepository.findById(id);
    }

    public void deleteRunner(Long id){
        runnerRepository.deleteById(id);
    }
}

