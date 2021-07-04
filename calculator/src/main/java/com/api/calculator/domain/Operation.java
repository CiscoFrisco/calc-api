package com.challenge.calculator.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Operation.class)
public class Operation implements Serializable {

    private String operationId;
    private float firstOperand;
    private float secondOperand;

    public Operation(String operationId, float firstOperand, float secondOperand) {
        this.operationId = operationId;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public Operation() {}

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public float getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(float firstOperand) {
        this.firstOperand = firstOperand;
    }

    public float getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(float secondOperand) {
        this.secondOperand = secondOperand;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId='" + operationId + '\'' +
                ", firstOperand='" + firstOperand + '\'' +
                ", secondOperand='" + secondOperand + '\'' +
                '}';
    }
}