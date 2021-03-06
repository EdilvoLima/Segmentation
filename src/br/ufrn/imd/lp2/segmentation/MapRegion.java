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
import java.util.TreeMap;

/**
 * Mapa de regioes onde guarda os rotulos de cada regiao
 *
 * @author edilvolima
 */
public class MapRegion extends Images implements Tagging, Serializable {

    private TreeMap<Integer, String> labels;

    public MapRegion() {
        super();
        labels = new TreeMap<>();
    }

    @Override
    public void setImageMapped(BufferedImage imageMapped) {
        super.setImage(imageMapped);
    }

    public String getLabels(Integer key) {
        return labels.get(key);
    }

    /**
     * Insere uma tag (label) a uma regiao
     *
     * @param key
     * @param tag
     */
    public void setLabels(Integer key, String tag) {
        labels.put(key, tag);
    }

    /**
     * Insere multiplas regioes na estrutura
     *
     * @param regions
     * @param tag
     */
    public void setLabels(ArrayList<Integer> regions, String tag) {
        for (Integer key : regions) {
            labels.put(key, tag);
        }
    }

}
