package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class TickController {
	@Autowired
	TickService tickService;

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping("/db")
	String db(Map<String, Object> model) {

		try {
			List<String> ticksString = new ArrayList<>();

			for (Tick tick : tickService.obterTodos()) {
				ticksString.add("Read from DB: " + tick.getTick());
			}

			model.put("records", ticksString);
			return "db";
		} catch (Exception e) {
			model.put("message", e.getMessage());
			return "error";
		}
	}
}
