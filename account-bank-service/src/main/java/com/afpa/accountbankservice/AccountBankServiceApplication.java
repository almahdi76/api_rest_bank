package com.afpa.accountbankservice;

import com.afpa.accountbankservice.entites.BankAccount;
import com.afpa.accountbankservice.enums.TypeAccount;
import com.afpa.accountbankservice.repositories.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class AccountBankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountBankServiceApplication.class, args);
	}

	//@Bean
	CommandLineRunner run(BankAccountRepo bankAccountRepo){
		Random rnd=new Random(1000);
		return args -> {
			for (int i = 1; i <21 ; i++) {
				BankAccount bankAccount=BankAccount
						.builder()
						.id(UUID.randomUUID().toString())
						.balance(rnd.nextDouble()*10000)
						.createdAt(new Date())
						.currency(Math.random()>0.5?"Euro":"Dollar")
						.type(Math.random()>0.5? TypeAccount.CURRENT_ACCOUNT:TypeAccount.SAVING_ACCOUNT)
						.build();
				bankAccountRepo.save(bankAccount);
			}

		};
	}

}
