package br.com.dwb.RunnerAPI.repository;

import br.com.dwb.RunnerAPI.entity.Runner;
import br.com.dwb.RunnerAPI.entity.Runway;
import br.com.dwb.RunnerAPI.response_dto.StorageResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository <StorageResponseDto,Runner> {
}
