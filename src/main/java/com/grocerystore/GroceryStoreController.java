package com.grocerystore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String read() {
		GroceryDTO groceryDTO = groceryServiceStub.fetchById(9);
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
