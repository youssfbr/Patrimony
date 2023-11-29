package com.github.youssfbr.patrimony.dtos;

import com.github.youssfbr.patrimony.entities.Item;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ItemResponseDTO {

    private Long id;
    private String barcodeLabel;
    private String description;
    private LocalDate acquisitionDate;

    public ItemResponseDTO(Item item) {
        id = item.getId();
        barcodeLabel = item.getBarcodeLabel();
        description = item.getDescription();
        acquisitionDate = item.getAcquisitionDate();
    }
}
