/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.core.service;

import com.am.stoms.model.common.SearchCriteria;
import com.am.stoms.model.core.control.BuyerDao;
import com.am.stoms.model.core.control.ProductDao;
import com.am.stoms.model.core.control.StockDao;
import com.am.stoms.model.core.control.SupplierDao;
import com.am.stoms.model.core.entity.Buyer;
import com.am.stoms.model.core.entity.Product;
import com.am.stoms.model.core.entity.Stock;
import com.am.stoms.model.core.entity.Supplier;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manjul
 */
@Stateless
public class CoreService {

    @Inject
    BuyerDao buyerDao;

    @Inject
    SupplierDao supplierDao;

    @Inject
    ProductDao productDao;

    @Inject
    StockDao stockDao;

    SearchCriteria searchCriteria;

    public List<Buyer> getAllBuyer() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setDeleted(false);
        return buyerDao.getAllBuyer(searchCriteria);
    }

    public Buyer getBuyer(int id) {
        return buyerDao.read(id);
    }

    public void saveBuyer(Buyer buyer) {
        buyerDao.save(buyer);
    }

    public void updateBuyer(Buyer buyer) {
        buyerDao.update(buyer);
    }

    public List<Product> getAllProduct() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setDeleted(false);
        return productDao.getAllProduct(searchCriteria);
    }

    public Product getProduct(int id) {
        return productDao.read(id);
    }

    public void saveProduct(Product product) {
        productDao.save(product);
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public List<Stock> getAllStock() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setDeleted(false);
        return stockDao.getAllStock(searchCriteria);
    }

    public Stock getStock(int id) {
        return stockDao.read(id);
    }

    public void saveProduct(Stock stock) {
        stockDao.save(stock);
    }

    public void updateProduct(Stock stock) {
        stockDao.update(stock);
    }

    public List<Supplier> getAllSupplier() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setDeleted(false);
        return supplierDao.getAllSupplier(searchCriteria);
    }

    public Supplier getSupplier(int id) {
        return supplierDao.read(id);
    }

    public void saveSupplier(Supplier supplier) {
        supplierDao.save(supplier);
    }

    public void updateSupplier(Supplier supplier) {
        supplierDao.update(supplier);
    }
}
