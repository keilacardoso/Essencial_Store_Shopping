package br.com.essencialstore.shoppingapi.shoppingapi.controller;

import br.com.essencialstore.shoppingapi.shoppingapi.dto.ShopDTO;
import br.com.essencialstore.shoppingapi.shoppingapi.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops(){
        List<ShopDTO> products = shopService.getAll();
        return products;
    }
    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier){
        List<ShopDTO> products = shopService.getByUser(userIdentifier);
        return products;
    }
    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO){
        List<ShopDTO> products = shopService.getByDate(shopDTO);
        return products;
    }
    @GetMapping("/shopping/{id}")
    public ShopDTO findById(@PathVariable Long id){
        return shopService.findById(id);
    }
    @PostMapping("/shipping")
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO){
        return shopService.save(shopDTO);
    }
}
