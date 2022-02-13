package com.galaxy.solarSystem.repository.Pronostic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pronostics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PronosticData {

    @Id
    @GeneratedValue
    private Long id;

    private int day;

    private String climate;

    private double perimeter;
}
