package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Airplane;
import com.service.AirplaneService;

@Controller
public class AirplaneController {

	public AirplaneService airplaneService;

	@Autowired(required = true)
	@Qualifier(value = "airplaneService")
	public void setAirplaneService(AirplaneService airplaneService) {
		this.airplaneService = airplaneService;
	}

	@RequestMapping(value = "/airplane", method = RequestMethod.GET)
	public String listAllAirplanes(Model model) {
		model.addAttribute("airplane", new Airplane());
		model.addAttribute("listAllAirplanes", this.airplaneService.listAllAirplanes());
		
		return "airplane";
	}
	
	/*
	@RequestMapping(value = "/airplaneadmin", method = RequestMethod.GET)
	public String listAllAirplanesAdmin(Model model) {
		model.addAttribute("airplane", new Airplane());
		model.addAttribute("listAllAirplanes", this.airplaneService.listAllAirplanes());
		
		return "airplane";
	}
	*/
	@RequestMapping(value = "/airplane/add", method = RequestMethod.POST)
	public String addAirplane(@ModelAttribute("airplane") Airplane a) {
		if (a.getAirplane_id() == 0) {
			// new person, add it
			this.airplaneService.addAirplane(a);
		} else {
			// existing person, call update
			this.airplaneService.updateAirplane(a);
		}

		return "redirect:/airplane";
	}

	@RequestMapping("/airplane/remove/{id}")
	public String removeAirplane(@PathVariable("id") int id, Model model) {
		this.airplaneService.removeAirplane(id);
		return "redirect:/airplane";
	}
	
	@RequestMapping("/airplane/edit/{id}")
	public String editAirplane(@PathVariable("id") int id,Model model){
		model.addAttribute("airplane",this.airplaneService.getAirplaneById(id));
		model.addAttribute("listAllAirplanes",this.airplaneService.listAllAirplanes());
		return "airplane";
	}
	@RequestMapping("/airplane/add/{client_id}/{airplane_id}")
	public String addClientAirplane(@PathVariable("client_id") int client_id,@PathVariable("airplane_id") int airplane_id){
		Connection conn = null;
	    PreparedStatement stmt = null;
	    PreparedStatement stmtt = null;
	    
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	String url="jdbc:mysql://localhost:3306/lic";
	    	String username="root";
	    	String password="root";
	    	
	    	conn=DriverManager.getConnection(url, username, password);
	    	stmt=conn.prepareStatement("Insert into client_airplane values(?,?)");
	    	stmt.setInt(1, airplane_id);
	    	stmt.setInt(2, client_id);
	    	stmt.executeUpdate();
	    	stmtt=conn.prepareStatement("Update airplane SET seatsr=seatsr +1 Where airplane_id =?");
	    	stmtt.setInt(1, airplane_id);
	    	stmtt.executeUpdate();
	    }catch (Exception x){
	    	x.printStackTrace();
	    }
				
		return "redirect:/airplane";
	}
}
