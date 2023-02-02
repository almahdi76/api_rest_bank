package com.afpa.accountbankservice.service;

import com.afpa.accountbankservice.dto.BankAccountRequestDTO;
import com.afpa.accountbankservice.dto.BankAccountResponseDTO;
import com.afpa.accountbankservice.entites.BankAccount;
import com.afpa.accountbankservice.mapper.BankAccountMapper;
import com.afpa.accountbankservice.repositories.BankAccountRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepo bankAccountRepo;
    private BankAccountMapper accountMapper;

@Override
public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccountResponseDTO bankAccountResponseDTO=null;
        if (bankAccountDTO.getBalance()>55){
            BankAccount account = accountMapper.fromBankAccountRequestDTO(bankAccountDTO);
        account.setId(UUID.randomUUID().toString());
        account.setCreatedAt(new Date());
        BankAccount savedBankAccount = bankAccountRepo.save(account);
         bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        }
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO findAccountParId(String id) {
        BankAccount bankAccount=bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("account with %s not exist",id)));
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(bankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public void deleteAccount(String id) {
        BankAccount bankAccount=bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("account with %s not exist",id)));
        bankAccountRepo.deleteById(id);

    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount account=bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("account with %s not exist",id)));

        if(bankAccountRequestDTO.getType()!=null) account.setType(bankAccountRequestDTO.getType());
        if(bankAccountRequestDTO.getBalance()!=null) account.setBalance(bankAccountRequestDTO.getBalance());
        if(bankAccountRequestDTO.getCurrency()!=null) account.setCurrency(bankAccountRequestDTO.getCurrency());

        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(account);
        return bankAccountResponseDTO;
    }

    @Override
    public List<BankAccountResponseDTO> findAllAccount() {
        List<BankAccount> bankAccountList=bankAccountRepo.findAll();
        List<BankAccountResponseDTO> listDTO=new ArrayList<>();
        for (BankAccount bk:bankAccountList){
            listDTO.add(accountMapper.fromBankAccount(bk));
        }
        return listDTO;
    }


}

