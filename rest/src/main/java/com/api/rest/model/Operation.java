package com.challenge.rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;


@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Operation.class)
public class Operation implements Serializable {

    public enum OperationType {
        SUM,
        SUBTRACTION,
        DIVISION,
        MULTIPLICATION
    }

    private OperationType operationId;
    private float firstOperand;
    private float secondOperand;
    private UUID requestID;

    public Operation(OperationType operationId, float firstOperand, float secondOperand) {
        this.requestID = UUID.randomUUID();
        this.operationId = operationId;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public Operation() {}

    public OperationType getOperationId() {
        return operationId;
    }

    public void setOperationId(OperationType operationId) {
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

    public UUID getRequestID() {
        return requestID;
    }

    public void setRequestID(UUID requestID) {
        this.requestID = requestID;
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