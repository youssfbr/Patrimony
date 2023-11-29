package com.github.youssfbr.patrimony.controllers;

import com.github.youssfbr.patrimony.dtos.ItemResponseDTO;
import com.github.youssfbr.patrimony.services.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return itemService.findAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseDTO> findItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.findItemById(id));
    }
}
