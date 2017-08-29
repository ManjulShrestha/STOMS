/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.controller.core;

import com.am.stoms.commons.NavigationService;
import com.am.stoms.model.core.entity.Product;
import com.am.stoms.model.core.service.CoreService;
import com.am.stoms.model.metadata.entity.Color;
import com.am.stoms.model.metadata.entity.Manufacturer;
import com.am.stoms.model.metadata.entity.Model;
import com.am.stoms.model.metadata.entity.Unit;
import com.am.stoms.model.metadata.service.MetadataService;
import com.am.stoms.utils.GenericDataModel;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author manjul
 */
@ManagedBean
@ViewScoped
public class ProductController {

    @Inject
    CoreService coreService;

    @Inject
    MetadataService metadataService;

    @ManagedProperty("#{navigationService}")
    NavigationService navService;

    RequestContext requestContext;
    private Product product;
    private List<Color> listColor;
    private List<Manufacturer> listManufacturer;
    private List<Model> listModel;
    private List<Product> listProduct;
    private LazyDataModel<Product> productDataModel;
    private boolean renderEditPanel, addMode, addButtonDisabled;

    @PostConstruct
    public void init() {
        try {
            listProduct = coreService.getAllProduct();
            productDataModel = new GenericDataModel<>(listProduct, Product.class);
            listColor = metadataService.getAllColor();
            listManufacturer = metadataService.getAllManufacturer();
            listModel = metadataService.getAllModel();
        } catch (Exception e) {
            growl("Error Occured", FacesMessage.SEVERITY_ERROR, "Could not fetch products");
        }
    }

    private void growl(String msg, FacesMessage.Severity severity, String errorCode) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, msg, errorCode));
        requestContext = RequestContext.getCurrentInstance();
        requestContext.update("growl_form");
    }

    public void addNewProduct() {
        addMode = true;
        renderEditPanel = true;
        product = new Product();
    }

    public void onEditProduct(Product product) {
        renderEditPanel = true;
        this.product = product;
        addMode = false;
        for (Model model : listModel) {
            if (Objects.equals(product.getModel().getId(), model.getId())) {
                this.product.setModel(model);
                break;
            }
        }
        for (Manufacturer manufacturer : listManufacturer) {
            if (Objects.equals(product.getManufacturer().getId(), manufacturer.getId())) {
                this.product.setManufacturer(manufacturer);
                break;
            }
        }
        for (Color color : listColor) {
            if (Objects.equals(product.getColor().getId(), color.getId())) {
                this.product.setColor(color);
                break;
            }
        }
    }

    public void onDeleteProduct(Product product) {
        try {
            product.setDeleted(true);            
            coreService.updateProduct(product);
            listProduct.remove(product);
            growl("Deleted", FacesMessage.SEVERITY_INFO, "Product Deleted sucessfully!");
        } catch (Exception e) {

        }
    }

    public void onFormSubmit() {
        try {
            if (addMode) {
                coreService.saveProduct(product);
                listProduct.add(product);
                growl("Saved", FacesMessage.SEVERITY_INFO, "Product saved sucessfully!");
            } else {
                coreService.updateProduct(product);
                growl("Updated", FacesMessage.SEVERITY_INFO, "Product updated sucessfully!");
            }
            renderEditPanel = false;
            addButtonDisabled = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCancel() {
        renderEditPanel = false;
        addMode = false;
    }

    public NavigationService getNavService() {
        return navService;
    }

    public void setNavService(NavigationService navService) {
        this.navService = navService;
    }

    public CoreService getCoreService() {
        return coreService;
    }

    public void setCoreService(CoreService coreService) {
        this.coreService = coreService;
    }

    public Product getProduct() {
        if (product == null) {
            product = new Product();
        }
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Color> getListColor() {
        return listColor;
    }

    public void setListColor(List<Color> listColor) {
        this.listColor = listColor;
    }

    public List<Manufacturer> getListManufacturer() {
        return listManufacturer;
    }

    public void setListManufacturer(List<Manufacturer> listManufacturer) {
        this.listManufacturer = listManufacturer;
    }

    public List<Model> getListModel() {
        return listModel;
    }

    public void setListModel(List<Model> listModel) {
        this.listModel = listModel;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public LazyDataModel<Product> getProductDataModel() {
        return productDataModel;
    }

    public void setProductDataModel(LazyDataModel<Product> productDataModel) {
        this.productDataModel = productDataModel;
    }

    public boolean isRenderEditPanel() {
        return renderEditPanel;
    }

    public void setRenderEditPanel(boolean renderEditPanel) {
        this.renderEditPanel = renderEditPanel;
    }

    public boolean isAddMode() {
        return addMode;
    }

    public void setAddMode(boolean addMode) {
        this.addMode = addMode;
    }

    public boolean isAddButtonDisabled() {
        return addButtonDisabled;
    }

    public void setAddButtonDisabled(boolean addButtonDisabled) {
        this.addButtonDisabled = addButtonDisabled;
    }
}
