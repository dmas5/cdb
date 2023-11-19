package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@RestController
public class CarController {
	
    @Autowired
    private CarRepository repository;
    
//  Get all cars
	@RequestMapping("/cars")
	public Iterable<Car> getCars(){
		return repository.findAll();
	}
//  Add new car
	@PostMapping("cars")
	Car newCar(@RequestBody Car newCar) {
		return repository.save(newCar);
	}

//  Edit car
	@PutMapping("/cars/{id}")
	Car editCar(@RequestBody Car editedCar, @PathVariable Long id) {
		editedCar.setId(id);
		return repository.save(editedCar);
	}

}
