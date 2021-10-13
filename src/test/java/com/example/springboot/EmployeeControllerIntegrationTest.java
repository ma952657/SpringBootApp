package com.example.springboot;

import com.example.springboot.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EmployeeControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testEmployee()
    {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/api/v1/employee/1", Employee.class)
                        .getId().equals(1));
    }

    @Test
    public void testAllEmployee() {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/api/v1/employees", List.class).size() == 2);
    }
}

