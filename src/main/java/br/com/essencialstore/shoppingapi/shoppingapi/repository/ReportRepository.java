package br.com.essencialstore.shoppingapi.shoppingapi.repository;

import br.com.essencialstore.shoppingapi.shoppingapi.dto.ShopReportDTO;
import br.com.essencialstore.shoppingapi.shoppingapi.model.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {
    public List<Shop> getShopByFilters(Date initDate, Date endDate, Float minimumValue);
    public ShopReportDTO getReportByDate(Date initDate, Date endDate);
}
