package com.letscode.bank811.account.dto;

import com.letscode.bank811.account.model.AccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class AccountRequest {

    @Schema(description = "Account number", example = "600943295")
    private Integer number;
    @Schema(description = "Account agency", example = "3524")
    private Integer agency;
    @Schema(description = "Account balance", example = "850.00")
    private BigDecimal balance;
    @Schema(description = "Account type", example = "PF")
    private AccountType accountType;
}
