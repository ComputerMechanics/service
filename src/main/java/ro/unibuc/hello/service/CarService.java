package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.Car;
import ro.unibuc.hello.data.CarsRepository;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.dto.CarDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {

	@Autowired
	private CarsRepository carsRepository;


	public Car findByNumarInmatriculare(String numarInmatriculare) {
		return carsRepository.findByNumarInmatriculare(numarInmatriculare);
	}

	public List<Car> findAllByParcarePlatita(boolean platit) {
		return carsRepository.findAllByParcarePlatita(platit);
	}

	public Car saveCar(Car car) {
		return carsRepository.save(car);
	}

	public List<Car> findAllByValabilitateParcareIsLessThan60() {
		List<Car> lessThan60 = new ArrayList<>();
		List<Car> allPaid = findAllByParcarePlatita(true);
		for (Car car : allPaid) {
			if (Integer.parseInt(car.valabilitateParcare) <= 60)
				lessThan60.add(car);
		}
		return lessThan60;
	}
//	public List<Car> findAllByValabilitateParcareDesc() {
//		return carsRepository.findAllByValabilitateParcareDesc();
//	}

	public List<Car> findAllByCityPrefix(String cityPrefix) {
		return carsRepository.findAll().stream().filter((Car c) ->
				c.numarInmatriculare.startsWith(cityPrefix)
		).collect(Collectors.toList());
	}

}
