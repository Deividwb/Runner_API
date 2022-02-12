package br.com.dwb.RunnerAPI.repository;

import br.com.dwb.RunnerAPI.dto.RunwayStorageDto;
import br.com.dwb.RunnerAPI.entity.RunwayStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RunwayStorageRepository extends JpaRepository<RunwayStorage, Long> {

    @Query(value = "SELECT RUNWAYS-STORAGE.ID, NAME AS RUNNER, DESCRIPTION AS RUNWAY, DATE AS DATERUNWAY, USEDTIME   " +
            "FROM RUNWAYS-STORAGE  JOIN RUNNER  ON RUNWAYS-STORAGE.RUNNER_ID = RUNNER .ID " +
            "JOIN RUNWAYS ON RUNWAYS-STORAGE.RUNWAY_ID = RUNWAYS.ID", nativeQuery = true)
    List<RunwayStorageDto> finAllDto();
}
