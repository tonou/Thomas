package com.adaming.myapp.service.lot;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.lot.LotDaoImpl;
import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;

@Transactional(readOnly=true)
public class LotServiceImpl implements ILotService {

	private LotDaoImpl  dao;
	private final Logger LOGGER = Logger.getLogger("LotServiceImpl");
	
	

	/**
	 * @param dao the dao to set
	 */
	public void setDao(LotDaoImpl dao) {
		LOGGER.info("Injection Lot ****");
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly=false)
	public LotDto add(Lot l,Long idPartenaire) {
		// TODO Auto-generated method stub
		return dao.add(l,idPartenaire);
	}

	@Override
	@Transactional(readOnly=false)
	public LotDto update(Lot l) {
		// TODO Auto-generated method stub
		return dao.update(l);
	}

	@Override
	public LotDto getOne(Long id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public List<LotDto> getAllLot() {
		// TODO Auto-generated method stub
		return dao.getAllLot();
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public List<TicketDto> getAllTicketByLot(Long id) {
		// TODO Auto-generated method stub
		return dao.getAllTicketByLot(id);
	}

	@Override
	public LotDto convertir(Lot lot) {
		// TODO Auto-generated method stub
		return dao.convertir(lot);
	}

}
