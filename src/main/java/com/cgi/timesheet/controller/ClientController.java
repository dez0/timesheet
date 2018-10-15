package com.cgi.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.timesheet.domain.Client;
import com.cgi.timesheet.service.ClientService;

@RequestMapping("/clients")
@Controller
public class ClientController extends AbstractBaseEntityController<ClientService, Client, Integer> {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("allClients", clientService.findAll());
		return "client_list";
	}
}
