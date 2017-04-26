package com.adaming.myapp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.GrosLotGagnant;
import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.LotGagnant;
import com.adaming.myapp.entities.LotPerdant;
import com.adaming.myapp.entities.Organisateur;
import com.adaming.myapp.entities.Partenaire;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.PersonneDto;
import com.adaming.myapp.service.lot.ILotService;
import com.adaming.myapp.service.personne.IPersonneService;
import com.adaming.myapp.service.ticket.ITicketService;

public class PersonneTestUnitaire {

	private static ClassPathXmlApplicationContext context;
	private static IPersonneService serviceP;
	private static ITicketService serviceT;
	private static ILotService serviceL;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("app.xml");
		serviceP= (IPersonneService) context.getBean("personneService");
		serviceT=  (ITicketService) context.getBean("ticketService");
		serviceL=  (ILotService) context.getBean("lotService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		Personne p = new Client();
		serviceP.add(p);
		assertNotNull(p.getId());
		
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
		Personne p = new Client("nom","prenom");
		p.setNom("nom2");	
		serviceP.add(p);
		serviceP.update(p);
		assertTrue(p.getNom().equalsIgnoreCase("nom2"));
	}

	@Test
	public void testGetOne() {
		//fail("Not yet implemented");
		Personne p = new Client("nom","prenom");
		serviceP.add(p);
		PersonneDto p2=serviceP.getOne(p.getId());
		assertTrue(p2!=null);
	}

	@Test
	public void testGetAllPersonne() {
		//fail("Not yet implemented");
		Personne c = new Client("nom","prenom");
		Personne p = new Partenaire("c2","c2");
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(p);serviceP.add(c);serviceP.add(o);
		assertTrue(serviceP.getAllPersonne().size()>=3);
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
		Personne c = new Client("nom","prenom");
		serviceP.add(c);
		List <PersonneDto> personnes = serviceP.getAllPersonne();
		serviceP.delete(c.getId());
		System.out.println(personnes.size()+"azerty");
		System.out.println(serviceP.getAllPersonne().size());
		assertTrue(serviceP.getAllPersonne().size()-personnes.size()<0);
	}

	@Test
	public void testGetAllClient() {
		//fail("Not yet implemented");
		Personne p = new Client("nom","prenom");
		serviceP.add(p);
		assertTrue(serviceP.getAllPersonne().size()>0);
	}

	@Test
	public void testGetAllPartenaire() {
		//fail("Not yet implemented");
		Personne p = new Partenaire("c2","c2");
		serviceP.add(p);
		assertTrue(serviceP.getAllPersonne().size()>0);
	}

	@Test
	public void testGetAllOrganisateur() {
		//fail("Not yet implemented");
		Personne p = new Organisateur ("c3","c3");
		serviceP.add(p);
		assertTrue(serviceP.getAllPersonne().size()>0);
	}

	@Test
	public void testGetAllTicketByClientOrgaDto() {
		//fail("Not yet implemented");
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());
		assertTrue(serviceP.getAllTicketByClientOrgaDto(o.getId()).size()>0); ///////////
	}

	@Test
	public void testGetAllLotByPartenaireDto() {
		//fail("Not yet implemented");
		Personne p = new Partenaire("c2","c2");
		serviceP.add(p);
		Lot l = new LotPerdant(1.0,"l1");
		serviceL.add(l, p.getId());
		assertTrue(serviceP.getAllLotByPartenaireDto(p.getId()).size()>0);
	}

	@Test
	public void testAcheter() {
		//fail("Not yet implemented");
		Personne p = new Client("nom","prenom");
		serviceP.add(p);
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());
		serviceP.acheter(p.getId(), t.getId());
		assertTrue(serviceP.getAllTicketByClientOrgaDto(p.getId()).size()>0);
		
	}

	@Test
	public void testGetAllLotByClient() {
		//fail("Not yet implemented");
		Personne c = new Client("nomtest","prenom");
		serviceP.add(c);
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("ctest","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());		
		Personne p = new Partenaire("c2","c2");
		serviceP.add(p);
		Lot l = new LotPerdant(1.0,"l1");
		serviceL.add(l, p.getId());
		Lot lg = new LotGagnant(1.0,"l1");
		serviceL.add(lg, p.getId());
		Lot lgg = new GrosLotGagnant(1.0,"l1");
		serviceL.add(lgg, p.getId());
		serviceP.acheter(c.getId(), t.getId());
		serviceT.tirage(50, 30, 20);
		assertTrue(serviceP.getAllLotByClient(c.getId()).size()>0);
				
	}
	
	
	@Test
	public void testtirage() {
		//fail("Not yet implemented");
		Personne c = new Client("nom","prenom");
		serviceP.add(c);
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());		
		Personne p = new Partenaire("c2","c2");
		serviceP.add(p);
		Lot l = new LotPerdant(1.0,"l1");
		serviceL.add(l, p.getId());
		Lot lg = new LotGagnant(1.0,"l1");
		serviceL.add(lg, p.getId());
		Lot lgg = new GrosLotGagnant(1.0,"l1");
		serviceL.add(lgg, p.getId());
		serviceP.acheter(c.getId(), t.getId());	
		serviceT.tirage(50, 30, 20);
		
		assertTrue(serviceT.getLotByTicket(t.getId())!=null && serviceP.getAllLotByClient(c.getId()).size()>0);
	}
	
	@Test
	public void testaddticket(){
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());
		assertNotNull(t.getId());
		
	}
	
	@Test
	public void testaddlot(){
		Personne p = new Partenaire("c2","c2");
		serviceP.add(p);
		Lot l = new LotPerdant(1.0,"l1");
		serviceL.add(l, p.getId());
		assertNotNull(l.getId());
	}

	@Test
	public void testgetClientByTicket(){
		Personne c = new Client("nom","prenom");
		serviceP.add(c);
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());	
		serviceP.acheter(c.getId(), t.getId());	
		assertTrue(serviceT.getClientByTicket(t.getId()).getId()==c.getId());
	}
	
	@Test
	public void testgetLotByTicket(){
		Personne c = new Client("nom","prenom");
		serviceP.add(c);
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());		
		Personne p = new Partenaire("c2","c2");
		serviceP.add(p);
		Lot l = new LotPerdant(1.0,"l1");
		serviceL.add(l, p.getId());
		Lot lg = new LotGagnant(1.0,"l1");
		serviceL.add(lg, p.getId());
		Lot lgg = new GrosLotGagnant(1.0,"l1");
		serviceL.add(lgg, p.getId());
		serviceP.acheter(c.getId(), t.getId());	
		serviceT.tirage(50, 30, 20);
		
		assertTrue(serviceT.getLotByTicket(t.getId())!=null);
	}
	
	@Test
	public void testgetAllTicketByLot(){
		Personne c = new Client("nom","prenom");
		serviceP.add(c);
		Ticket t = new Ticket (9.0);
		Personne o = new Organisateur ("c3","c3");
		serviceP.add(o);
		serviceT.add(t, o.getId());		
		Personne p = new Partenaire("c2","c2");
		serviceP.add(p);
		Lot l = new LotPerdant(1.0,"l1");
		serviceL.add(l, p.getId());
		Lot lg = new LotGagnant(1.0,"l1");
		serviceL.add(lg, p.getId());
		Lot lgg = new GrosLotGagnant(1.0,"l1");
		serviceL.add(lgg, p.getId());
		serviceP.acheter(c.getId(), t.getId());	
		serviceT.tirage(50, 30, 20);
		assertTrue(serviceL.getAllTicketByLot(l.getId()).size()>0||serviceL.getAllTicketByLot(lg.getId()).size()>0||serviceL.getAllTicketByLot(lgg.getId()).size()>0);
		
	}
}
