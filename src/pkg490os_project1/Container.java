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
 * @param <K>
 * @param <U>
 * @param <V>
 */
public class Container<K,V extends Searchable<K> > {
    
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
    
    public boolean exists (K key){
        return objects.containsKey(key);
    }
    
    public V find(K key) throws Exception{
        if(objects.containsKey(key))
            return objects.get(key);
        else
            throw new Exception("Item couldn't be found");
    }
    
    public Collection<V> contains(K key){
        
        Collection<V> list  = objects.values().stream()
                                                  .filter(item->item.contains(key))
                                                  .collect(Collectors.toList());
        return list;
        
//        Collection<V> list=new LinkedList<V>();
//        for(V item: objects.values()){
//            if(item.contains(key))
//                list.add(item);
//        }
//        return list;
    }
    
//    public Collection<V> startsWith(U key){
//        
//        Collection<V> list= objects.values().stream()
//                                               .filter(item->item.startsWith(key))
//                                               .collect(Collectors.toList());
//        return list;
//    }

//    public void addCustomer(String string, String name, String telephone, String address) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
