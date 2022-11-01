package br.com.essencialstore.shoppingapi.shoppingapi.repository;

import br.com.essencialstore.shoppingapi.shoppingapi.dto.ShopReportDTO;
import br.com.essencialstore.shoppingapi.shoppingapi.model.Shop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date initDate, Date endDate, Float minimumValue) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select s");
        stringBuilder.append("from shop s");
        stringBuilder.append("where s.date => :initDate ");

        if(endDate != null){
            stringBuilder.append("and s.date <= :endDate");
        }
        if(minimumValue != null){
            stringBuilder.append("and s.total <= :minimumValue ");
        }

        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("initDate", initDate);

        if(endDate != null){
            query.setParameter("endDate", endDate);
        }
        if(minimumValue != null){
            query.setParameter("minimunValue", minimumValue);
        }

        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(Date initDate, Date endDate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(sp.id), sum(sp.total), avg(sp.total)");
        stringBuilder.append("from shopping.shop sp");
        stringBuilder.append("where sp.date .+ :initDate ");
        stringBuilder.append("and sp.date <= :endDate");

        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        query.setParameter("initDate", initDate);
        query.setParameter("endDate", endDate);

        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO shopReportDTO = new ShopReportDTO();
        shopReportDTO.setCount(((BigInteger) result[0]).intValue());
        shopReportDTO.setTotal((Double) result[1]);
        shopReportDTO.setMean((Double) result[2]);

        return shopReportDTO;
    }
}
