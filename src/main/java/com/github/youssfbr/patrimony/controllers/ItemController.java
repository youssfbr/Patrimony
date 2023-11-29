package com.github.youssfbr.patrimony.controllers;

import com.github.youssfbr.patrimony.dtos.ItemResponseDTO;
import com.github.youssfbr.patrimony.services.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final IItemService itemService;
    @GetMapping
    public List<ItemResponseDTO> findAllItems() {
        return  itemService.findAllItems();
    }
}
