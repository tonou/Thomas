package com.adaming.myapp.dao.personne;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.myapp.dao.lot.ILotDao;
import com.adaming.myapp.dao.ticket.ITicketDao;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.Organisateur;
import com.adaming.myapp.entities.Partenaire;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.OrganisateurDto;
import com.adaming.myapp.entities.dto.PartenaireDto;
import com.adaming.myapp.entities.dto.PersonneDto;
import com.adaming.myapp.entities.dto.TicketDto;
import com.mysql.jdbc.Statement;

public class PersonneDaoImpl implements IPersonneDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private ITicketDao daoTicket;
	@Inject
	private ILotDao daoL;

	private Logger LOGGER = Logger.getLogger("PersonneDaoImpl");

	@Override
	public PersonneDto add(Personne personne) {
		// TODO Auto-generated method stub
		entityManager.persist(personne);
		PersonneDto personnedto = new PersonneDto(personne.getId(),
				personne.getNom(), personne.getPrenom());

		LOGGER.info("add OK" + personnedto);
		return personnedto;
	}

	@Override
	public PersonneDto update(Personne p) {

		// TODO Auto-generated method stub

		System.out.println(getAllLotByPartenaire(p.getId()) + "KKKK");
		System.out.println(p + "..................p!");

		//entityManager.merge(p);

		 Query query =
		 entityManager.createNativeQuery("UPDATE loterie.personne p SET nom =:x, prenom =:y WHERE p.id=:z",Personne.class);
		query.setParameter("x", p.getNom()).setParameter("y",
		 p.getPrenom()).setParameter("z", p.getId());

		/*
		 * entityManager.createQuery(
		 * "UPDATE Personne p SET nom =:x, prenom =:y WHERE p.id=:z"
		 * ).setParameter("x", p.getNom()) .setParameter("y",
		 * p.getPrenom()).setParameter("z", p.getId());;
		 */

		
		
		System.out.println(getAllLotByPartenaire(p.getId()) + "KKKKK");
		/*
		 * if (p.getClass().getSimpleName().equalsIgnoreCase("organisateur")) {
		 * Organisateur o = (Organisateur) p; List<Ticket> tickets =
		 * getAllTicketByClientOrga(o.getId()); entityManager.merge(o);
		 * o.setTickets(tickets); entityManager.merge(o); } if
		 * (p.getClass().getSimpleName().equalsIgnoreCase("client")) {
		 * 
		 * Client c = (Client) p; List<Ticket> tickets =
		 * getAllTicketByClientOrga(c.getId()); entityManager.merge(c);
		 * c.setTickets(tickets); entityManager.merge(c);
		 * 
		 * } if (p.getClass().getSimpleName().equalsIgnoreCase("partenaire")) {
		 * Partenaire part = (Partenaire) p; List<Lot> lots =
		 * getAllLotByPartenaire(part.getId()); entityManager.merge(part);
		 * part.setLots(lots); entityManager.merge(part); }
		 */
		query.executeUpdate();
		
		PersonneDto personnedto = new PersonneDto();
		personnedto.setId(p.getId());
		personnedto.setNom(p.getNom());
		personnedto.setPrenom(p.getPrenom());

		/*
		 * if (p.getClass().getSimpleName().equalsIgnoreCase("client")) {
		 * ClientDto clientdto = new ClientDto();
		 * clientdto.setId(personnedto.getId());
		 * clientdto.setNom(personnedto.getNom());
		 * clientdto.setPrenom(personnedto.getPrenom());
		 * clientdto.setTickets(getAllTicketByClientOrgaDto(p.getId()));
		 * LOGGER.info("upd OK" + personnedto); return clientdto; }
		 * 
		 * else if
		 * (p.getClass().getSimpleName().equalsIgnoreCase("organisateur")) {
		 * OrganisateurDto organisateurdto = new OrganisateurDto();
		 * organisateurdto.setId(personnedto.getId());
		 * organisateurdto.setNom(personnedto.getNom());
		 * organisateurdto.setPrenom(personnedto.getPrenom());
		 * 
		 * organisateurdto.setTickets(getAllTicketByClientOrgaDto(p.getId()));
		 * LOGGER.info("upd OK" + personnedto); return organisateurdto; }
		 * 
		 * else if (p.getClass().getSimpleName().equalsIgnoreCase("partenaire"))
		 * { PartenaireDto partenairedto = new PartenaireDto();
		 * partenairedto.setId(personnedto.getId());
		 * partenairedto.setNom(personnedto.getNom());
		 * partenairedto.setPrenom(personnedto.getPrenom());
		 * 
		 * partenairedto.setLots(getAllLotByPartenaireDto(p.getId()));
		 * LOGGER.info("upd OK" + personnedto); return partenairedto; } else {
		 * return null; }
		 */return personnedto;
	}

	@Override
	public PersonneDto getOne(Long id) {
		// TODO Auto-generated method stub
		Personne p = entityManager.find(Personne.class, id);
		PersonneDto personnedto = new PersonneDto();
		personnedto.setId(p.getId());
		personnedto.setNom(p.getNom());
		personnedto.setPrenom(p.getPrenom());
		LOGGER.info("getO OK" + personnedto);
		return personnedto;

	}

	@Override
	public List<PersonneDto> getAllPersonne() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Personne");

		List<Personne> personnes = query.getResultList();
		List<PersonneDto> personnesdto = new ArrayList<PersonneDto>();

		for (Personne p : personnes) {
			PersonneDto personnedto = new PersonneDto();
			personnedto.setId(p.getId());
			personnedto.setNom(p.getNom());
			personnedto.setPrenom(p.getPrenom());
			personnesdto.add(personnedto);
		}
		LOGGER.info("getList OK" + query.getResultList().size());
		return personnesdto;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Personne p = entityManager.find(Personne.class, id);
		if (p.getClass().getSimpleName().equalsIgnoreCase("client")) {
			Client c = (Client) p;

			entityManager.remove(c);
			LOGGER.info("del OK" + c);
		}
	}

	@Override
	public List<ClientDto> getAllClient() {
		// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery("from Personne where Type_de_Personne=Client");

		List<Client> clients = query.getResultList();
		List<ClientDto> clientsdto = new ArrayList<ClientDto>();
		System.out.println(clients);
		for (Client p : clients) {
			ClientDto clientdto = new ClientDto();
			clientdto.setId(p.getId());
			clientdto.setNom(p.getNom());
			clientdto.setPrenom(p.getPrenom());
			System.out.println(clientdto);
			clientsdto.add(clientdto);
		}
		LOGGER.info("getList OK" + query.getResultList().size());
		return clientsdto;
	}

	@Override
	public List<PartenaireDto> getAllPartenaire() {
		// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery("from Personne where Type_de_Personne=Partenaire");
		LOGGER.info("getList OK" + query.getResultList().size());

		List<Partenaire> partenaires = query.getResultList();
		List<PartenaireDto> partenairesdto = new ArrayList<PartenaireDto>();

		for (Partenaire p : partenaires) {
			PartenaireDto partenairedto = new PartenaireDto();
			partenairedto.setId(p.getId());
			partenairedto.setNom(p.getNom());
			partenairedto.setPrenom(p.getPrenom());
			partenairesdto.add(partenairedto);
		}

		return partenairesdto;
	}

	@Override
	public List<OrganisateurDto> getAllOrganisateur() {
		// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery("from Personne where Type_de_Personne=Organisateur");
		LOGGER.info("getList OK" + query.getResultList().size());

		List<Organisateur> organisateurs = query.getResultList();
		List<OrganisateurDto> organisateursdto = new ArrayList<OrganisateurDto>();

		for (Organisateur p : organisateurs) {
			OrganisateurDto organisateurdto = new OrganisateurDto();
			organisateurdto.setId(p.getId());
			organisateurdto.setNom(p.getNom());
			organisateurdto.setPrenom(p.getPrenom());
			organisateursdto.add(organisateurdto);
		}

		return organisateursdto;
	}

	@Override
	public List<Ticket> getAllTicketByClientOrga(Long id) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = new ArrayList<Ticket>();
		Personne p = entityManager.find(Personne.class, id);
		System.out.println(p +"    the personne p");
		if (p.getClass().getSimpleName().equalsIgnoreCase("partenaire")) {
			return null;
		} else if (p.getClass().getSimpleName().equalsIgnoreCase("client")){
			Query query = entityManager.createQuery("select p.tickets from Personne p where p.id=:x");
			
			//Query query = entityManager
			//		.createNativeQuery("select*from ticket t join organisateur_ticket ot on t.id=ot.tickets_id and ot.organisateur_id=:x", Ticket.class);
			query.setParameter("x", id);
			System.out.println(tickets + " les tickets");
			tickets = query.getResultList();

			return tickets;
		}
		else {
			//Query query = entityManager.createQuery("select p.tickets from Personne p where p.id=:x");
			
			Query query = entityManager
					.createNativeQuery("select*from ticket t join organisateur_ticket ot on t.id=ot.tickets_id and ot.organisateur_id=:x", Ticket.class);
			query.setParameter("x", id);
			System.out.println(tickets + " les tickets");
			tickets = query.getResultList();

			return tickets;
		}
	}

	@Override
	public List<TicketDto> getAllTicketByClientOrgaDto(Long id) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = getAllTicketByClientOrga(id);

		Personne p = entityManager.find(Personne.class, id);
		if (p.getClass().getSimpleName().equalsIgnoreCase("partenaire")) {
			return null;
		} else {
			List<TicketDto> ticketsdto = new ArrayList<TicketDto>();
			for (Ticket t : tickets) {
				TicketDto ticketdto = new TicketDto();
				ticketdto.setId(t.getId());
				ticketdto.setPrix(t.getPrix());

				ticketsdto.add(ticketdto);
			}
			return ticketsdto;
		}

	}

	@Override
	public List<LotDto> getAllLotByPartenaireDto(Long id) {
		// TODO Auto-generated method stub
		Personne p = entityManager.find(Personne.class, id);
		if (p.getClass().getSimpleName().equalsIgnoreCase("partenaire")) {

			Query query = entityManager
					.createQuery("select p.lots from Personne p where p.id=:x");
			query.setParameter("x", id);
			List<Lot> lots = query.getResultList();

			List<LotDto> lotsdto = new ArrayList<LotDto>();
			for (Lot l : lots) {
				LotDto lotdto = new LotDto();
				lotdto.setId(l.getId());
				lotdto.setPrix(l.getPrix());
				lotdto.setLabel(l.getLabel());

				lotsdto.add(lotdto);
			}
			return lotsdto;

		} else {
			return null;
		}
	}

	@Override
	public TicketDto acheter(Long idClient, Long idTicket) {
		// TODO Auto-generated method stub
		Personne p = entityManager.find(Personne.class, idClient);

		if (p.getClass().getSimpleName().equalsIgnoreCase("Client")) {
			System.out.println(idTicket);
			Ticket t = entityManager.find(Ticket.class, idTicket);
			List<Ticket> tickets = getAllTicketByClientOrga(idClient);
			Client c = (Client) p;
			tickets.add(t);
			c.setTickets(tickets);
			update(c);
			System.out.println(c);
			t.setClient(c);
			daoTicket.update(t);
			TicketDto ticketdto = daoTicket.convertir(t);
			LOGGER.info("acheter OK" + ticketdto);
			return ticketdto;

		} else {
			return null;
		}
	}

	@Override
	public List<LotDto> getAllLotByClient(Long id) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = getAllTicketByClientOrga(id);
		List<LotDto> lots = new ArrayList<LotDto>();
		for (Ticket t : tickets) {
			Lot l = daoTicket.getLotByTicketTicket(t.getId());
			lots.add(daoL.convertir(l));
		}

		return lots;
	}

	@Override
	public Personne getOneP(Long id) {
		// TODO Auto-generated method stub
		Personne p = entityManager.find(Personne.class, id);
		LOGGER.info("add OK" + p);
		return p;
	}

	@Override
	public List<Lot> getAllLotByPartenaire(Long id) {
		// TODO Auto-generated method stub
		Personne p = entityManager.find(Personne.class, id);
		if (p.getClass().getSimpleName().equalsIgnoreCase("partenaire")) {

			Query query = entityManager
					.createQuery("select p.lots from Personne p where p.id=:x");
			query.setParameter("x", id);
			List<Lot> lots = query.getResultList();
			return lots;
		} else {
			return null;
		}
	}

}
