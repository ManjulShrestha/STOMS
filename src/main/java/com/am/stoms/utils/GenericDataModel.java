/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.am.stoms.utils;

import com.am.stoms.commons.GenericLazySorter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author manjul
 * @param <T>
 */
public class GenericDataModel<T> extends LazyDataModel<T> {
    
    private List<T> dataSource;
    private Class forClass;
    
    public GenericDataModel (List<T> dataSource, Class type){
        this.dataSource=dataSource;
        forClass = type;
    }
    
    @Override
    public T getRowData(String rowKey){
        try{
            for(T data:dataSource){
                Field f = forClass.getSuperclass().getDeclaredField("id");
                f.setAccessible(true);
                if(f.get(data).equals(Integer.parseInt(rowKey)))
                    return data;
            }
        } catch(Exception e ){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Object getRowKey(T data) {
        try {
            Field f = forClass.getSuperclass().getDeclaredField("id");
            f.setAccessible(true);
            return f.get(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return null;
    }
    
    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<T> data = new ArrayList<>();
        
        //filter
        for(T resource : dataSource) {
            boolean match = true;
            
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        Field f;
                        try{
                            f= forClass.getDeclaredField(filterProperty);
                        } catch(Exception e){
                            f = forClass.getSuperclass().getDeclaredField(filterProperty);
                        }
                        
                        f.setAccessible(true);
                        
                        String fieldValue = String.valueOf(f.get(resource));
                        
                        if(filterValue == null || fieldValue.toLowerCase().startsWith(filterValue.toString().toLowerCase())) {
                            match = true;
                        }
                        else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
            
            if(match) {
                data.add(resource);
            }
        }
        //sort
        if(sortField != null) {
            Collections.sort(data, new GenericLazySorter<T>(sortField, sortOrder,forClass));
        }
        
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
        
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}
