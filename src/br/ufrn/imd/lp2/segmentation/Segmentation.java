/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.segmentation;

import br.ufrn.imd.lp2.imagem.Images;
import br.ufrn.imd.lp2.imagesegmentation.ImageInformation;
import br.ufrn.imd.lp2.imagesegmentation.ImageSegmentation;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author edilvolima
 */
public class Segmentation extends Images implements Serializable {

    private ImageInformation RAW;
    private MapRegion mapRegion;
    private int scaleSegmentation;

    /**
     * Construtor: Inicializa e segmenta a imagem pelo @param filepath
     *
     * @param filepath
     * @param blur_level
     * @param color_radius
     * @param min_size
     */
    public Segmentation(String filepath, double blur_level, double color_radius, double min_size) {
        super.setFilepath(filepath);
        mapRegion = new MapRegion();

        RAW = ImageSegmentation.performSegmentation(filepath, blur_level, color_radius, min_size);
        scaleSegmentation = 255 / RAW.getTotalRegions();

        mapRegion.setImageMapped(RAW.getOriginalImage());
        mapRegion.getImage().setRGB(0, 0, RAW.getWidth(), RAW.getHeight(), grayMap(RAW.getSegmentedImageMap()), 0, RAW.getWidth());
    }

    /**
     * Converte a matriz da imagem segmentada para melhor visualizacao de acordo
     * com o numero de regions geradas
     *
     * @param mtz
     * @return
     */
    public int[] grayMap(int[] mtz) {
        for (int i = 0; i < mtz.length; i++) {
            int pix = mtz[i];

            Color c = new Color(scaleSegmentation * pix, scaleSegmentation * pix, scaleSegmentation * pix);

            mtz[i] = c.getRGB();
        }
        return mtz;
    }

    /**
     * Retorna o ImageInformation que possui todos os dados oriundos da
     * segmentacao
     *
     * @return
     */
    public ImageInformation getRAW() {
        return RAW;
    }

    public void setRAW(ImageInformation RAW) {
        this.RAW = RAW;
    }

    public BufferedImage getOriginalImage() {
        return RAW.getOriginalImage();
    }

    public BufferedImage getMarkedImage() {
        return RAW.getRegionMarkedImage();
    }

    public int getScaleSegmentarion() {
        return scaleSegmentation;
    }

    public void setScaleSegmentarion(int scaleSegmentarion) {
        this.scaleSegmentation = scaleSegmentarion;
    }

    public MapRegion getMapLabels() {
        return mapRegion;
    }

    public void setMapLabels(MapRegion mapLabels) {
        this.mapRegion = mapLabels;
    }

}
