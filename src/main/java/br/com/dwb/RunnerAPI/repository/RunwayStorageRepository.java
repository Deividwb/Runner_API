package br.com.dwb.RunnerAPI.repository;

import br.com.dwb.RunnerAPI.dto.RunwayStorageDto;
import br.com.dwb.RunnerAPI.entity.RunwayStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RunwayStorageRepository extends JpaRepository<RunwayStorage, Long> {

    @Query(value = "SELECT RUNWAY_STORAGE.ID, RUNNER.NAME AS RUNNER, RUNWAY.NAME AS RUNWAY, DATE AS DATERUNWAY, USEDTIME " +
            "FROM RUNWAY_STORAGE JOIN RUNNER ON RUNWAY_STORAGE.RUNNER_ID = RUNNER.ID " +
            "JOIN RUNWAY ON RUNWAY_STORAGE.RUNWAY_ID = RUNWAY.ID ", nativeQuery = true)
    List<RunwayStorageDto> finAllDto();


}
