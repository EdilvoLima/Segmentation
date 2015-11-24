/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.annotation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author edilvolima
 */
public class Annotation {

    private Integer regionSelected;
    private String tag;
    private ArrayList<Integer> regions;

    private int[] mask;

    public Annotation() {
        regionSelected = null;
        tag = "";
        regions = new ArrayList<>();
    }

    //Retorna qual regions 
    public Integer getRegionLabel(int c, int scale) {
        Color color = new Color(c);
        return color.getRed()/scale;
        
    }

    /**
     * Cria uma mascara para highlight na imagem
     *
     * @param serial
     * @return
     */
    public int[] createMask(int[] serial) {
        int[] mask = new int[serial.length];
        for (int i = 0; i < serial.length; i++) {
            mask[i] = serial[i];
        }
        return mask;
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

    public ArrayList<Integer> getRegions() {
        return regions;
    }

    /**
     * Adiciona uma regiao, que deve ficar em evidencia em multi selecao
     *
     * @param region
     */
    public void addRegion(int region) {
        if (!isSelectedRegion(region)) {
            regions.add(region);
        }
    }

    /**
     * Reseta lista de regioes selecionadas
     */
    public void clearRegions() {
        regions = new ArrayList<>();
    }

    /**
     * Verificas se regiao ja foi selecionada
     *
     * @param key
     * @return
     */
    public boolean isSelectedRegion(int key) {
        boolean resp = false;
        for (Integer i : regions) {
            if (i == key) {
                resp = true;
            }
        }
        return resp;
    }

    /**
     * Imprime regions selecionadas
     */
    public void printRegions() {
        System.out.print("{");
        for (Integer region : regions) {
            System.out.print(region +", ");
        }
        System.out.println("}");
    }

    /**
     * Aplica highlight em regiao selecionada
     *
     * @param regionSelected
     */
    public void highlightRegion(int regionSelected) {

    }
}
