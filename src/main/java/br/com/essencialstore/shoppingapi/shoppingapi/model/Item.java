package br.com.essencialstore.shoppingapi.shoppingapi.model;

import br.com.essencialstore.shoppingapi.shoppingapi.dto.ItemDTO;

import javax.persistence.Embeddable;

@Embeddable
public class Item {
    private String productIdentifier;
    private float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static Item convert(ItemDTO itemDTO){
        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
