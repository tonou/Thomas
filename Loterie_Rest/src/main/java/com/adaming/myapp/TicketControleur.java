package com.adaming.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;
import com.adaming.myapp.service.ticket.ITicketService;

@RestController
public class TicketControleur {

	@Autowired
	private ITicketService tS;
	
	@RequestMapping(value = "/addTicket/{idOrganisateur}", method = RequestMethod.POST)
	public TicketDto addC(@RequestBody Ticket t, @PathVariable Long idOrganisateur) {
		return tS.add(t, idOrganisateur);
	}
	
	@RequestMapping(value = "/getAllTicket", method = RequestMethod.GET)
	public List<TicketDto> getAllT() {
		return tS.getAllTicket();
	}
	
	@RequestMapping(value = "/getOneTicket/{idTicket}", method = RequestMethod.GET)
	public TicketDto getOneP(@PathVariable Long idTicket) {
		return tS.getOne(idTicket);
	}
	
	@RequestMapping(value = "/updateTicket", method = RequestMethod.POST)
	public TicketDto updateT(@PathVariable Ticket t) {
		return tS.update(t);
	}
	
	@RequestMapping(value = "/deleteTicket/{idTicket}", method = RequestMethod.DELETE)
	public void deleteT(@PathVariable Long idTicket) {
		tS.delete(idTicket);
	}
	
	@RequestMapping(value = "/getClientByTicket/{idTicket}", method = RequestMethod.GET)
	public ClientDto getClientByT(@PathVariable Long idTicket) {
		return tS.getClientByTicket(idTicket);
	}
	
	@RequestMapping(value = "/getLotByTicket/{idTicket}", method = RequestMethod.GET)
	public LotDto getLotByT(@PathVariable Long idTicket) {
		return tS.getLotByTicket(idTicket);
	}
	
	@RequestMapping(value = "/tirage/{i1}/{i2}/{i3}", method = RequestMethod.GET)
	public void tirage(@PathVariable Integer i1,@PathVariable Integer i2,@PathVariable Integer i3) {
		tS.tirage(i1, i2, i3);
	}
	
	

	
	
}
