package com.grocerystore;

import java.util.List;

import org.slf4j.LoggerFactory;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.ItemDTO;
import com.grocerystore.dto.LabelValueDTO;
import com.grocerystore.dto.PhotoDTO;
import com.grocerystore.service.IGroceryService;

@Controller
public class GroceryStoreController {
	
	//Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IGroceryService groceryServiceStub;
	
	@PostMapping(value="/savegrocery")
	public ModelAndView saveGrocery(@RequestParam("imageFile") MultipartFile imageFile, GroceryDTO groceryDTO) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			groceryServiceStub.save(groceryDTO);
		} catch (Exception e) {
			log.error("unable to save", e);
			e.printStackTrace();
			modelAndView.setViewName("error");
			return modelAndView;
		}	
		PhotoDTO photoDTO = new PhotoDTO();
		photoDTO.setFileName(imageFile.getOriginalFilename());
		photoDTO.setPath("/photo/");
		photoDTO.setGroceryDTO(groceryDTO);
		modelAndView.setViewName("success");
		try {
			groceryServiceStub.saveImage(imageFile, photoDTO);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error saving photo", e);
			modelAndView.setViewName("error");
			return modelAndView;
		}		
		modelAndView.addObject("photoDTO", photoDTO);
		modelAndView.addObject("groceryDTO" ,groceryDTO);
		return modelAndView;
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
		log.info("User has entered the /home endpoint");
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
	public ModelAndView searchItems(@RequestParam (value="searchTerm", required=false, defaultValue=" ") String searchTerm) {
		ModelAndView modelAndView = new ModelAndView();
		List<ItemDTO> items = new ArrayList<ItemDTO>();
		try {
			items = groceryServiceStub.fetchItems(searchTerm);
			modelAndView.setViewName("itemResults");
			if(items.size() == 0) {
				log.warn("Received 0 results for search string: " + searchTerm);
			}
		} catch (Exception e) {
			log.error("Error happened in searchItem endpoint", e);
			e.printStackTrace();
			modelAndView.setViewName("error");
		}
		modelAndView.addObject("items", items);
		log.debug("exiting search Items");
		return modelAndView;	
	}
	
	@RequestMapping(value="/sustainability")
	public String sustainbility () {
		return "sustainability";
	}
	
	@RequestMapping(value="/itemNameAutocomplete")
	@ResponseBody
	public List<LabelValueDTO> itemNameAutocomplete(@RequestParam(value="term", required = false, defaultValue = "") String term) {		
		List<LabelValueDTO> suggestions = new ArrayList<LabelValueDTO>();
		try {
			List<ItemDTO> allItems = groceryServiceStub.fetchItems(term);
			for (ItemDTO itemDTO: allItems) {
				LabelValueDTO lv = new LabelValueDTO();
				lv.setLabel(itemDTO.toString());
				lv.setValue(Integer.toString(itemDTO.getGuid()));
				suggestions.add(lv);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in autocomplete", e);
		}
		return suggestions; 
	}
	
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
		String returnValue = "home";
		
		PhotoDTO photoDTO = new PhotoDTO();
		photoDTO.setFileName(imageFile.getOriginalFilename());
		photoDTO.setPath("/photo/");
		try {
			groceryServiceStub.saveImage(imageFile, photoDTO);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error saving photo", e);
			returnValue="error";
		}
		
		return returnValue;
	}
	
	@RequestMapping(value="/showGrocery")
	public ModelAndView showGrocery() {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			Iterable<GroceryDTO> allGrocery = groceryServiceStub.fetchAllGrocery();
			modelAndView.setViewName("showGrocery");
			modelAndView.addObject("allGrocery", allGrocery);
		} catch(Exception e) {
			e.printStackTrace();
			log.error("Unable to retriev grocry", e);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping("/showGroceryDetails")
	public ModelAndView showGroceryDetails(@RequestParam("item_ID") int itemId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("groceryDetails");
		List<GroceryDTO> grocery = groceryServiceStub.fetchGroceryByItemId(itemId);
		modelAndView.addObject("grocery", grocery);
		return modelAndView;
	}



}
