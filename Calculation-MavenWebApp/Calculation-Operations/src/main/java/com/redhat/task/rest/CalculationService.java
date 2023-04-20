package com.redhat.task.rest;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.task.model.Calculation;
import com.redhat.task.model.CalculationResult;

@Stateless
@Path("/") 
public class CalculationService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//Save calculation object as a row to Database
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("calc")
	public CalculationResult CreateCalculation(Calculation calculation) {
		int result;
		try {
			if(calculation != null) {
				entityManager.persist(calculation);
			}
		}catch (Exception e) {
			throw new EJBException(e); 
		}
		
		switch(calculation.getOperation()) {
			
			case "-": {
				result = calculation.getNumber1() - calculation.getNumber2();
				return new CalculationResult(result);
			}
			case "+": {
				result = calculation.getNumber1() + calculation.getNumber2();
				return new CalculationResult(result);
			}
			case "/": {
				result = calculation.getNumber1() / calculation.getNumber2();
				return new CalculationResult(result);
			}
			case "*": {
				result = calculation.getNumber1() * calculation.getNumber2();
				return new CalculationResult(result);
			}
			default: 
				throw new IllegalArgumentException("Invalid Operation Type");
		}
	}
	
	//retrieve calculations 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("calculations") 
	public List<Calculation> GetCalculation() {
		TypedQuery<Calculation> query = entityManager.createQuery("SELECT c FROM Calculation c",Calculation.class);
		List<Calculation> calculations = query.getResultList();
		return calculations;
	}
	
}