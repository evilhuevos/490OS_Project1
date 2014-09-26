/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

/**
 *
 * @author MohammadA
 */
public interface Searchable<K> {
    
    public boolean startsWith(K key);
    
    public boolean contains(K key);
    
    public String[] to_array();
}
