package com.api.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public float add(float first, float second){
		return first + second;
	}

	public float subtract(float first, float second){
		return first - second;
	}

	public float divide(float first, float second){
		return first / second;
	}

	public float multiply(float first, float second){
		return first * second;
	}
}
