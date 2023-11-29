package com.github.youssfbr.patrimony.entities;

import com.github.youssfbr.patrimony.dtos.ItemCreateRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
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

    public Item(ItemCreateRequestDTO itemCreateRequestDTO) {
        barcodeLabel = itemCreateRequestDTO.getBarcodeLabel();
        description = itemCreateRequestDTO.getDescription();
        acquisitionDate = itemCreateRequestDTO.getAcquisitionDate();
    }
}
