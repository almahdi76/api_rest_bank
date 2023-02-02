package com.afpa.accountbankservice.repositories;

import com.afpa.accountbankservice.entites.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepo extends JpaRepository<BankAccount,String> {

}
