package com.afpa.operationservice;

import com.afpa.operationservice.enums.Operationtype;
import com.afpa.operationservice.model.Operation;
import com.afpa.operationservice.repositories.OperationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class OperationServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(OperationServiceApplication.class, args);

	}
	@Bean
	CommandLineRunner run(OperationRepository operationRepository){
		return args -> {
			for (int i = 0; i <15 ; i++) {
				Operation operation=Operation
						.builder()
						.dateOperation(new Date())
						.amount(Math.random()*10000)
						.type(Math.random()>0.5? Operationtype.CREDIT:Operationtype.DEBIT)
						.build();
				operationRepository.save(operation);

			}

		};
	}

}
