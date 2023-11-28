package com.github.youssfbr.patrimony.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity(name = "tb_item")
@EqualsAndHashCode(of = "id")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String barcodeLabel;

    @Column(nullable = false)
    private String description;

    private LocalDate acquisitionDate;
}
