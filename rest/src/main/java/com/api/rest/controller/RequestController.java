package com.challenge.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.challenge.rest.model.Operation;
import com.challenge.rest.model.Result;
import com.challenge.rest.service.RabbitMqSender;

@RestController
public class RequestController {

	private RabbitMqSender rabbitMqSender;

    @Autowired
    public RequestController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

	@GetMapping("/sum")
	public Result sumRequest(@RequestParam(defaultValue = "0.0") float a, @RequestParam(defaultValue = "0.0") float b) {
		Operation operation = new Operation(Operation.OperationType.SUM, a, b);
		Result response = new Result(rabbitMqSender.send(operation));
		return response;
	}

    @GetMapping("/sub")
	public Result subRequest(@RequestParam(defaultValue = "0.0") float a, @RequestParam(defaultValue = "0.0") float b) {
		Operation operation = new Operation(Operation.OperationType.SUBTRACTION, a, b);
		Result response = new Result(rabbitMqSender.send(operation));
		return response;
	}

    @GetMapping("/div")
	public Result divRequest(@RequestParam(defaultValue = "1.0") float a, @RequestParam(defaultValue = "1.0") float b) {
		Operation operation = new Operation(Operation.OperationType.DIVISION, a, b);
		Result response = new Result(rabbitMqSender.send(operation));
		return response;
	}

    @GetMapping("/mult")
	public Result multRequest(@RequestParam(defaultValue = "1.0") float a, @RequestParam(defaultValue = "1.0") float b) {
		Operation operation = new Operation(Operation.OperationType.MULTIPLICATION, a, b);
		Result response = new Result(rabbitMqSender.send(operation));
		return response;
	}
}