package com.hehe.kasika.service;

import com.hehe.kasika.model.Business;
import com.hehe.kasika.model.Item;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemService {

    Item addItem( @NotNull Business business , @NotNull String name, @NotNull Double price, @NotNull String unit);

    List<Item> getItems(@NotNull Business business);
}
