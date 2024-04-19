package miu.edu.mockexam;

import miu.edu.mockexam.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MockExamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MockExamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mock exam begins ...");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
