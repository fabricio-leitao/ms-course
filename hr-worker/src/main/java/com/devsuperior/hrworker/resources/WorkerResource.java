package com.devsuperior.hrworker.resources;

import java.util.List;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("workers")
@RequiredArgsConstructor
public class WorkerResource {

  private final WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = repository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {
    Worker obj = repository.findById(id).get();
    return ResponseEntity.ok(obj);
  }

}
