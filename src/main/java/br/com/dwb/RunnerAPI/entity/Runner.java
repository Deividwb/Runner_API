package br.com.dwb.RunnerAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "runners")
public class Runner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "sexo",nullable = false)
    private String sexo;

    @Column(name = "bodyTemperature",nullable = false)
    private String bodyTemperature;

    @Column(name = "weight",nullable = false)
    private String weight;

    @Column(name = "height",nullable = false)
    private String height;

    @OneToMany(mappedBy = "runner")
    private List <RunwayStorage> runwayStorages;

}

