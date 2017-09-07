package my.petclinic.vet;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

	private VetRepository vets = new VetRepository();
	
	@RequestMapping(value = "/vets")
	public String initShowVets(Model model) {
		List<Vet> vetsList = vets.getAllVets();
		
		model.addAttribute("vets", vetsList);
		
		return "list_vets";
	}
	
}
