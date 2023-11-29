package com.github.youssfbr.patrimony.services;

import com.github.youssfbr.patrimony.dtos.ItemResponseDTO;

import java.util.List;

public interface IItemService {
    List<ItemResponseDTO> findAllItems();
}
