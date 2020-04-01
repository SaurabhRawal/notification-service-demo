package com.saxo.assignment.client;

public interface ClientService {
	
	ClientPortfolio addPortfolio(ClientPortfolio clientPortfolio);
	boolean updatePortfolio(ClientPortfolio clientPortfolio);
	boolean deletePorfolio(int id);

}
