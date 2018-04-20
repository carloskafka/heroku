package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class TickService {

	@Inject
	private TickRepository tickRepository;

	public List<String> obterTodos() {
		List<String> ticksString = new ArrayList<>();

		try {
			for (Tick tick : tickRepository.obterTodos()) {
				ticksString.add("Read from DB: " + tick.getTickString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ticksString;
	}

	public void salvar(Tick tick) {
		tickRepository.salvar(tick);
	}

}
