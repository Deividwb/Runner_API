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
@Table(name = "runways-storage")
public class RunwayStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "runners_id")
    private Runner runners;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "runways_id")
    private  Runway runways;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "usedtime", nullable = false)
    private Double usedtime;
}