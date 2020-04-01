package com.saxo.assignment.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    
	private final Logger LOG = LoggerFactory.getLogger("ClientServiceImpl");
	 
	@Override
	public ClientPortfolio addPortfolio(ClientPortfolio clientPortfolio) {
		LOG.info("Client portfolio added");
		return clientPortfolio;		
	}

	@Override
	public boolean updatePortfolio(ClientPortfolio clientPortfolio) {
		LOG.info("Client portfolio updated");
		return false;	
		
	}

	@Override
	public boolean deletePorfolio(int id) {
		LOG.info("Client portfolio deleted");
		return false;			
	}
	
}
