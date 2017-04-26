package com.adaming.myapp.service.lot;

import java.util.List;

import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;

public interface ILotService {
	
	LotDto add(Lot l,Long idPartenaire);
	LotDto update(Lot l);
	LotDto getOne(Long id);
	List<LotDto> getAllLot();
	void delete(Long id);
	
	List<TicketDto> getAllTicketByLot(Long id);
	
	LotDto convertir(Lot lot);

}
