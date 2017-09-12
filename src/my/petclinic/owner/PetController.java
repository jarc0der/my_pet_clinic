package my.petclinic.owner;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
	
	private static final String CREATE_AND_UPDATE = "new_pet";
	
	private OwnerRepository owners = new OwnerRepository();
	private PetRepository pets = new PetRepository();
	
//	@Autowired
//	public void initialization(OwnerRepository owners, PetRepository pets){
//		this.owners = owners;
//		this.pets = pets;
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new Formatter<PetType>() {

			@Override
		    public String print(PetType petType, Locale locale) {
		        return petType.getName();
		    }

		    @Override
		    public PetType parse(String text, Locale locale) throws ParseException {
		        Collection<PetType> findPetTypes = pets.getAllTypes();
		        for (PetType type : findPetTypes) {
		            if (type.getName().equals(text)) {
		                return type;
		            }
		        }
		        throw new ParseException("type not found: " + text, 0);
		    }
		});
	}
	
//	@InitBinder("pet")
//	public void initPetBinder(WebDataBinder binder) {
//		binder.addValidators(new PetValidator());
//	}
	
	
	@ModelAttribute("owner")
	public Owner getOwner(@PathVariable(name="ownerId") int ownerId){
		return this.owners.getOwnerById(ownerId);
	}
	
	@ModelAttribute("types")
	public List<PetType> getPetTypes(){
		return this.pets.getAllTypes();
	}
	
	@InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
	
    @RequestMapping(value = "/pets/new", method = RequestMethod.GET)
	public String showAddForm(Owner owner, Model model){
		Pet pet = new Pet();
    
    	owner.addPet(pet);
		model.addAttribute("pet", pet);
		
		return CREATE_AND_UPDATE;
	}
    
    @RequestMapping(value = "/pets/new", method = RequestMethod.POST)
    public String processAddForm(@Valid Pet pet, BindingResult results, Owner owner, Model model){
    	
    	if(results.hasErrors()) {
    		model.addAttribute(pet);
    		return CREATE_AND_UPDATE;
    	}
    	
    	owner.addPet(pet);
    	this.pets.savePet(pet);
    	
    	return "redirect:/owners/{ownerId}";
    }
    
    @RequestMapping(value = "/pets/{petId}/edit", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("petId") int petId, Model model) {
    	Pet currentPet = pets.getPetById(petId);
    	System.out.println(currentPet + " id: " + currentPet.getId());
    	
    	model.addAttribute("pet", currentPet);
    	
    	return CREATE_AND_UPDATE;
    }
    
    @RequestMapping(value = "/pets/{petId}/edit", method = RequestMethod.POST)
    public String processEditForm(Pet pet, Owner owner, BindingResult results, Model model) {
    	
    	if(results.hasErrors()) {
    		pet.setOwner(owner);
    		model.addAttribute("pet", pet);
    		return CREATE_AND_UPDATE;
    	}
//    	pet.setId(petId);
    	owner.addPet(pet);

    	this.pets.savePet(pet);
    	
    	return "redirect:/owners/{ownerId}";
    }
    
    
    /*
     * @PathVariable("petId") int petId, 
     * 
     */
    
    
    
    
    
    
    
    
}
