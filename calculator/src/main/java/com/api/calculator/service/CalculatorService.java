package com.challenge.calculator.service;

import org.springframework.stereotype.Service;

import com.challenge.calculator.domain.Operation;

@Service
public class CalculatorService {

	public static float add(float first, float second){
		return first + second;
	}

	public static float subtract(float first, float second){
		return first - second;
	}

	public static float divide(float first, float second){
		return first / second;
	}

	public static float multiply(float first, float second){
		return first * second;
	}
}
