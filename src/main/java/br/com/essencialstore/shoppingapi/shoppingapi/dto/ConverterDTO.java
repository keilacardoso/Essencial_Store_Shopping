package br.com.essencialstore.shoppingapi.shoppingapi.dto;

import br.com.essencialstore.shoppingapi.shoppingapi.model.Item;
import br.com.essencialstore.shoppingapi.shoppingapi.model.Shop;

import java.util.stream.Collectors;

public class ConverterDTO {
    public static ItemDTO convert(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }
    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        shopDTO.setItems(shop.getItems().stream().map(ConverterDTO::convert).collect(Collectors.toList()));
        return shopDTO;
    }
}
