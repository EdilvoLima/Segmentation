/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.gui;

import br.ufrn.imd.lp2.segmentation.Segmentation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author edilvolima
 */
public class Persistence {

    //Gera o arquivo para armazenar o objeto
    private FileOutputStream fileWrite;
    private ObjectOutputStream objWrite;
    private Segmentation segmentation;

    private FileInputStream fileRead;
    private ObjectInputStream objRead;
    
    private final String PATH_APP = System.getProperty("user.dir");
    

    public Persistence(Segmentation seg) {
        this.segmentation = seg;
        System.out.println(PATH_APP);
    }

    public void save() {
        try {
            fileWrite = new FileOutputStream(PATH_APP+"/data/base.dat");

            //Classe responsavel por inserir os objetos
            ObjectOutputStream objWrite = new ObjectOutputStream(fileWrite);

            //Grava o objeto cliente no arquivo
            objWrite.writeObject(segmentation);
            objWrite.flush();
            objWrite.close();

            fileWrite.flush();

            fileWrite.close();

            System.out.println("Objeto gravado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void read() {
        System.out.println("Recuperando objeto: ");

        try {

            //Carrega o arquivo
            fileRead = new FileInputStream(PATH_APP+"/data/base.dat");

            //Classe responsavel por recuperar os objetos do arquivo
            objRead = new ObjectInputStream(fileRead);

            System.out.println(objRead.readObject());

            objRead.close();

            fileRead.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
