/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.imagem;

import br.ufrn.imd.lp2.imagesegmentation.ImageInformation;
import br.ufrn.imd.lp2.imagesegmentation.ImageSegmentation;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author edilvolima
 */
public class Image {

    private BufferedImage image;
    private String filepath;

    
    public Image(){
        this.image = null;
        this.filepath = null;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage originalImage) {
        this.image = originalImage;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    
    
}
