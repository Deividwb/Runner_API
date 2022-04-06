package br.com.dwb.RunnerAPI.response_dto;

import br.com.dwb.RunnerAPI.entity.Runner;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class StorageResponseDto{




    @Column(name = "runner")
    private String runner;

    @Column(name = "runway")
    private String runway;

    @Column(name = "runway_storage")
    private Date dateRunway;

    @Column(name = "runway_storage")
    private Double usedTime;

}
