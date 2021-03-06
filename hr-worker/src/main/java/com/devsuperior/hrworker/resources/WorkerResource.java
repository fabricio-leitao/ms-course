package com.devsuperior.hrworker.resources;

import java.util.List;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
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

  private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

  private final Environment env;

  private final WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = repository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {

	/*try {
		Thread.sleep(3000L);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	  
    logger.info("PORT = " + env.getProperty("local.server.port"));

    Worker obj = repository.findById(id).get();
    return ResponseEntity.ok(obj);
  }

}
