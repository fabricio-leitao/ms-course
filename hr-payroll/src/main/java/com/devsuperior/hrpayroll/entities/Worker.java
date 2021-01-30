package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Worker implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Double dailyIncome;

  public Worker() {
  }

  public Worker(Long id, String name, Double dailyIncome) {
    this.id = id;
    this.name = name;
    this.dailyIncome = dailyIncome;
  }

}
