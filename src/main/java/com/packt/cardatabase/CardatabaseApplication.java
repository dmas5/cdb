package com.packt.cardatabase;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.AppUser;
import com.packt.cardatabase.domain.AppUserRepository;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
    private CarRepository repository;
	@Autowired
	private OwnerRepository orepository;
	@Autowired
	private AppUserRepository urepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
	    Owner owner1 = new Owner("John" , "Johnson");
	    orepository.save(owner1);
		
		repository.save(new Car("BMW", "M5", "blue", "KJI-455", 2020,80000,owner1));
		repository.save(new Car("BMW", "M3", "white", "CII-400", 2022,50000,owner1));
		repository.save(new Car("Audi", "A6", "green", "NKL-971", 2015,40000,owner1));
		repository.save(new Car("Audi", "A4", "white", "MVN-244", 2014,65000,owner1));
		repository.save(new Car("Volvo", "V6", "green", "ABC-867", 2018,75000,owner1));
		repository.save(new Car("Skoda", "Fabia", "blue", "UKM-222", 2021,20000,owner1));
		repository.save(new Car("Renault", "Clio", "blue", "OPP-127", 2021,25000,owner1));
		urepository.save(new AppUser("user", 
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		urepository.save(new AppUser("admin", 
				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));

		
		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}

}
