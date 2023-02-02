package com.afpa.accountbankservice.service;

import com.afpa.accountbankservice.dto.BankAccountRequestDTO;
import com.afpa.accountbankservice.dto.BankAccountResponseDTO;
import com.afpa.accountbankservice.entites.BankAccount;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BankAccountService {

    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccount);
    BankAccountResponseDTO findAccountParId(String id);
    void deleteAccount(String id);
    BankAccountResponseDTO updateAccount( String id, BankAccountRequestDTO bankAccount);

    List<BankAccountResponseDTO> findAllAccount();

    }
