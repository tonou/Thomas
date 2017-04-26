package com.adaming.myapp.service.ticket;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.personne.PersonneDaoImpl;
import com.adaming.myapp.dao.ticket.TicketDaoImpl;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;

@Transactional(readOnly=true)
public class TicketServiceImpl implements ITicketService{

	private TicketDaoImpl  dao;
	private final Logger LOGGER = Logger.getLogger("TicketServiceImpl");
	
	
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(TicketDaoImpl dao) {
		
		this.dao = dao;
		LOGGER.info("Injection Ticket ****");
	}

	@Override
	@Transactional(readOnly=false)
	public TicketDto add(Ticket t, Long idOrganisateur) {
		// TODO Auto-generated method stub
		return dao.add(t,idOrganisateur);
	}

	@Override
	@Transactional(readOnly=false)
	public TicketDto update(Ticket t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	@Override
	public TicketDto getOne(Long id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public List<TicketDto> getAllTicket() {
		// TODO Auto-generated method stub
		return dao.getAllTicket();
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	@Override
	public ClientDto getClientByTicket(Long id) {
		// TODO Auto-generated method stub
		return dao.getClientByTicket(id);
	}

	@Override
	public LotDto getLotByTicket(Long id) {
		// TODO Auto-generated method stub
		return dao.getLotByTicket(id);
	}

	@Override
	public TicketDto convertir(Ticket ticket) {
		// TODO Auto-generated method stub
		return dao.convertir(ticket);
	}

	@Override
	public void tirage(Integer i1, Integer i2, Integer i3) {
		// TODO Auto-generated method stub
		//return dao.tirage(idTicket);
		dao.tirage(i1, i2, i3);
	}

}
