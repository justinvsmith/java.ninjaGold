package com.justinsmith.DojoSurvey;

import java.util.ArrayList;
import java.util.Random;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
     int money = 0;
     ArrayList<String> responses = new  ArrayList<String>();
     
	@RequestMapping("gold")
	public String homePage(HttpSession session, Model model) {
		if(session.isNew()) {
			session.setAttribute("earned", 0);
			session.setAttribute("location", null);
			session.setAttribute("responses", null);
		}
		
		return "gold.jsp";
	}
	
	@RequestMapping(path="process", method=RequestMethod.POST)
	public String processMoney(@RequestParam(value="location") String location, HttpSession session, Model model) {
		java.util.Date date=new java.util.Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM d y hh:mm a");
		Random random = new Random();
		session.setAttribute("location", location);
		
		
		if(session.getAttribute("location").equals("farm")) {
			int newGold = random.nextInt(20 - 10 + 1) + 10;
			money = money + newGold;
			session.setAttribute("earned", money);
			responses.add("You entered a  " + session.getAttribute("location") + " and earned " + newGold + " gold " + "(" +formatter.format(date)+")");
			session.setAttribute("responses", responses);
		}
		if(session.getAttribute("location").equals("cave")) {
			int newGold = random.nextInt(10 - 5 +  1) + 5;
			money = money + newGold;
			session.setAttribute("earned", money);
			responses.add("You entered a  " + session.getAttribute("location") + " and earned " + newGold + " gold " + "(" +formatter.format(date)+")");
			session.setAttribute("responses", responses);
		}
		if(session.getAttribute("location").equals("house")) {
			int newGold = random.nextInt(5 - 2 +  1) + 2;
			money = money + newGold;
			session.setAttribute("earned", money);
			responses.add("You entered a  " + session.getAttribute("location") + " and earned " + newGold + " gold " + "(" +formatter.format(date)+")");
			session.setAttribute("responses", responses);
		}
		if(session.getAttribute("location").equals("casino")) {
			int newGold = random.nextInt(100) - 50;
			money = money + newGold;
			session.setAttribute("earned", money);
			if(newGold > 0) {
				responses.add("You entered a  " + session.getAttribute("location") + " and earned " + newGold + " gold " + "(" +formatter.format(date)+")");
			}
			else if(newGold < 0) {
				responses.add("You entered a  " + session.getAttribute("location") + " and lost " + (newGold * -1) + " gold " + "(" +formatter.format(date)+")");
			}
			session.setAttribute("responses", responses);
		}

		return "redirect:/gold";
		
	}
}
