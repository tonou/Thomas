package com.adaming.myapp.service.personne;

import java.util.List;
import java.util.logging.Logger;









import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.personne.PersonneDaoImpl;
import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.ClientDto;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.OrganisateurDto;
import com.adaming.myapp.entities.dto.PartenaireDto;
import com.adaming.myapp.entities.dto.PersonneDto;
import com.adaming.myapp.entities.dto.TicketDto;


@Transactional(readOnly=true)
public class PersonneServiceImpl implements IPersonneService{

	private PersonneDaoImpl  dao;
	private final Logger LOGGER = Logger.getLogger("PersonneServiceImpl");
	
	
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(PersonneDaoImpl dao) {
		LOGGER.info("Injection Personne ****");
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly=false)
	public PersonneDto add(Personne personne) {
		// TODO Auto-generated method stub
		return dao.add(personne);
	}

	@Override
	@Transactional(readOnly=false)
	public PersonneDto update(Personne personne) {
		// TODO Auto-generated method stub
		return dao.update(personne);
	}

	@Override
	public PersonneDto getOne(Long id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public List<PersonneDto> getAllPersonne() {
		// TODO Auto-generated method stub
		return dao.getAllPersonne();
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public List<ClientDto> getAllClient() {
		// TODO Auto-generated method stub
		return dao.getAllClient();
	}

	@Override
	public List<PartenaireDto> getAllPartenaire() {
		// TODO Auto-generated method stub
		return dao.getAllPartenaire();
	}

	@Override
	public List<OrganisateurDto> getAllOrganisateur() {
		// TODO Auto-generated method stub
		return dao.getAllOrganisateur();
	}

	@Override
	public List<TicketDto> getAllTicketByClientOrgaDto(Long id) {
		// TODO Auto-generated method stub
		return dao.getAllTicketByClientOrgaDto(id);
	}

	@Override
	public List<LotDto> getAllLotByPartenaireDto(Long id) {
		// TODO Auto-generated method stub
		return dao.getAllLotByPartenaireDto(id);
	}

	@Override
	public TicketDto acheter(Long idClient, Long idTicket) {
		// TODO Auto-generated method stub
		return dao.acheter(idClient, idTicket);
	}

	@Override
	public List<Ticket> getAllTicketByClientOrga(Long id) {
		// TODO Auto-generated method stub
		return dao.getAllTicketByClientOrga(id);
	}

	@Override
	public List<Lot> getAllLotByPartenaire(Long id) {
		// TODO Auto-generated method stub
		return dao.getAllLotByPartenaire(id);
	}

	@Override
	public List<LotDto> getAllLotByClient(Long id) {
		// TODO Auto-generated method stub
		return dao.getAllLotByClient(id);
	}

}
