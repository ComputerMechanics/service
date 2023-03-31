package ro.unibuc.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.unibuc.hello.data.Car;
import ro.unibuc.hello.dto.Greeting;
import ro.unibuc.hello.service.CarService;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class CarControllerTest {

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkByNumarInmatriculare() throws Exception {
        // Arrange
        Car car = new Car("1","B100ABC", "60", "Audi", "A5", true);

        when(carService.findByNumarInmatriculare(any())).thenReturn(car);

        // Act
        MvcResult result = mockMvc.perform(get("/numar-inmatriculare?numar=B100ABC")
                        .content(objectMapper.writeValueAsString(car))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(car));
    }

    @Test
    void getParcarePlatita() throws Exception {
        // Arrange
        Car c1 = new Car("1","B100ABC", "60", "Audi", "A5", true);
        Car c2 = new Car("2","B101ABC", "70", "BMW", "X5", true);

        ArrayList<Car> cars = new ArrayList<>(){{add(c1); add(c2);}};
        when(carService.findAllByParcarePlatita(true)).thenReturn(cars);

        // Act
        MvcResult result = mockMvc.perform(get("/parcare-platita?platit=true")
                        .content(objectMapper.writeValueAsString(cars))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(cars));
    }

    @Test
    void testGetParcarePlatitaCuValabilitateMica() throws Exception {
        // Arrange
        Car c1 = new Car("1","B100ABC", "60", "Audi", "A5", true);
        Car c2 = new Car("2","B101ABC", "70", "BMW", "X5", true);

        ArrayList<Car> cars = new ArrayList<>(){{add(c1); add(c2);}};
        when(carService.findAllByValabilitateParcareIsLessThan60()).thenReturn(cars);

        // Act
        MvcResult result = mockMvc.perform(get("/valabilitate-mica")
                        .content(objectMapper.writeValueAsString(cars))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(cars));
    }

    @Test
    void saveCar() throws Exception {
        // Arrange
        Car c1 = new Car("1","B100ABC", "60", "Audi", "A5", true);

        when(carService.saveCar(any())).thenReturn(c1);

        // Act
        MvcResult result = mockMvc.perform(post("/save")
                        .content(objectMapper.writeValueAsString(c1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(c1));
    }

    @Test
    void getByCityPrefix() throws Exception {
        // Arrange
        Car c1 = new Car("1","B100ABC", "60", "Audi", "A5", true);

        ArrayList<Car> cars = new ArrayList<>(){{add(c1);}};
        when(carService.findAllByCityPrefix(any())).thenReturn(cars);

        // Act
        MvcResult result = mockMvc.perform(get("/city-prefix?city=B")
                        .content(objectMapper.writeValueAsString(cars))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(cars));
    }
}