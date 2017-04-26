package com.adaming.myapp.service.ticket;

import java.util.List;

import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;

public interface ITicketService {
	
	TicketDto add(Ticket t, Long idOrganisateur);
	TicketDto update(Ticket t);
	TicketDto getOne(Long id);
	List<TicketDto> getAllTicket();
	void delete(Long id);
	
	ClientDto getClientByTicket(Long id);
	LotDto getLotByTicket(Long id);
	
	TicketDto convertir(Ticket ticket);
	
	void tirage(Integer i1, Integer i2, Integer i3);

}
