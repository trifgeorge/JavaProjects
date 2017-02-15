package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Airport;

import com.service.AirportService;

@Controller
public class AirportController {

	private AirportService airportService;

	@Autowired(required = true)
	@Qualifier(value = "airportService")
	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}

	@RequestMapping(value = "/airport", method = RequestMethod.GET)
	public String listAirports(Model model) {
		model.addAttribute("airport", new Airport());
		model.addAttribute("listAirports", this.airportService.listAirports());
		return "airport";
	}

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");
		return model;

	}

	@RequestMapping(value = "/client**", method = RequestMethod.GET)
	public ModelAndView clientPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "This page is all yours.");
		model.setViewName("client");
		return model;
	}

	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public ModelAndView aboutusPage() {
		ModelAndView model = new ModelAndView();
		Connection conn = null;
	    
	    
	  
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	String url="jdbc:mysql://localhost:3306/lic";
	    	String username="root";
	    	String password="root";
	    	
	    	conn=DriverManager.getConnection(url, username, password);
	    	ResultSet rs;
	    	Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM airplane ORDER BY airplane_id LIMIT 1 OFFSET 0;");
            while ( rs.next() ) {
                int airplane_i = rs.getInt("airplane_id");
                String airplane_id=String.valueOf(airplane_i);
                int seatsr=rs.getInt("seatsr");
                model.addObject("airplane_id", airplane_id);
                model.addObject("seatsr", seatsr);
                
            }
            ResultSet rss;
	    	Statement stmtt = conn.createStatement();
            rss = stmtt.executeQuery("SELECT * FROM airplane ORDER BY airplane_id LIMIT 1 OFFSET 1;");
            while ( rss.next() ) {
                int airplane_ii = rss.getInt("airplane_id");
                String airplane_idd=String.valueOf(airplane_ii);
                int seatsrr=rss.getInt("seatsr");
                model.addObject("airplane_idd", airplane_idd);
                model.addObject("seatsrr", seatsrr);
            }
            ResultSet rsss;
	    	Statement stmttt = conn.createStatement();
            rsss = stmttt.executeQuery("SELECT * FROM airplane ORDER BY airplane_id LIMIT 1 OFFSET 2;");
            while ( rsss.next() ) {
                int airplane_iii = rsss.getInt("airplane_id");
                String airplane_iddd=String.valueOf(airplane_iii);
                int seatsrrr=rsss.getInt("seatsr");
                model.addObject("airplane_iddd", airplane_iddd);
                model.addObject("seatsrrr", seatsrrr);
            }
            
	    	
	    }catch (Exception x){
	    	x.printStackTrace();
	    }
		
		model.setViewName("aboutus");
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	/* for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();

	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addObject("username", userDetail.getUsername());
	  }

	  model.setViewName("403");
	  return model;

	} 
*/
   //remove the plane(airplane_id) from the client(client_id) from table(client_airplane)
	@RequestMapping("/client/remove/{client_id}/{airplane_id}")
	public String removeClientAirplane(@PathVariable("client_id") int client_id,@PathVariable("airplane_id") int airplane_id){
		Connection conn = null;
	    PreparedStatement stmt = null;
	    PreparedStatement stmtt = null;
	  
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	String url="jdbc:mysql://localhost:3306/lic";
	    	String username="root";
	    	String password="root";
	    	
	    	conn=DriverManager.getConnection(url, username, password);
	    	stmt=conn.prepareStatement("Delete from client_airplane Where client_id=? and airplane_id=?");
	    	stmt.setInt(1, client_id);
	    	stmt.setInt(2, airplane_id);
	    	stmt.execute();
	    	stmtt=conn.prepareStatement("Update airplane SET seatsr=seatsr -1 Where airplane_id =?");
	    	stmtt.setInt(1, airplane_id);
	    	stmtt.executeUpdate();
	    	
	    }catch (Exception x){
	    	x.printStackTrace();
	    }
				
		return "redirect:/client";
	}

	

}
