package br.com.dwb.RunnerAPI.repository;

import br.com.dwb.RunnerAPI.entity.Runway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunwayRepository extends JpaRepository <Runway, Long> {
}
