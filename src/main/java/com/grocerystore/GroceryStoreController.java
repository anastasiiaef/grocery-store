package com.grocerystore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.ItemDTO;
import com.grocerystore.service.IGroceryService;

@Controller
public class GroceryStoreController {
	
	@Autowired
	private IGroceryService groceryServiceStub;
	
	@RequestMapping(value="/savegrocery")
	public String saveGrocery(GroceryDTO groceryDTO) {
		groceryDTO.setGroceryId(5);
		return "home";
	}
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET, headers= {"content-type=text/json"})
	@ResponseBody
	public GroceryDTO readJSON(Model model) {
		GroceryDTO groceryDTO = groceryServiceStub.fetchById(9);
		model.addAttribute("groceryDTO", groceryDTO);
		return groceryDTO;
	}
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/home", method = RequestMethod.GET, params= {"apple"})
	public ModelAndView readGrocery() {
		GroceryDTO groceryDTO = groceryServiceStub.fetchById(9);
		groceryDTO.setName("Apple");
		groceryDTO.setDescription("Fruit");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("groceryDTO", groceryDTO);
		return modelAndView;
	}
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/addgrocery", method = RequestMethod.GET)
	public String addGrocery(Model model, @RequestParam (value="name", required=false, defaultValue=" ") String name) {
		GroceryDTO groceryDTO = groceryServiceStub.fetchById(9);
		groceryDTO.setName(name);
		model.addAttribute("groceryDTO", groceryDTO);
		return "home";
	}
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String read(Model model ) {
		model.addAttribute("groceryDTO", new GroceryDTO());
		return "home";
	}
		
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@PostMapping("/home")
	public String create() {
		return "home";
	}

	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@PutMapping("/home")
	public String update() {
		return "home";
	}
	
	@DeleteMapping("/home")
	public String delete() {
		return "home";
	}
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/searchItems")
	public String searchItems(@RequestParam (value="searchTerm", required=false, defaultValue=" ") String searchTerm) {
		String enhancedTerm = searchTerm  + "";	
		ModelAndView moselAndView = new ModelAndView();
		try {
			List<ItemDTO> fetchItems = groceryServiceStub.fetchItems(searchTerm);			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "home";	
	}
	
	@RequestMapping(value="/sustainability")
	public String sustainbility () {
		return "sustainability";
	}

}
