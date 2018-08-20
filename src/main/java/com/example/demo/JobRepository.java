package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
  Job findByTitle(String title);
  Job findByJobCode(int jobCode);
}
