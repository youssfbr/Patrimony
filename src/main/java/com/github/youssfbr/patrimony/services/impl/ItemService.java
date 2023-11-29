package com.github.youssfbr.patrimony.services.impl;

import com.github.youssfbr.patrimony.dtos.ItemResponseDTO;
import com.github.youssfbr.patrimony.repositories.IItemRepository;
import com.github.youssfbr.patrimony.services.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {

    private final IItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ItemResponseDTO> findAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponseDTO::new)
                .toList();
    }
}
