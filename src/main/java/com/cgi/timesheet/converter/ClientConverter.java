package com.cgi.timesheet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cgi.timesheet.domain.Client;
import com.cgi.timesheet.service.ClientService;

@Component
public class ClientConverter implements Converter<String, Client> {

	@Autowired
	private ClientService clientService;

	@Override
	public Client convert(String id) {
		return clientService.findById(Integer.valueOf(id)).get();
	}
}
