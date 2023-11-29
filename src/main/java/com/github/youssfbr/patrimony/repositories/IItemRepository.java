package com.github.youssfbr.patrimony.repositories;

import com.github.youssfbr.patrimony.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item, Long> {
}
