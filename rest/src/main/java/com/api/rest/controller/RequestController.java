package com.challenge.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.challenge.rest.model.Operation;
import com.challenge.rest.service.RabbitMqSender;

@RestController
public class RequestController {

	private RabbitMqSender rabbitMqSender;

    @Autowired
    public RequestController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

	@GetMapping("/sum")
	public float sumRequest(@RequestParam(defaultValue = "0.0") float a, @RequestParam(defaultValue = "0.0") float b) {
		Operation operation = new Operation(Operation.OperationType.SUM, a, b);
		float response = rabbitMqSender.send(operation);
		return response;
	}

    @GetMapping("/sub")
	public float subRequest(@RequestParam(defaultValue = "0.0") float a, @RequestParam(defaultValue = "0.0") float b) {
		Operation operation = new Operation(Operation.OperationType.SUBTRACTION, a, b);
		float response = rabbitMqSender.send(operation);
		return response;
	}

    @GetMapping("/div")
	public float divRequest(@RequestParam(defaultValue = "1.0") float a, @RequestParam(defaultValue = "1.0") float b) {
		Operation operation = new Operation(Operation.OperationType.DIVISION, a, b);
		float response = rabbitMqSender.send(operation);
		return response;
	}

    @GetMapping("/mult")
	public float multRequest(@RequestParam(defaultValue = "1.0") float a, @RequestParam(defaultValue = "1.0") float b) {
		Operation operation = new Operation(Operation.OperationType.MULTIPLICATION, a, b);
		float response = rabbitMqSender.send(operation);
		return response;
	}
}