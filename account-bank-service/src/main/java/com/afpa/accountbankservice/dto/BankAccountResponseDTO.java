package com.afpa.accountbankservice.dto;

import com.afpa.accountbankservice.enums.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Double balance;
    private String currency;
    private TypeAccount type;

}
