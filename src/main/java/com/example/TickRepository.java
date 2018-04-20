package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class TickRepository {
	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void init() {
		em.persist(new Tick());
	}

	public List<Tick> obterTodos() {
		List<Tick> ticks = new ArrayList<>();

		try {
			TypedQuery<Tick> query = em.createQuery("SELECT tick FROM Tick", Tick.class);
			ticks = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ticks;
	}

}
