package br.com.dwb.RunnerAPI.repository;

import br.com.dwb.RunnerAPI.entity.RunwayStorage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunwayStorageRepository extends JpaRepository <RunwayStorage, Long> {
}
