package com.adaming.myapp.dao.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.myapp.dao.lot.ILotDao;
import com.adaming.myapp.dao.personne.IPersonneDao;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.Organisateur;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;

public class TicketDaoImpl implements ITicketDao {

	@PersistenceContext
	private EntityManager entityManager;

	private Logger LOGGER = Logger.getLogger("TicketDaoImpl");

	@Inject
	private ILotDao daoLot;
	@Inject
	private IPersonneDao daoP;

	@Override
	public TicketDto add(Ticket t, Long idOrganisateur) {
		// TODO Auto-generated method stub
		entityManager.persist(t);
		
		Organisateur o = (Organisateur) daoP.getOneP(idOrganisateur);
		System.out.println(o + "    c'est l'organisateur");
		
		Query query = entityManager
						.createNativeQuery("select*from ticket t join organisateur_ticket ot on t.id=ot.tickets_id and ot.organisateur_id=:x", Ticket.class);
				query.setParameter("x", idOrganisateur);
				
				List<Ticket>	tickets = query.getResultList();
		
		//List<Ticket> tickets = daoP.getAllTicketByClientOrga(idOrganisateur);
		System.out.println(tickets   + "    sa liste de ticket initiale");
		tickets.add(t);
		System.out.println(tickets + "       la liste de tickets après add");
		o.setTickets(tickets);
		System.out.println(tickets + "       sa liste de tickets après set");
		System.out.println(o.getTickets()+ "       sa liste de tickets après get");
		System.out.println(daoP.getAllTicketByClientOrga(idOrganisateur)+ "       sa liste de tickets après daoP");
		//entityManager.merge(o);

		
		TicketDto ticketdto = convertir(t);
		LOGGER.info("add OK" + ticketdto);
		return ticketdto;
	}

	@Override
	public TicketDto update(Ticket t) {
		// TODO Auto-generated method stub
		entityManager.merge(t);
		TicketDto ticketdto = convertir(t);
		LOGGER.info("upd OK" + ticketdto);
		return ticketdto;
	}

	@Override
	public TicketDto getOne(Long id) {
		// TODO Auto-generated method stub
		Ticket t = entityManager.find(Ticket.class, id);
		TicketDto ticketdto = convertir(t);
		LOGGER.info("getOne OK" + ticketdto);
		return ticketdto;
	}

	@Override
	public List<TicketDto> getAllTicket() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Ticket");
		List<Ticket> tickets = query.getResultList();
		List<TicketDto> ticketsdto = new ArrayList<TicketDto>();

		for (Ticket t : tickets) {
			TicketDto ticketdto = convertir(t);
			ticketsdto.add(ticketdto);
		}
		LOGGER.info("allticket OK" + ticketsdto);
		return ticketsdto;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Ticket t = entityManager.find(Ticket.class, id);

		entityManager.remove(t);
		LOGGER.info("del OK" + t);
	}

	@Override
	public ClientDto getClientByTicket(Long id) {
		// TODO Auto-generated method stub
		Ticket t = entityManager.find(Ticket.class, id);
		Query query = entityManager
				.createQuery("from Client c join fetch c.tickets ct where ct.id=:x");
		query.setParameter("x", id);
		Client c = (Client) query.getResultList().get(0);

		ClientDto clientdto = new ClientDto();
		clientdto.setId(c.getId());
		clientdto.setNom(c.getNom());
		clientdto.setPrenom(c.getPrenom());

		return clientdto;
	}

	@Override
	public LotDto getLotByTicket(Long id) {
		// TODO Auto-generated method stub
		Ticket t = entityManager.find(Ticket.class, id);
		Query query = entityManager
				.createQuery("from Lot c join fetch c.tickets ct where ct.id=:x");
		query.setParameter("x", id);
		Lot c = (Lot) query.getResultList().get(0);

		LotDto lotdto = new LotDto();
		lotdto.setId(c.getId());
		lotdto.setLabel(c.getLabel());
		lotdto.setPrix(c.getPrix());
		return lotdto;
	}

	@Override
	public TicketDto convertir(Ticket ticket) {
		// TODO Auto-generated method stub
		TicketDto ticketdto = new TicketDto();
		ticketdto.setId(ticket.getId());
		ticketdto.setPrix(ticket.getPrix());

		return ticketdto;
	}

	@Override
	public void tirage(Integer i1, Integer i2, Integer i3) {
		// TODO Auto-generated method stub

		List<Lot> lots = daoLot.getAllLotLot();
		boolean lotp = false;
		boolean lotg = false;
		boolean lotgg = false;

		for (Lot lot : lots) {

			System.out.println(lot.getClass().getSimpleName());

			if (lot.getClass().getSimpleName().equalsIgnoreCase("lotperdant"))
				;
			lotp = true;
			if (lot.getClass().getSimpleName().equalsIgnoreCase("lotgagnant"))
				;
			lotg = true;
			if (lot.getClass().getSimpleName()
					.equalsIgnoreCase("groslotgagnant"))
				;
			lotgg = true;
		}
		System.out.println(lotp);
		System.out.println(lotg);
		System.out.println(lotgg);

		List<Ticket> tickets = getAllTicketTicket();

		if (lotp == true && lotg == true && lotgg == true) {

			for (Ticket t : tickets)

			{
				Integer x = (int) ((Math.random()) * 100);
				System.out.println(x + "xxxxx");

				if (x < i1) {

					List<Lot> lotsp = daoLot.getAllLotPerdant();

					Double xp = (double) ((Math.random()) * (lotsp.size() - 1));

					System.out.println(xp);
					Integer xpp = (int) Math.round(xp);

					System.out.println(xpp);
					Lot l = lotsp.get(xpp);

					t.setLot(l);
					update(t);

					List<Ticket> ticketsL = daoLot.getAllTicketByLotLot(l
							.getId());
					ticketsL.add(t);
					l.setTickets(ticketsL);
					daoLot.update(l);
					LotDto lot = daoLot.convertir(l);
					LOGGER.info("tirage OK   1    " + lot);

				}
				if (x < (i2 + i1) && x > i1) {

					List<Lot> lotsp2 = daoLot.getAllLotGagnant();

					Double xp = (double) ((Math.random()) * (lotsp2.size() - 1));
					Integer xpp = (int) Math.round(xp);
					Lot l = lotsp2.get(xpp);

					t.setLot(l);
					update(t);
					List<Ticket> ticketsL = daoLot.getAllTicketByLotLot(l
							.getId());
					l.setTickets(ticketsL);
					daoLot.update(l);
					LotDto lot = daoLot.convertir(l);
					LOGGER.info("tirage OK   2   " + lot);

				}
				if (x >= (100 - i3)) {

					List<Lot> lotsp3 = daoLot.getAllGrosLotGagnant();

					System.out.println(lotsp3 + "       LOT GG   LOT GG ");

					Double xp = (double) ((Math.random()) * (lotsp3.size() - 1));
					Integer xpp = (int) Math.round(xp);
					Lot l = lotsp3.get(xpp);

					t.setLot(l);
					update(t);
					List<Ticket> ticketsL = daoLot.getAllTicketByLotLot(l
							.getId());
					l.setTickets(ticketsL);
					daoLot.update(l);
					LotDto lot = daoLot.convertir(l);
					LOGGER.info("tirage OK   3    " + lot);

				} else {
					LOGGER.info("tirage NOK type de lot");

				}
			}
		} else {
			LOGGER.info("tirage NOK");
		}

	}

	@Override
	public List<Ticket> getAllTicketTicket() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Ticket");
		List<Ticket> tickets = query.getResultList();

		LOGGER.info("tirage getAllticket ok" + tickets);
		return tickets;
	}

	@Override
	public Lot getLotByTicketTicket(Long id) {
		// TODO Auto-generated method stub
		Ticket t = entityManager.find(Ticket.class, id);
		Query query = entityManager
				.createQuery("from Lot c join fetch c.tickets ct where ct.id=:x");
		query.setParameter("x", id);
		Lot l = (Lot) query.getResultList().get(0);
		return l;
	}

}
