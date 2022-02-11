package br.com.dwb.RunnerAPI.dto;

import java.util.Date;

public interface RunwayStorageDto {

     Long getId();
     String getRunner();
     String getRunway();
     Date getDateRunWay();
     Double getUsedTime();
}
