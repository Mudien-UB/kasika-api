package com.hehe.kasika.service.impl;

import com.hehe.kasika.model.Business;
import com.hehe.kasika.model.Item;
import com.hehe.kasika.repository.ItemRepository;
import com.hehe.kasika.service.ItemService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Validated
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item addItem(Business business, String name, Double price, String unit ) {

        if (isNameItemUsed(name, business)) {
            throw new EntityExistsException("Username already exists");
        }

        Item item = Item.builder()
                .name(name)
                .price(price)
                .unit(unit)
                .business(business)
                .build();

        return itemRepository.save(item);

    }

    @Override
    public List<Item> getItems(Business business) {
        return Optional.ofNullable(business.getListItems()).orElse(Collections.emptyList());
    }

    private boolean isNameItemUsed(String name, Business business) {
        return business.getListItems().stream().anyMatch(item -> item.getName().equalsIgnoreCase(name));
    }

}
