package my.petclinic.owner;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@ModelAttribute("owner")
	public Owner getOwner(@PathVariable(name="ownerId") int ownerId){
		return this.owners.getOwnerById(ownerId);
	}
	
	@ModelAttribute("types")
	public List<PetType> getPetTypes(){
		return this.pets.getAllTypes();
	}
	
	
    @RequestMapping(value = "/pets/new", method = RequestMethod.GET)
	public String showAddForm(Owner owner, Model model){
		Pet pet = new Pet();
    	
    	owner.addPet(pet);
		model.addAttribute("pet", pet);
		
		return CREATE_AND_UPDATE;
	}
    
    @RequestMapping(value = "/pets/new", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute("owner")Owner owner, @ModelAttribute("pet") Pet pet, Model model, BindingResult results){
    	
    	
    	return "redirect:/owners/{ownerId}";
    	
    		
    }
}
