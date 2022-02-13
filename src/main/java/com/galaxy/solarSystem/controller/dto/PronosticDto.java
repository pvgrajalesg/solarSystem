package com.galaxy.solarSystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PronosticDto {

    private Long id;
    private int day;
    private String climate;
}
