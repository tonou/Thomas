package com.adaming.myapp;

import java.util.Random;

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
import com.adaming.myapp.service.lot.ILotService;
import com.adaming.myapp.service.personne.IPersonneService;
import com.adaming.myapp.service.ticket.ITicketService;



public class Main {

	private static ClassPathXmlApplicationContext context;
	private static IPersonneService serviceP;
	private static ITicketService serviceT;
	private static ILotService serviceL;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		context=new ClassPathXmlApplicationContext("app.xml");
		serviceP= (IPersonneService) context.getBean("personneService");
		serviceT=  (ITicketService) context.getBean("ticketService");
		serviceL=  (ILotService) context.getBean("lotService");
		
		Client c = new Client("c1","c1");
		Client c1 = new Client("c4","c4");
		Client c2 = new Client("c5","c5");
		Client c3 = new Client("c6","c6");
		Personne p = new Partenaire("c2","c2");
		Personne o = new Organisateur ("c3","c3");
		
		serviceP.add(c);serviceP.add(p);serviceP.add(o);
		System.out.println(p.getId()+"IDDDD");
		serviceP.add(c1);serviceP.add(c2);serviceP.add(c3);
		
		System.out.println(serviceP.getAllClient());
		System.out.println(serviceP.getAllPersonne());
		System.out.println(serviceP.getOne(1L));
		
		c.setNom("ROMULUS");
		serviceP.update(c);
		System.out.println(c);
		
		o.setPrenom("orga");
		serviceP.update(o);
		
		serviceP.delete(c3.getId());
		
		
		Ticket t1 = new Ticket(1.0);
		Ticket t2 = new Ticket(2.0);
		Ticket t3 = new Ticket(3.0);
		serviceT.add(t1,o.getId());
		System.out.println(serviceP.getAllTicketByClientOrgaDto(o.getId())+ "    1      11     1 1 1 1");
		serviceT.add(t2,o.getId());
		System.out.println(serviceP.getAllTicketByClientOrgaDto(o.getId())+"    2    2 2 2  2 2   2  2 2 ");
		serviceT.add(t3,o.getId());
		System.out.println(serviceP.getAllTicketByClientOrgaDto(o.getId())+"      3     3  3 3  3 33 3 3 ");
		
		
		System.out.println(serviceT.getAllTicket());
		System.out.println(serviceT.getOne(t1.getId()));
		t1.setPrix(88.8);
		System.out.println(serviceT.update(t1));
		//serviceT.delete(t3.getId());
		
		
		Lot l1 = new LotPerdant(0.0,"l1");
		Lot l2 = new LotGagnant(5.0,"l2");
		Lot l21 = new LotGagnant(5.0,"l21");
		Lot l22 = new LotGagnant(5.0,"l22");
		Lot l3 = new GrosLotGagnant(20.0,"l3");
		Lot l31 = new GrosLotGagnant(20.0,"l31");
		Lot l32 = new GrosLotGagnant(20.0,"l32");
		serviceL.add(l1,p.getId());
		serviceL.add(l2,p.getId());serviceL.add(l21,p.getId());serviceL.add(l22,p.getId());
		serviceL.add(l3,p.getId());serviceL.add(l31,p.getId());serviceL.add(l32,p.getId());
		
		
		System.out.println(serviceL.getOne(l1.getId()));
		System.out.println(serviceL.getAllLot());
		l1.setLabel("BERLIN");;
		System.out.println(serviceL.update(l1));
		//serviceL.delete(l3.getId());
		
		System.out.println(serviceP.acheter(c.getId(), t1.getId()));
		System.out.println(serviceP.getAllTicketByClientOrgaDto(c.getId()));
		
		System.out.println(serviceP.getAllTicketByClientOrga(c.getId()));
		serviceP.acheter(c.getId(), t2.getId());
		serviceP.acheter(c2.getId(), t3.getId());
		
		System.out.println("****************************");
		serviceT.tirage(90,5,5);
		serviceT.tirage(90,5,5);
		
		o.setNom("REVOLUTION");
		serviceP.update(o);
		
		
		System.out.println(serviceP.getAllLotByPartenaire(p.getId()));
		System.out.println(serviceP.getAllLotByPartenaireDto(p.getId()));
		
		p.setNom("Partenaire");
		System.out.println(p+".................p");
		//serviceP.update(p);
		System.out.println(p+".................p");
		
		System.out.println("****************************");
		System.out.println(serviceP.getAllTicketByClientOrgaDto(o.getId()));
		System.out.println(serviceP.getAllLotByClient(c.getId()));
		
		System.out.println("****************************");
		System.out.println(serviceP.getAllLotByClient(c.getId()) + "**");
		System.out.println(serviceP.getAllTicketByClientOrgaDto(c.getId())+ "***");
		System.out.println(serviceP.getAllTicketByClientOrgaDto(o.getId())+ "****");
		
	}

}
