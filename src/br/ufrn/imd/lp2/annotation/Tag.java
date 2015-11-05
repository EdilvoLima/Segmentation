/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.annotation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author edilvolima
 */
public class Tag {
    private ArrayList<String> tags;
    
    public Tag(){
        tags = new ArrayList<>();
    }
    
    public void addTag(String[] tags){
        this.tags.addAll(Arrays.asList(tags));
    }
    
    public void addTag(String tag){
        this.tags.add(tag);
    }
    
}
