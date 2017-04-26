package com.adaming.myapp.dao.lot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.myapp.dao.personne.IPersonneDao;
import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.Partenaire;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;

public class LotDaoImpl implements ILotDao {

	@PersistenceContext
	private EntityManager entityManager;

	private Logger LOGGER = Logger.getLogger("LotDaoImpl");
	@Inject
	private IPersonneDao daoP;
	
	@Override
	public LotDto add(Lot l,Long idPartenaire) {
		// TODO Auto-generated method stub
		entityManager.persist(l);
		System.out.println(l);
		List<Lot> lots = daoP.getAllLotByPartenaire(idPartenaire);
		System.out.println(lots);
		Partenaire p =(Partenaire) daoP.getOneP(idPartenaire);
		System.out.println(p);
		lots.add(l);
		System.out.println(l);
		p.setLots(lots);
		System.out.println(lots);
		//daoP.update(p);
		
		
		LotDto lotdto=convertir(l);
		LOGGER.info("add OK" + lotdto);
		return lotdto;
	}

	@Override
	public LotDto update(Lot l) {
		// TODO Auto-generated method stub
		entityManager.merge(l);
		LotDto lotdto=convertir(l);
		LOGGER.info("upd OK" + lotdto);
		return lotdto;
	}

	@Override
	public LotDto getOne(Long id) {
		// TODO Auto-generated method stub
		Lot l = entityManager.find(Lot.class, id);
		LotDto lotdto=convertir(l);
		LOGGER.info("getOne OK" + lotdto);
		return lotdto;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<LotDto> getAllLot() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Lot");
		List<Lot>lots = query.getResultList();
		List<LotDto>lotsdto = new ArrayList<LotDto>();
		
		for (Lot l:lots){
			LotDto lotdto=convertir(l);
			lotsdto.add(lotdto);
		}
		LOGGER.info("getAllLot OK" + lotsdto);
		return lotsdto;
	}

	@Override
	public void delete(Long  id) {
		// TODO Auto-generated method stub
		Lot l = entityManager.find(Lot.class, id);
		
		entityManager.remove(l);
		LOGGER.info("del OK" + l);
	}

	@Override
	public List<TicketDto> getAllTicketByLot(Long  id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select l.tickets from Lot l where l.id=:x") ;
		query.setParameter("x", id);
		List<Ticket> tickets=query.getResultList();
		List<TicketDto> ticketsdto= new ArrayList<TicketDto>();
		for (Ticket t : tickets) {
			TicketDto ticketdto = new TicketDto();
			ticketdto.setId(t.getId());
			ticketdto.setPrix(t.getPrix());

			ticketsdto.add(ticketdto);
		}
		LOGGER.info("getAllTicketByLot OK" + ticketsdto);
		return ticketsdto;
	}

	@Override
	public LotDto convertir(Lot lot) {
		// TODO Auto-generated method stub
		
		LotDto lotdto = new LotDto();
		lotdto.setId(lot.getId());
		lotdto.setLabel(lot.getLabel());
		lotdto.setPrix(lot.getPrix());
		return lotdto;
	}

	@Override
	public Lot getOneLot(Long id) {
		// TODO Auto-generated method stub
		Lot l = entityManager.find(Lot.class, id);
		return l;
	}

	@Override
	public List<Ticket> getAllTicketByLotLot(Long id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select l.tickets from Lot l where l.id=:x") ;
		query.setParameter("x", id);
		List<Ticket> tickets=query.getResultList();
		return tickets;
	}

	@Override
	public List<Lot> getAllLotLot() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Lot");
		List<Lot>lots = query.getResultList();
		LOGGER.info("getAllLot OK" + lots);
		return lots;
		
	}

	@Override
	public List<Lot> getAllLotPerdant() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Lot where Type_de_lot=LotPerdant");
		List<Lot>lots = query.getResultList();
		
		LOGGER.info("getAllLotP OK" + lots);
		return lots;
	}

	@Override
	public List<Lot> getAllLotGagnant() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Lot where Type_de_lot=LotGagnant");
		List<Lot>lots = query.getResultList();

		LOGGER.info("getAllLotG OK" + lots);
		return lots;
	}

	@Override
	public List<Lot> getAllGrosLotGagnant() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Lot where Type_de_lot=GrosLotGagnant");
		List<Lot>lots = query.getResultList();

		LOGGER.info("getAllLotGG OK" + lots);
		return lots;
	}

}
