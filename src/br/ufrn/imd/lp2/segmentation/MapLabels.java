/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.segmentation;

import br.ufrn.imd.lp2.annotation.Annotation;
import br.ufrn.imd.lp2.imagem.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author edilvolima
 */
public class MapLabels extends Image implements Tagging{
    
    private HashMap<Integer, Annotation> labels;
    
    public MapLabels(){
        super();
    }


    @Override
    public void setImageMapped(BufferedImage imageMapped) {
        super.setImage(imageMapped);
    }

    public HashMap<Integer, Annotation> getLabels() {
        return labels;
    }

    public void setLabels(HashMap<Integer, Annotation> labels) {
        this.labels = labels;
    }
    
    
}
