package com.github.youssfbr.patrimony.dtos;

import com.github.youssfbr.patrimony.entities.Item;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ItemCreateRequestDTO {

    private String barcodeLabel;
    private String description;
    private LocalDate acquisitionDate;

    public ItemCreateRequestDTO(Item item) {
        barcodeLabel = item.getBarcodeLabel();
        description = item.getDescription();
        acquisitionDate = item.getAcquisitionDate();
    }
}
