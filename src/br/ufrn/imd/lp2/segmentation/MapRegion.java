/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.segmentation;

import br.ufrn.imd.lp2.annotation.Annotation;
import br.ufrn.imd.lp2.annotation.Tag;
import br.ufrn.imd.lp2.imagem.Images;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author edilvolima
 */
public class MapRegion extends Images implements Tagging, Serializable{
    
    private HashMap<Integer, String> labels;
    
    public MapRegion(){
        super();
        labels = new HashMap<>();
    }

    @Override
    public void setImageMapped(BufferedImage imageMapped) {
        super.setImage(imageMapped);
    }

    public String getLabels(Integer key) {
        return labels.get(key);
    }

    public void setLabels(Integer key, String tag) {
        labels.put(key, tag);
    }
    
    public void setLabels(ArrayList<Integer> regions, String tag){
        for(Integer key : regions){
            labels.put(key, tag);
        }
    }
    
}
