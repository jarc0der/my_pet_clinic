package my.petclinic.owner;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OwnerController {

	private OwnerRepository repository = new OwnerRepository();
	
	
	/*
	 * method set Owner object in the PageContext and render new_owner form
	 */
	@RequestMapping(value="/owners/new", method=RequestMethod.GET)
	public String addNewOwner(Model model){
		
		model.addAttribute("owner", new Owner());
		
		return "new_owner";
	}
	
	/*
	 * This method process form data of creation new owner
	 */
	@RequestMapping(value="/owners/new", method=RequestMethod.POST)
	public String processCreationForm(@ModelAttribute("owner") @Valid Owner owner, BindingResult binding){
		
		if(binding.hasErrors()){
			return "new_owner";
		}
		
		System.out.println("Save onwer in /new");

		repository.saveOwner(owner);
		
		return "redirect:/owners/" + owner.getId();
	}
	
	@RequestMapping("/owners/{owner_id}")
	public String showOwner(@PathVariable("owner_id") int ownerId, Model model){
		//retrieve data about owner from DB
		
		Owner repoOwner = repository.getOwnerById(ownerId);
		
		model.addAttribute("findOwner", repoOwner);
		
		return "info_owner";
	}
	
	@RequestMapping("/owners/{owner_id}/edit")
	public String showEditForm(@PathVariable("owner_id") int ownerId, Model model){
		Owner stub = repository.getOwnerById(ownerId);
		System.out.println("Edit id " + stub.getId());
		model.addAttribute("owner", stub);
		
		return "new_owner";
	}
	
	@RequestMapping(value="/owners/{owner_id}/edit", method=RequestMethod.POST)
	public String processEditForm(@PathVariable("owner_id") int ownerId,
			@ModelAttribute("owner") @Valid Owner owner, BindingResult results){
		
		if(results.hasErrors()){
			return "new_owner";
		}else{
			owner.setId(ownerId);
			repository.updateOwner(owner);
			
			System.out.println("Save owner in processEditor");
			return "redirect:/owners/" + ownerId;
		}
	}
	
	
	@RequestMapping(value="/owners/find", method=RequestMethod.GET)
	public String findOwner(Model model){
		model.addAttribute("owner", new Owner());
		
		return "find_owner";
	}
	
	@RequestMapping(value="/owners", method=RequestMethod.POST)
	public String processFindOwners(Owner owner, BindingResult result, Model model){
		System.out.println(owner.getLastName());
		List<Owner> resultList = repository.getOwnersByName(owner.getLastName());
		
		System.out.println("in post");
		if(result.hasErrors() || resultList.isEmpty()){
			return "find_owner";
			
		}else if(resultList.size() == 1){
			System.out.println("in post size == 1");
			Owner ownerLocal = resultList.iterator().next();
			
			return "redirect:/owners/" + ownerLocal.getId();
		}else{
			System.out.println(resultList);
			System.out.println("go to lsit owners");
			model.addAttribute("selection", resultList);
			return "list_owners";
		}
				
	}
}
