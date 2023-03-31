package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.unibuc.hello.data.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarDTOTest {
    Car car = new Car();
    CarDTO car2 = new CarDTO();

    @Test
    void getId() {
        car.setId("2");
        Assertions.assertSame("2", car.getId());
    }

    @Test
    void getNumarInmatriculare() {
        car.setNumarInmatriculare("B100BBB");
        Assertions.assertSame("B100BBB", car.getNumarInmatriculare());
    }

    @Test
    void getValabilitateParcare() {
        car.setValabilitateParcare("40");
        Assertions.assertSame("40", car.getValabilitateParcare());
    }

    @Test
    void getMarca() {
        car.setMarca("Kia");
        Assertions.assertSame("Kia", car.getMarca());
    }

    @Test
    void getModel() {
        car.setModel("Ceed");
        Assertions.assertSame("Ceed", car.getModel());
    }

    @Test
    void getParcarePlatita() {
        car.setParcarePlatita(false);
        Assertions.assertSame(false, car.getParcarePlatita());
    }

    @Test
    void getIdDTO() {
        car2.setId("2");
        Assertions.assertSame("2", car2.getId());
    }

    @Test
    void getNumarInmatriculareDTO() {
        car2.setNumarInmatriculare("B100BBB");
        Assertions.assertSame("B100BBB", car2.getNumarInmatriculare());
    }

    @Test
    void getValabilitateParcareDTO() {
        car2.setValabilitateParcare("40");
        Assertions.assertSame("40", car2.getValabilitateParcare());
    }

    @Test
    void getMarcaDTO() {
        car2.setMarca("Kia");
        Assertions.assertSame("Kia", car2.getMarca());
    }

    @Test
    void getModelDTO() {
        car2.setModel("Ceed");
        Assertions.assertSame("Ceed", car2.getModel());
    }

    @Test
    void getParcarePlatitaDTO() {
        car2.setParcarePlatita(false);
        Assertions.assertSame(false, car2.getParcarePlatita());
    }
}