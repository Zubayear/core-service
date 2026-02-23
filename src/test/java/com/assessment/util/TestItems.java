package com.assessment.util;

import com.assessment.api.model.ItemDTO;
import com.assessment.infrastructure.adapter.persistence.ItemEntity;
import com.assessment.application.domain.model.Item;

import java.util.List;

public class TestItems {

    public static List<ItemDTO> createTestItemDTOs() {
        var itemA = ItemDTO.builder().id(1L).name("Item A").build();
        var itemB = ItemDTO.builder().id(2L).name("Item B").build();
        var itemC = ItemDTO.builder().id(3L).name("Item C").build();

        return List.of(itemA, itemB, itemC);
    }

    public static List<Item> createTestItems() {
        var itemA = Item.builder().id(1L).name("Item A").build();
        var itemB = Item.builder().id(2L).name("Item B").build();
        var itemC = Item.builder().id(3L).name("Item C").build();

        return List.of(itemA, itemB, itemC);
    }

    public static List<ItemEntity> createTestItemEntities() {
        var itemA = ItemEntity.builder().id(1L).name("Item A").build();
        var itemB = ItemEntity.builder().id(2L).name("Item B").build();
        var itemC = ItemEntity.builder().id(3L).name("Item C").build();

        return List.of(itemA, itemB, itemC);
    }

}
