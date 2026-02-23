package com.assessment.application.usecase;

import com.assessment.application.domain.model.Item;

public interface Upsert {

    void upsert(Long itemId, Item item);

}
