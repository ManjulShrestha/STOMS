/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.commons;
 
import java.lang.reflect.Field;
import java.util.Comparator;
import org.primefaces.model.SortOrder;
 
public class GenericLazySorter<T> implements Comparator<T> {
 
    private String sortField;
     
    private SortOrder sortOrder;
    
    private Class forClass;
    public GenericLazySorter(String sortField, SortOrder sortOrder,Class _forClass) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
        forClass = _forClass;
    }
 
    @Override
    public int compare(T objectA, T objectB) {
        try {
            Field f;
            try{
                f = forClass.getDeclaredField(this.sortField);
            }catch(Exception e){
                f = forClass.getSuperclass().getDeclaredField(this.sortField);
            }
            
            f.setAccessible(true);
            Object value1 = f.get(objectA);
            Object value2 = f.get(objectB);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}