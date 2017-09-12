package my.petclinic.owner;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import antlr.StringUtils;

@Component
public class PetValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Pet.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Pet pet = (Pet)obj;
		
		if(pet.getName() == null || pet.getName().length() == 0)
			errors.rejectValue("name", "reject");

	}

}
