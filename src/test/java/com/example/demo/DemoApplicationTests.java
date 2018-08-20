package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import org.junit.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  @Autowired
  private JobRepository jobRepository;

  @Test
  public void contextLoads() {
  }

  @Test
  public void setUp() {
    Job programmer = new Job();
    programmer.setTitle("Programmer");
    programmer.setEmployer("Apple");
    programmer.setDescription("Here is the description");

    jobRepository.save(programmer);
//  jobRepository.findByTitle(programmer.getTitle());
    assertEquals(jobRepository.findById(1L).get().getTitle()
            , "Programmer");
  }


  @Test
  public void job2() {
    Job job2 = new Job();
    job2.setTitle("Teacher");
    job2.setEmployer("Montgomery College");
    job2.setDescription("Teaches classes");

    jobRepository.save(job2);
//  jobRepository.findByTitle(programmer.getTitle());
    assertEquals(jobRepository.findById(1L).get().getTitle()
            , "Teacher");
  }

  @Test
  public void jobTest() {
    Job newJob = new Job("Designer", "Tesla",
            "Some Description");
    jobRepository.save(newJob);
    jobRepository.findByTitle(newJob.getTitle());
    assertEquals(jobRepository.findByTitle("Designer").getTitle()
            , "Designer");
  }


  @Test
  public void jobCodeTest() {
    Job newJob2 = new Job("Doctor", 234, "Hosptial",
            "A Doctor Some Stuff");
    jobRepository.save(newJob2);
    jobRepository.findByJobCode(newJob2.getJobCode());
    assertEquals(jobRepository.findByJobCode(234).getJobCode()
            , 234);
  }


}
