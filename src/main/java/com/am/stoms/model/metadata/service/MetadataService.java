/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.metadata.service;

import com.am.stoms.model.metadata.control.ColorDao;
import com.am.stoms.model.metadata.control.CountryDao;
import com.am.stoms.model.metadata.control.ManufacturerDao;
import com.am.stoms.model.metadata.control.ModelDao;
import com.am.stoms.model.metadata.control.UnitDao;
import com.am.stoms.model.metadata.entity.Color;
import com.am.stoms.model.metadata.entity.Country;
import com.am.stoms.model.metadata.entity.Manufacturer;
import com.am.stoms.model.metadata.entity.Model;
import com.am.stoms.model.metadata.entity.Unit;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manjul
 */
@Stateless
public class MetadataService {
    
    @Inject
    ColorDao colorDao;
    
    @Inject
    CountryDao countryDao;
    
    @Inject
    ManufacturerDao manufacturerDao;
    
    @Inject
    ModelDao modelDao;
    
    @Inject
    UnitDao unitDao;
    
    public List<Color> getAllColor(){
        return colorDao.getAllColor(null);
    }
    
    public Color getColor(int id){
        return colorDao.read(id);
    }
    
    public void saveColor(Color color){
        colorDao.save(color);
    }
    
    public void updateColor(Color color){
        colorDao.update(color);
    }
    
    public List<Country> getAllCountry(){
        return countryDao.getAllCountry(null);
    }
    
    public Country getCountry(int id){
        return countryDao.read(id);
    }
    
    public void saveCountry(Country country){
        countryDao.save(country);
    }
    
    public void updateCountry(Country country){
        countryDao.update(country);
    }
    
    public List<Manufacturer> getAllManufacturer(){
        return manufacturerDao.getAllManufacturer(null);
    }
    
    public Manufacturer getManufacturer(int id){
        return manufacturerDao.read(id);
    }
    
    public void saveManufacturer(Manufacturer manufacturer){
        manufacturerDao.save(manufacturer);
    }
    
    public void updateManufacturer(Manufacturer manufacturer){
        manufacturerDao.update(manufacturer);
    }
    
    public List<Model> getAllModel(){
        return modelDao.getAllModel(null);
    }
    
    public Model getModel(int id){
        return modelDao.read(id);
    }
    
    public void saveModel(Model model){
        modelDao.save(model);
    }
    
    public void updateModel(Model model){
        modelDao.update(model);
    }
    
    public List<Unit> getAllUnit(){
        return unitDao.getAllUnit(null);
    }
    
    public Unit getUnit(int id){
        return unitDao.read(id);
    }
    
    public void saveUnit(Unit unit){
        unitDao.save(unit);
    }
    
    public void updateUnit(Unit unit){
        unitDao.update(unit);
    }
    
}
