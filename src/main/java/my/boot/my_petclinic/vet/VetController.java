package my.boot.my_petclinic.vet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

	private VetRepository vets;
	
	@Autowired
	public VetController(VetRepository vets) {
		this.vets = vets;
	}
	
	
	@RequestMapping(value = "/vets")
	public String initShowVets(Model model) {
		List<Vet> vetsList = vets.findAll();
		
		model.addAttribute("vets", vetsList);
		
		return "list_vets";
	}
	
}
