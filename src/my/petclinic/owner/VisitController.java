package my.petclinic.owner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.petclinic.visit.Visit;
import my.petclinic.visit.VisitRepository;


@Controller
public class VisitController {
	
	private PetRepository pets = new PetRepository();
	private VisitRepository visits = new VisitRepository();

	
	@ModelAttribute("visit")
	public Visit initVisit(@PathVariable("petId") int petId, Model model) {
		Pet pet = pets.getPetById(petId);
		System.out.println(pet);
		model.addAttribute("pet", pet);
		
		Visit visit = new Visit();
		pet.addVisit(visit);
		
		return visit;
	}
	
	
	@RequestMapping(value = "/owners/*/pets/{petId}/visits/new")
	public String initVisitForm(Model model) {
		return "new_visit";
	}
	
	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}/visits/new", method=RequestMethod.POST)
	public String proccessVisitForm(Visit visit, Model model, BindingResult results) {
		if(results.hasErrors()) {
			return "new_visit";
		}
		
		this.visits.saveVisit(visit);
		
		return "redirect:/owners/{ownerId}";
	}
	
}
