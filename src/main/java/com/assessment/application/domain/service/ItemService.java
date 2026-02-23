package com.assessment.application.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.assessment.application.domain.model.Item;
import com.assessment.application.exception.ItemIdAlreadySetException;
import com.assessment.application.port.ItemRepositoryPort;
import com.assessment.application.port.ItemWebPort;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService implements ItemWebPort {

    private final ItemRepositoryPort port;

    @Override
    public Optional<Item> read(Long id) {
        return port.read(id);
    }

    @Override
    public List<Item> read() {
        return port.read();
    }

    @Override
    public void create(Item item) {
        if (item.getId() != null) {
            throw new ItemIdAlreadySetException(item.getId());
        }

        port.create(item);
    }

    @Override
    public void upsert(Long itemId, Item item) {
        port.upsert(itemId, item);
    }

    @Override
    public void delete(Long itemId) {
        port.delete(itemId);
    }

}
