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
public class Annotation {
    
    private Integer regionSelected;
    private String tag;
    
    public Annotation (){
        regionSelected = null;
        tag = "";
    }

    public Integer getRegionSelected() {
        return regionSelected;
    }

    public void setRegionSelected(int regionSelected) {
        this.regionSelected = regionSelected;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    
}
