package com.challenge.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.challenge.rest.domain.Operation;
import com.challenge.rest.service.RabbitMqSender;

@RestController
public class RequestController {

	private RabbitMqSender rabbitMqSender;

    @Autowired
    public RequestController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

	@GetMapping("/sum")
	public void sumRequest(@RequestParam(defaultValue = "0.0") float a, @RequestParam(defaultValue = "0.0") float b) {
		Operation operation = new Operation("SUM", a, b);
		rabbitMqSender.send(operation);
        System.out.println("SUM operation with operands: " + a + "|" + b);
	}

    @GetMapping("/sub")
	public void subRequest(@RequestParam(defaultValue = "0.0") float a, @RequestParam(defaultValue = "0.0") float b) {
		Operation operation = new Operation("SUB", a, b);
		rabbitMqSender.send(operation);
        System.out.println("SUBTRACTION operation with operands: " + a + "|" + b);
	}

    @GetMapping("/div")
	public void divRequest(@RequestParam(defaultValue = "1.0") float a, @RequestParam(defaultValue = "1.0") float b) {
		Operation operation = new Operation("DIV", a, b);
		rabbitMqSender.send(operation);
        System.out.println("DIVISION operation with operands: " + a + "|" + b);
	}

    @GetMapping("/mult")
	public void multRequest(@RequestParam(defaultValue = "1.0") float a, @RequestParam(defaultValue = "1.0") float b) {
		Operation operation = new Operation("MULT", a, b);
		rabbitMqSender.send(operation);
        System.out.println("MULTIPLICATION operation with operands: " + a + "|" + b);
	}
}