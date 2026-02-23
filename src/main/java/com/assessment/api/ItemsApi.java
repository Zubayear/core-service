package com.assessment.api;

import com.assessment.api.model.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemsApi {
    ResponseEntity<Void> postItem(ItemDTO itemDTO);
    ResponseEntity<ItemDTO> getItem(Long id);
    ResponseEntity<List<ItemDTO>> getItems();
    ResponseEntity<Void> deleteItem(Long itemId);
    ResponseEntity<Void> putItem(Long itemId, ItemDTO itemDTO);
}
