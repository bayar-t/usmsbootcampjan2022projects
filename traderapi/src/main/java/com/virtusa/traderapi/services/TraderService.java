package com.virtusa.traderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.repositories.TraderRepo;

@Service
public class TraderService {

	@Autowired
	private TraderRepo traderRepo;
	
	public Trader addTrader(Trader trader) {
		return this.traderRepo.save(trader);
	}
	
	public List<Trader> getAllTraders() {
		return this.traderRepo.findAll();
	}
	
	public Trader getTraderById(long traderId) {
		return this.traderRepo.findById(traderId).orElse(null);
	}
	
	public boolean deleteTraderById(long traderId) {
		boolean status = false;
		this.traderRepo.deleteById(traderId);
		if(this.getTraderById(traderId) == null)
			status = true;
		return status;
	}
}
