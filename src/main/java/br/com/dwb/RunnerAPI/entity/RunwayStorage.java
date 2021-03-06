package br.com.dwb.RunnerAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RunwayStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "runner_id")
    private Runner runner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "runway_id")
    private  Runway runway;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "usedtime", nullable = false)
    private Double usedtime;
}