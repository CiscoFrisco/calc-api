package com.challenge.calculator.service;

import com.challenge.calculator.domain.Operation;
import com.challenge.calculator.service.CalculatorService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(Operation operation) {
        
        logger.info("Operation Details Received is.. " + operation);

        float result = -1;
        
        switch(operation.getOperationId()){
            case SUM:
                result = CalculatorService.add(operation.getFirstOperand(), operation.getSecondOperand());
                break;
            case SUBTRACTION:
                result = CalculatorService.subtract(operation.getFirstOperand(), operation.getSecondOperand());
                break;
            case DIVISION:
                result = CalculatorService.divide(operation.getFirstOperand(), operation.getSecondOperand());
                break;
            case MULTIPLICATION:
                result = CalculatorService.multiply(operation.getFirstOperand(), operation.getSecondOperand());
                break;
            default:
                break;
        }

        logger.info("Calculated result of.. " + result);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}