package com.galaxy.solarSystem.model;

import com.galaxy.solarSystem.useCase.util.ClimateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Period {

    private ClimateEnum typeClimate;
    private long Quantity;

}
