package com.sauzny.jkitchen_note.reflection;

import java.time.LocalDateTime;

public class Target {

    public Product product(){
        Product product = new Product();
        product.setId(9869879L);
        product.setName("name");
        product.setSupplierProductNo("SupplierProductNo");
        product.setSupplierName("SupplierName");
        product.setPurchasePrice(123324);
        product.setMinDistribution(8172638);
        product.setMaxDistribution(12425345);
        product.setCreateTime(LocalDateTime.now());
        product.setLastUpdateTime(LocalDateTime.now());
        return product;
    }
}
