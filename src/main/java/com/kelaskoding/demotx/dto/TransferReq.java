package com.kelaskoding.demotx.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferReq {
    private String norek1;
    private String norek2;
    private double saldo;
}
