/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.annotation;

import java.awt.Color;

/**
 *
 * @author edilvolima
 */
public class Filter {
    
    private Color pixel;
    private int r,g,b;
    
    public int filter(int param) {
        
        r = pixel.getRed() * param / 100;
        g = pixel.getGreen() * param / 100;
        b = pixel.getBlue() * param / 100;
        pixel = new Color(r, g, b);

        return pixel.getRGB();
    }

}
