package com.afpa.accountbankservice.web;

import com.afpa.accountbankservice.dto.BankAccountRequestDTO;
import com.afpa.accountbankservice.dto.BankAccountResponseDTO;
import com.afpa.accountbankservice.repositories.BankAccountRepo;
import com.afpa.accountbankservice.service.BankAccountService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/bankaccount")
@Slf4j
public class AccountRestController {
    private BankAccountService bankAccountService;
    private BankAccountRepo bankAccountRepo;

    @GetMapping
    public List<BankAccountResponseDTO> getAllAccount(){
        log.info("\n\n \t METHODE RETURN ALL ACCOUNTS");
       return bankAccountService.findAllAccount();
    }

    @GetMapping("/{id}")
    public BankAccountResponseDTO getAccount(@PathVariable String id){
        return bankAccountService.findAccountParId(id) ;
    }

    @PostMapping("/addaccount")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountDTO){
        return bankAccountService.addAccount(bankAccountDTO);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable String id){

        bankAccountService.deleteAccount(id);
        return String.format(" account with %s is deleted",id);
    }
    @PutMapping("/edit/{id}")
    public BankAccountResponseDTO editeAccount(@PathVariable String id,@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return bankAccountService.updateAccount(id,bankAccountRequestDTO);
    }

}
