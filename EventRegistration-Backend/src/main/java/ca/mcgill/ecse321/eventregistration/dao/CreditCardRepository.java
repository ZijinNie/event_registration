package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.CreditCard;
import ca.mcgill.ecse321.eventregistration.model.Registration;

public interface CreditCardRepository extends CrudRepository<CreditCard,String>{
	CreditCard findCreditCardByAccountNumber(String id);
	
}
