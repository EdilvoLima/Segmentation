/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.segmentation;

import br.ufrn.imd.lp2.imagem.Image;
import br.ufrn.imd.lp2.imagesegmentation.ImageInformation;
import br.ufrn.imd.lp2.imagesegmentation.ImageSegmentation;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author edilvolima
 */
public class Segmentation {

    private ImageInformation ImageRAW;
    private BufferedImage originalImage;
    private BufferedImage markedImage;
    private String filepath;
    private MapLabels mapLabels;
    private int scaleSegmentarion;

    public Segmentation(Image image) {
        this.originalImage = image.getImage();
        this.filepath = image.getFilepath();
        mapLabels = new MapLabels();
    }

    public Segmentation() {

    }

    public void applySegmental(double blur_level, double color_radius, double min_size) {
        ImageRAW = ImageSegmentation.performSegmentation(filepath, blur_level, color_radius, min_size);
        originalImage = ImageRAW.getOriginalImage();
        markedImage = ImageRAW.getRegionMarkedImage();
        scaleSegmentarion = 255 / ImageRAW.getTotalRegions();

        mapLabels.setImageMapped(originalImage);
        mapLabels.getImage().setRGB(0, 0, ImageRAW.getWidth(), ImageRAW.getHeight(), grayMap(ImageRAW.getSegmentedImageMap()), 0, ImageRAW.getWidth());
    }
    
    
    public int[] grayMap(int[] mtz) {
        for (int i = 0; i < mtz.length; i++) {
            int pix = mtz[i];

            Color c = new Color(scaleSegmentarion * pix, scaleSegmentarion * pix, scaleSegmentarion * pix);

            mtz[i] = c.getRGB();
        }
        return mtz;
    }

    public ImageInformation getImageRAW() {
        return ImageRAW;
    }

    public void setImageRAW(ImageInformation ImageRAW) {
        this.ImageRAW = ImageRAW;
    }

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BufferedImage getMarkedImage() {
        return markedImage;
    }

    public void setMarkedImage(BufferedImage markedImage) {
        this.markedImage = markedImage;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }


    public int getScaleSegmentarion() {
        return scaleSegmentarion;
    }

    public void setScaleSegmentarion(int scaleSegmentarion) {
        this.scaleSegmentarion = scaleSegmentarion;
    }

    public MapLabels getMapLabels() {
        return mapLabels;
    }

    public void setMapLabels(MapLabels mapLabels) {
        this.mapLabels = mapLabels;
    }
    
    
}
