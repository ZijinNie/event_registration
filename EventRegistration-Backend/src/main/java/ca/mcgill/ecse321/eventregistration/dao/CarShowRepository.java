package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.CarShow;
import ca.mcgill.ecse321.eventregistration.model.Registration;


public interface CarShowRepository extends CrudRepository<CarShow, String>{
	CarShow findCarShowByName(String name);
}
