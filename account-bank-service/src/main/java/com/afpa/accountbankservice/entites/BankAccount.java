package com.afpa.accountbankservice.entites;

import com.afpa.accountbankservice.enums.TypeAccount;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yy")
    private Date createdAt;
    private String currency;
    @Enumerated(value = EnumType.STRING)
    private TypeAccount type;

}
