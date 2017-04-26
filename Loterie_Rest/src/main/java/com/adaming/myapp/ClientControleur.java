 package com.adaming.myapp;


 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Organisateur;
import com.adaming.myapp.entities.Partenaire;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.OrganisateurDto;
import com.adaming.myapp.entities.dto.PartenaireDto;
import com.adaming.myapp.entities.dto.PersonneDto;
import com.adaming.myapp.entities.dto.TicketDto;
import com.adaming.myapp.service.personne.IPersonneService;
 
@RestController
public class ClientControleur {

	@Autowired
	private IPersonneService pS;
	
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public PersonneDto addC(@RequestBody Client c) {
		return pS.add(c);
	}
	
	@RequestMapping(value = "/addPartenaire", method = RequestMethod.POST)
	public PersonneDto addP(@RequestBody Partenaire p) {
		return pS.add(p);
	}
	
	@RequestMapping(value = "/addOrganisateur", method = RequestMethod.POST)
	public PersonneDto addO(@RequestBody Organisateur o) {
		return pS.add(o);
	}
	
	@RequestMapping(value = "/getAllPersonne", method = RequestMethod.GET)
	public List<PersonneDto> getAllP() {
		return pS.getAllPersonne();
	}
		
	@RequestMapping(value = "/getAllClient", method = RequestMethod.GET)
	public List<ClientDto> getAllC() {
		return pS.getAllClient();
	}
	
	@RequestMapping(value = "/getAllOrganisateur", method = RequestMethod.GET)
	public List<OrganisateurDto> getAllO() {
		return pS.getAllOrganisateur();
	}
	
	@RequestMapping(value = "/getAllPartenaire", method = RequestMethod.GET)
	public List<PartenaireDto> getAllPart() {
		return pS.getAllPartenaire();
	}
	
	@RequestMapping(value = "/getOnePersonne/{idPersonne}", method = RequestMethod.GET)
	public PersonneDto getOneP(@PathVariable Long idPersonne) {
		return pS.getOne(idPersonne);
	}
	
	@RequestMapping(value = "/updatePersonne", method = RequestMethod.POST)
	public PersonneDto updateP(@PathVariable Personne personne) {
		return pS.update(personne);
	}
	
	@RequestMapping(value = "/deletePersonne/{idPersonne}", method = RequestMethod.DELETE)
	public void deleteP(@PathVariable Long idPersonne) {
		pS.delete(idPersonne);
	}
	
	@RequestMapping(value = "/getAllTicketByClient/{idPersonne}", method = RequestMethod.GET)
	public List<TicketDto> getAllTicketByClient(@PathVariable Long idPersonne) {
		return pS.getAllTicketByClientOrgaDto(idPersonne);
	}
	
	@RequestMapping(value = "/acheter/{idClient}/{idTicket}", method = RequestMethod.GET)
	public TicketDto acheter(@PathVariable Long idClient,@PathVariable Long idTicket) {
		return pS.acheter(idClient, idTicket);
	}
	
	@RequestMapping(value = "/getAllLotByClient/{idClient}", method = RequestMethod.GET)
	public List<LotDto> getAllLotByClient(@PathVariable Long idClient) {
		return pS.getAllLotByClient(idClient);
	}
	
	
	
	
}
