# Solar System
En una galaxia lejana, existen tres civilizaciones. Vulcanos, Ferengis y Betasoides. Cada civilización vive en paz en su respectivo planeta. 

Dominan la predicción del clima mediante un complejo sistema informático.

A continuación el diagrama del sistema solar.

![Diagrama del sistema solar](https://github.com/pvgrajalesg/solarSystem/blob/master/imagenes/imagen1.PNG)

Premisas:

● El planeta Ferengi se desplaza con una velocidad angular de 1 grados/día en sentido horario. Su distancia con respecto al sol es de 500Km.
● El planeta Betasoide se desplaza con una velocidad angular de 3 grados/día en sentido horario. Su distancia con respecto al sol es de 2000Km.
● El planeta Vulcano se desplaza con una velocidad angular de 5 grados/día en sentido antihorario, su distancia con respecto al sol es de 1000Km.
● Todas las órbitas son circulares.

Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el sistema solar experimenta un período de sequía.

![Diagrama del sistema solar con planetas alineados con el sol](https://github.com/pvgrajalesg/solarSystem/blob/master/imagenes/imagen2.PNG)

Cuando los tres planetas no están alineados, forman entre sí un triángulo. Es sabido que en el momento en el que el sol se encuentra dentro del triángulo, el sistema solar experimenta un período de lluvia, teniendo éste, un pico de intensidad cuando el perímetro del triángulo está en su máximo.

![Diagrama del sistema solar con planetas haciendo un triangulo](https://github.com/pvgrajalesg/solarSystem/blob/master/imagenes/imagen3.PNG)

Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están alineados entre sí pero no están alineados con el sol.

![Diagrama del sistema solar con planetas alineados sin el sol](https://github.com/pvgrajalesg/solarSystem/blob/master/imagenes/imagen4.PNG)

Realizar un programa informático para poder predecir en los próximos 10 años:
1. ¿Cuántos períodos de sequía habrá?
2. ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?
3. ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá?

Bonus:
Para poder utilizar el sistema como un servicio a las otras civilizaciones, los Vulcanos requieren tener una base de datos con las condiciones meteorológicas de todos los días y brindar una API REST de consulta sobre las condiciones de un día en particular.
1) Generar un modelo de datos con las condiciones de todos los días hasta 10 años en adelante
utilizando un job para calcularlas.
2) Generar una API REST la cual devuelve en formato JSON la condición climática del día
consultado.
3) Hostear el modelo de datos y la API REST en un cloud computing libre (como APP Engine o
Cloudfoudry) y enviar la URL para consulta:
Ej: GET → http://….../clima?dia=566 → Respuesta: {“dia”:566, “clima”:”lluvia”}

## Solución

1. Se halla la posicón de cada planeta según el día

2. Para hallar cuando los planetas estan alineados entre si y con el sol se utiliza la siguiente fórmula:

    ![Formula utilizada para saber si dos planetas estan alineados](https://github.com/pvgrajalesg/solarSystem/blob/master/imagenes/imagen5.PNG)

3. Para hallar si los planetas formas un triangulo y el sol se encuentra dentro de este triangulo se utiliza la siguiente algoritmo (Fuente: http://www.dma.fi.upm.es/personal/mabellanas/tfcs/kirkpatrick/Aplicacion/algoritmos.htm#puntoInteriorAlgoritmo):

    La orientación de un triángulo es la misma que la orientación de sus tres vértices.

    Considerando el triángulo A1A2A3 y el punto P, el algoritmo queda como se muestra a continuación:

    1.1. Calcular la orientación del triángulo A1A2A3.

    El cálculo de la orientación de un triángulo se puede realizar según la siguiente fórmula:

    (A1.x - A3.x) * (A2.y - A3.y) - (A1.y - A3.y) * (A2.x - A3.x)

    Si el resultado es mayor o igual que 0, la orientación del triángulo será positiva. En caso contrario, la orientación del triángulo será negativa.

    1.2. Calcular la orientación de los triángulos que forma el punto P con los vértices del triángulo A1A2A3.

    Se calcula la orientación de los triángulos A1A2P, A2A3P, A3A1P, con el método explicado en el punto 1.

    1.3. En el caso de que la orientación del triángulo A1A2A3 sea positiva.

    Si las orientaciones de los tres triángulos que tienen como vértice el punto P, calculadas en el punto 2, son positivas el punto está dentro del triángulo.
    En caso contrario el punto está situado fuera del triángulo

    1.4. En el caso de que la orientación del triángulo A1A2A3 sea negativa:

    Si las orientaciones de los tres triángulos que triángulos que tienen como vértice el punto P son negativas, el punto está dentro del triángulo
    En caso contrario el punto está situado fuera del triángulo.

## Stack
Lenguaje: Java 8
Framework: Spring Boot.
Db: H2.

## Como usar

Api para obtener el pronóstico según el día: https://solasystem.ue.r.appspot.com/api/climateByDay?day=<number_of_the_day>

Para obtener las prediciones de 10 años: https://solasystem.ue.r.appspot.com/api/generatePronostic




