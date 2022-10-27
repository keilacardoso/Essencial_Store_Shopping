package br.com.essencialstore.shoppingapi.shoppingapi.repository;

import br.com.essencialstore.shoppingapi.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    public List<Shop> findAllByUserIdentifier(String userIdentifier);
    public List<Shop> findAllByTotalGreaterThen(Float total);
    public List<Shop> findAllByDateGreaterThanEquals(Date date);
}
