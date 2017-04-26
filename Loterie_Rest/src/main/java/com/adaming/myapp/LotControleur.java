package com.adaming.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.myapp.entities.GrosLotGagnant;
import com.adaming.myapp.entities.Lot;
import com.adaming.myapp.entities.LotGagnant;
import com.adaming.myapp.entities.LotPerdant;
import com.adaming.myapp.entities.Ticket;
import com.adaming.myapp.entities.dto.LotDto;
import com.adaming.myapp.entities.dto.TicketDto;
import com.adaming.myapp.service.lot.ILotService;

@RestController
public class LotControleur {

	@Autowired
	private ILotService lS;
	
	@RequestMapping(value = "/addLotPerdant/{idPartenaire}", method = RequestMethod.POST)
	public LotDto addLP(@RequestBody LotPerdant l, @PathVariable Long idPartenaire) {
		return lS.add(l, idPartenaire);
	}
	
	@RequestMapping(value = "/addLotGagnant/{idPartenaire}", method = RequestMethod.POST)
	public LotDto addLG(@RequestBody LotGagnant l, @PathVariable Long idPartenaire) {
		return lS.add(l, idPartenaire);
	}
	
	@RequestMapping(value = "/addGrosLotGagnant/{idPartenaire}", method = RequestMethod.POST)
	public LotDto addGLG(@RequestBody GrosLotGagnant l, @PathVariable Long idPartenaire) {
		return lS.add(l, idPartenaire);
	}
	
	
	
	@RequestMapping(value = "/getAllLot", method = RequestMethod.GET)
	public List<LotDto> getAllL() {
		return lS.getAllLot();
	}
	
	@RequestMapping(value = "/getOneLot/{idLot}", method = RequestMethod.GET)
	public LotDto getOneP(@PathVariable Long idLot) {
		return lS.getOne(idLot);
	}
	
	@RequestMapping(value = "/updateLot", method = RequestMethod.POST)
	public LotDto updateL(@PathVariable Lot l) {
		return lS.update(l);
	}
	
	@RequestMapping(value = "/deleteLot/{idLot}", method = RequestMethod.DELETE)
	public void deleteL(@PathVariable Long idLot) {
		lS.delete(idLot);
	}
		
		
		@RequestMapping(value = "/getAllTicketByLot/{idLot}", method = RequestMethod.GET)
		public List<TicketDto>  getAllTicketByLot(@PathVariable Long idLot) {
			return lS.getAllTicketByLot(idLot);
		
	}
}
