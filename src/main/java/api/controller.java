package api;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class controller {
	
	@GetMapping(value = "/index")
	   public String index() {
	      return "index";
	   }
	@GetMapping(value = "/warehouse")
	   public String warehouseManu() {
	      return "warehouse";
	   }
	
	@Autowired
	private partService partSer;
	@Autowired
	private actionService actionSer;
	
	@RequestMapping("/part")
	public String parts(Model model) {
		List<part> parts = partSer.listAll();
		model.addAttribute("parts", parts);
		return "part";
	}
	
	@RequestMapping("/part/add")
	public String addPart(Model model){
		part part = new part();
		model.addAttribute("part", part);
		return "addPart";
	}


	@RequestMapping(value = "/part/save", method = RequestMethod.POST)
	public String savePart(@ModelAttribute("part") part part) {
		partSer.save(part);
		return "redirect:/part";
	}

	@RequestMapping("/part/delete/{id}")
	public String deletePart(@PathVariable(value = "id") Integer id) {
		List<part> parts = partSer.listAll();
		for (int i = 0; i<parts.size();i++) {
				if (parts.get(i).getID()==id) {
					parts.get(i).setPvalue(0);
					parts.get(i).setPaction(0);
					parts.get(i).setDiscount(0);
					partSer.save(parts.get(i));
				}
			}
		partSer.delete(id);
		return "redirect:/part";
	}
	
	@RequestMapping("/part/search/{by}/{search1}/{search2}")
	 public String searchPart(
			 @PathVariable(value = "by") int by,
			 @PathVariable(value = "search1") String search1,
			 @PathVariable(value = "search2") String search2) throws ParseException 
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<part> parts = partSer.listAll();
		for (int i = 0; i<parts.size();i++) {
			parts.get(i).setPvisible(0);
			partSer.save(parts.get(i));
		}
		for (int i = 0; i<parts.size();i++) {
			if (by ==  1) {
				if (parts.get(i).getID()==Long.parseLong(search1)) {
					parts.get(i).setPvisible(1);
					partSer.save(parts.get(i));
				}
			}
			else if (by == 2) {
				java.util.Date searchDate = format.parse(search1);
				Date sqlSearchDate = new java.sql.Date(searchDate.getTime());
				if ((parts.get(i).getPdate()).equals(sqlSearchDate)) {
					parts.get(i).setPvisible(1);
					partSer.save(parts.get(i));
				}
			}
			else {
				if ((parts.get(i).getBrand()).equals(search1)) {
					if ((parts.get(i).getCar()).equals(search2)) {
						parts.get(i).setPvisible(1);
						partSer.save(parts.get(i));
					}
				}
			}
		}
		 return "redirect:/part/search";
	 }
	@RequestMapping("/part/search")
	public String searchPartHtml (Model model) {
		List<part> parts = partSer.listAll();
		model.addAttribute("parts", parts);
		return "partSearch";
	}
	@RequestMapping("/part/count")
	public String showPartCount(Model model){
		List<part> parts = partSer.listAll();
		model.addAttribute("parts", parts); 
		return "partCount";
	}
	@RequestMapping("/article")
	public String article(Model model) {
		List<part> parts = partSer.listAll();
		model.addAttribute("parts", parts); 
		return "article";
	}
	@RequestMapping("/article/delete/{id}")
	public String deleteArticle(@PathVariable(value = "id") Integer id) {
		List<part> parts = partSer.listAll();
		for (int i = 0; i<parts.size();i++) {
				if (parts.get(i).getID()==id) {
					parts.get(i).setPvalue(0);
					parts.get(i).setPaction(0);
					parts.get(i).setDiscount(0);
					partSer.save(parts.get(i));
				}
			}
		return "redirect:/article";
	}
	@RequestMapping("/article/add/{id}/{pvalue}")
	public String addArticle(@PathVariable(value = "id") Integer id,@PathVariable(value = "pvalue") Integer pvalue) {
		List<part> parts = partSer.listAll();
		for (int i = 0; i<parts.size();i++) {
				if (parts.get(i).getID()==id) {
					parts.get(i).setPvalue(pvalue);
					partSer.save(parts.get(i));
				}
			}
		return "redirect:/article";
	}
	@RequestMapping("/article/edit/{id}/{pvalue}")
	public String editArticle(@PathVariable(value = "id") Integer id,@PathVariable(value = "pvalue") Integer pvalue) {
		List<part> parts = partSer.listAll();
		for (int i = 0; i<parts.size();i++) {
				if (parts.get(i).getID()==id) {
					parts.get(i).setPvalue(pvalue);
					partSer.save(parts.get(i));
				}
			}
		return "redirect:/article";
	}
	@RequestMapping("/action")
	public String action(Model model) {
		List<paction> vactions = actionSer.listAll();
		model.addAttribute("vactions", vactions); 
		List<part> parts = partSer.listAll();
		model.addAttribute("parts", parts);
		return "action";
	}
	
	@RequestMapping("/action/add")
	public String addAction(Model model){
		paction action = new paction();
		model.addAttribute("action", action);
		return "addAction";
	}
	@RequestMapping(value = "/action/save", method = RequestMethod.POST)
	public String saveAction(@ModelAttribute("paction") paction paction) {
		actionSer.save(paction);
		return "redirect:/action";
	}

	@RequestMapping("/action/delete/{id}")
	public String deleteAction(@PathVariable(value = "id") Integer id) {
		List<part> parts = partSer.listAll();
		for (int i = 0; i<parts.size();i++) {
				if (parts.get(i).getID()==id) {
					if (parts.get(i).getPaction()==id.intValue()) {
					parts.get(i).setPaction(0);
					parts.get(i).setDiscount(0);
					partSer.save(parts.get(i));
					}
				}
			}
		actionSer.delete(id);
		return "redirect:/action";
	}
	@RequestMapping("/action/part/add/{action}/{id}")
	public String addPartToAction(@PathVariable(value = "action") String action,@PathVariable(value = "id") Integer id) {
		List<part> parts = partSer.listAll();
		List<paction> pactions = actionSer.listAll();
		for (int i = 0; i<parts.size();i++) {
			int price=parts.get(i).getPvalue()-parts.get(i).getPvalue()*pactions.get(i).getDiscount()/100;
				if (parts.get(i).getID()==id) {
					parts.get(i).setPaction(Integer.valueOf(action));
					parts.get(i).setDiscount(price);
					partSer.save(parts.get(i));
					break;
				}
			}
		return "redirect:/action";
	}
	@RequestMapping("/action/part/delete/{action}/{id}")
	public String deletePartFromAction(@PathVariable(value = "action") Integer action,@PathVariable(value = "id") Integer id) {
		List<part> parts = partSer.listAll();
		for (int i = 0; i<parts.size();i++) {
				if (parts.get(i).getID()==id) {
					if (parts.get(i).getPaction()==action) {
					parts.get(i).setPaction(0);
					parts.get(i).setDiscount(0);
					partSer.save(parts.get(i));
					}
				}
			}
		return "redirect:/action";
	}
	@RequestMapping("/offers")
	public String offers(Model model) {
		List<part> parts = partSer.listAll();
		model.addAttribute("parts", parts); 
		return "offers";
	}
}
