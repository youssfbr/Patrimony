package com.github.youssfbr.patrimony.controllers;

import com.github.youssfbr.patrimony.dtos.ItemCreateRequestDTO;
import com.github.youssfbr.patrimony.dtos.ItemResponseDTO;
import com.github.youssfbr.patrimony.services.IItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ItemResponseDTO> itemCreate(@Valid @RequestBody ItemCreateRequestDTO itemCreateRequestDTO) {

        final ItemResponseDTO item = itemService.createItem(itemCreateRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity.created(location).body(item);
    }
}
