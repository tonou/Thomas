package com.adaming.myapp.service.personne;

import java.util.List;

import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.OrganisateurDto;
import com.adaming.myapp.entities.dto.PartenaireDto;
import com.adaming.myapp.entities.dto.PersonneDto;
import com.adaming.myapp.entities.dto.TicketDto;

public interface IPersonneService {

	PersonneDto add(Personne personne);
	PersonneDto update(Personne personne);
	PersonneDto getOne(Long id);
	List<PersonneDto> getAllPersonne();	
	void delete(Long id);
	
	List<ClientDto> getAllClient();
	List<PartenaireDto> getAllPartenaire();
	List<OrganisateurDto> getAllOrganisateur();
	
	List<TicketDto> getAllTicketByClientOrgaDto(Long id);
	List<Ticket> getAllTicketByClientOrga(Long id);
	List<LotDto> getAllLotByPartenaireDto(Long id);
	
	TicketDto acheter (Long idClient, Long idTicket);
	
	List<Lot> getAllLotByPartenaire(Long id);
	
	List<LotDto> getAllLotByClient(Long id);
}
