package com.github.youssfbr.patrimony.dtos;

import com.github.youssfbr.patrimony.entities.Item;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ItemCreateRequestDTO {

    @NotBlank
    private String barcodeLabel;

    @NotBlank
    private String description;

    private LocalDate acquisitionDate;

    public ItemCreateRequestDTO(Item item) {
        barcodeLabel = item.getBarcodeLabel();
        description = item.getDescription();
        acquisitionDate = item.getAcquisitionDate();
    }
}
