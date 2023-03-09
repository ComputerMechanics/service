package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.Car;
import ro.unibuc.hello.data.CarsRepository;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.dto.CarDTO;

import java.util.List;

@Component
public class CarService {

	@Autowired
	private CarsRepository carsRepository;

	public Car findByNumarInmatriculare(String numarInmatriculare) {
		return carsRepository.findByNumarInmatriculare(numarInmatriculare);
	}

	public Car findByParcarePlatita(boolean platit) {
		return carsRepository.findByParcarePlatita(platit);
	}

//	public List<Car> findAllByValabilitateParcareDesc() {
//		return carsRepository.findAllByValabilitateParcareDesc();
//	}
}
