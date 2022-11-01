package com.kelaskoding.demotx.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_rekening")
@Data
public class Rekening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String norek;
    private String name;
    private double saldo;
}
