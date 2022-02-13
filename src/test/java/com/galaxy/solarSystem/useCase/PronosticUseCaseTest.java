package com.galaxy.solarSystem.useCase;

import com.galaxy.solarSystem.model.Period;
import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.Pronostic;
import com.galaxy.solarSystem.model.gateways.PlanetRepository;
import com.galaxy.solarSystem.model.gateways.PronosticRepository;
import com.galaxy.solarSystem.useCase.util.ClimateEnum;
import com.galaxy.solarSystem.useCase.util.PlanetEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = PronosticUseCase.class)
public class PronosticUseCaseTest {

    @Mock
    private PronosticRepository pronosticRepository;

    @Mock
    private PlanetRepository planetRepository;

    @InjectMocks
    private PronosticUseCaseImp pronosticUseCase;

    @Test
    public void climateByDayReturnOptimunTest(){
        int daySearch = 1;

        Pronostic pronosticSearch = Pronostic.builder().day(daySearch).climate(ClimateEnum.OPTIMUN.toString()).build();

        Mockito.when(pronosticRepository.climateByDay(daySearch)).thenReturn(pronosticSearch);
        Pronostic pronostic = pronosticUseCase.climateByDay(daySearch);

        Assert.assertNotNull(pronostic);
        Assert.assertEquals(pronostic.getClimate(), ClimateEnum.OPTIMUN.toString());
    }

    @Test
    public void generatedPronosticCorrectRequestTest(){

        int daySearch = 1;

        Pronostic pronosticSearch = Pronostic.builder().day(daySearch).climate(ClimateEnum.OPTIMUN.toString()).build();
        List<Pronostic> pronostics = new ArrayList<>();
        pronostics.add(pronosticSearch);

        Mockito.when(pronosticRepository.getAllPronostic()).thenReturn(pronostics);

        List<Period> periods = pronosticUseCase.generatePeriods();

        Assert.assertNotNull(periods);
        Assert.assertTrue(periods.size()>=1);
    }
}
