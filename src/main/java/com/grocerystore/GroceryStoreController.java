<<<<<<< Updated upstream
package com.grocerystore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.service.IGroceryService;

@Controller
public class GroceryStoreController {
	
	@Autowired
	private IGroceryService groceryServiceStub;
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String read(Model model) {
		GroceryDTO groceryDTO = groceryServiceStub.fetchById(9);
		model.addAttribute("groceryDTO", groceryDTO);
		return "home";
	}
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET, headers= {"content-type=text/json"})
	public String readJSON() {
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
	
	@RequestMapping("/")
	public String index() {
		
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

}
=======
package com.grocerystore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.service.IGroceryService;

@Controller
public class GroceryStoreController {
	
	@Autowired
	private IGroceryService groceryServiceStub;
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	@ResponseBody
	public GroceryDTO read(Model model) {
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
		groceryDTO.setName("apple");
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
	public GroceryDTO addGrocery(Model model) {
		GroceryDTO groceryDTO = groceryServiceStub.fetchById(9);
		model.addAttribute("groceryDTO", groceryDTO);
		return groceryDTO;
	}
	
	
	/**
	 * Handle the /home endpoint.
	 * @return
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET, headers= {"content-type=text/json"})
	public String readJSON() {
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

}
>>>>>>> Stashed changes
