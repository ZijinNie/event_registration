package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Promoter;
import ca.mcgill.ecse321.eventregistration.model.Registration;

public interface PromoterRepository extends CrudRepository<Promoter, String>{
	Promoter findByName(String name);
	
}
