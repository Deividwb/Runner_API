package br.com.dwb.RunnerAPI.repository;

import br.com.dwb.RunnerAPI.entity.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository <Runner, Long> {
}
