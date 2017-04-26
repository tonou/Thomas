package com.adaming.myapp.dao.lot;

import java.util.List;

import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;

public interface ILotDao {

	LotDto add(Lot l, Long idPartenaire);
	LotDto update(Lot l);
	LotDto getOne(Long id);
	
	List<LotDto> getAllLot();
	List<Lot> getAllLotPerdant();
	List<Lot> getAllLotGagnant();
	List<Lot> getAllGrosLotGagnant();
	void delete(Long id);
	
	List<TicketDto> getAllTicketByLot(Long id);
	List<Ticket> getAllTicketByLotLot(Long id);
	
	LotDto convertir(Lot lot);
	
	Lot getOneLot(Long id);
	List<Lot> getAllLotLot();
}
