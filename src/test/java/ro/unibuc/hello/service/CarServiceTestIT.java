package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.Car;
import ro.unibuc.hello.data.CarsRepository;

@SpringBootTest
public class CarServiceTestIT {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CarService carService;


    @Test
    public void testFindByNumarInmatriculare() {

        String nr_inamtriculare = "B100ABC";

        Car car = carService.findByNumarInmatriculare(nr_inamtriculare);

        Assertions.assertEquals("60", car.getValabilitateParcare());
        Assertions.assertEquals("Audi", car.getMarca());
        Assertions.assertEquals("A5", car.getModel());

    }

//    @Test
//    public void testFindAllByParcarePlatita() {
//    }
//
//    @Test
//    public void testSaveCar() {
//    }
//
//    @Test
//    public void testFindAllByValabilitateParcareIsLessThan60() {
//    }
//
//    @Test
//    public void testFindAllByCityPrefix() {
//    }
}