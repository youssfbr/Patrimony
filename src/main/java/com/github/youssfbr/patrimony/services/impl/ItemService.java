package com.github.youssfbr.patrimony.services.impl;

import com.github.youssfbr.patrimony.dtos.ItemCreateRequestDTO;
import com.github.youssfbr.patrimony.dtos.ItemResponseDTO;
import com.github.youssfbr.patrimony.repositories.IItemRepository;
import com.github.youssfbr.patrimony.services.IItemService;
import com.github.youssfbr.patrimony.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {

    private final IItemRepository itemRepository;
    private static final String NOT_FOUND_MESSAGE = "Resource not found with id ";

    @Override
    @Transactional(readOnly = true)
    public List<ItemResponseDTO> findAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponseDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ItemResponseDTO findItemById(Long id) {
        return itemRepository.findById(id)
                .map(ItemResponseDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE + id));
    }

    @Override
    public ItemResponseDTO createItem(ItemCreateRequestDTO itemCreateRequestDTO) {
        return null;
    }
}
