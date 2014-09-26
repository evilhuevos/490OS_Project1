/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author MohammadA
 */
public class Container<K,U,V extends Searchable<U> > {
    
    private Map<K,V> objects;
    
    public Container(){
        objects=new HashMap<K,V>();
    }
    
    public void addElement(K key, V searchable){
        try{
        objects.put(key, searchable);
        }
        catch(Exception e){
            System.out.println("Problem with adding the element"+e.getMessage());
        }
    }
    
    public void removeElement(K key){
        if(objects.containsKey(key))
            objects.remove(key);
    }
    
    public V find(K key) throws Exception{
        if(objects.containsKey(key))
            return objects.get(key);
        else
            throw new Exception("Item couldn't be found");
    }
    
    public Collection<V> contains(U key){
        
        /*Collection<V> list= objects.values().stream()
                                               .filter(item->item.contains(key))
                                               .collect(Collectors.toList());
        return list;*/
        
        Collection<V> list=new LinkedList<V>();
        for(V item: objects.values()){
            if(item.contains(key))
                list.add(item);
        }
        return list;
    }
    
    public Collection<V> startsWith(U key){
        
        Collection<V> list= objects.values().stream()
                                               .filter(item->item.startsWith(key))
                                               .collect(Collectors.toList());
        return list;
    }

}