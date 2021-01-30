package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignClients.WorkerFeignClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

  private final WorkerFeignClients workerFeignClients;

  public Payment getPayment(long workerId, int days) {

    Worker worker = workerFeignClients.findById(workerId).getBody();
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}
