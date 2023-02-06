//package com.afpa.accountbankservice.web;
//
//import com.afpa.accountbankservice.entites.BankAccount;
//import com.afpa.accountbankservice.repositories.BankAccountRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Controller @AllArgsConstructor
//public class BankAccountGraphql {
//    private BankAccountRepo bankAccountRepo;
//    @QueryMapping
//    public List<BankAccount> accountList(){
//        return bankAccountRepo.findAll();
//    }
//
//}
