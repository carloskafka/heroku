package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TickRepository {
	@PersistenceContext
	private EntityManager em;

	public List<Tick> obterTodos() {
		List<Tick> ticks = new ArrayList<>();

		try {
			TypedQuery<Tick> query = em.createQuery("SELECT t FROM Tick t", Tick.class);
			ticks = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ticks;
	}

	@Transactional
	public void salvar(Tick tick) {
		String acao = "";
		try {

			if (tick.getId() == null) {
				em.persist(tick);
				acao = "Inclusão";
			} else {
				em.merge(tick);
				acao = "Alteração";
			}
			System.out.println(acao + " de " + tick + " realizada com sucesso.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
