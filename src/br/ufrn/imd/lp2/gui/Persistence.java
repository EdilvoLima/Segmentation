/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.lp2.gui;

import br.ufrn.imd.lp2.segmentation.Segmentation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Classe que executa o processo de leitura e escrita em arquivo, que guarda as
 * imagens segmentadas e anotadas
 *
 * @author edilvolima
 */
public class Persistence {

    private File file;

    //Gera o arquivo para armazenar o objeto
    private FileOutputStream fileWrite;
    private ObjectOutputStream objWrite;
    //private Segmentation segmentation;

    private FileInputStream fileRead;
    private ObjectInputStream objRead;

    //Path de onde fica a aplicacao
    private final String APP_PATH = System.getProperty("user.dir");
    private final String STORAGE_DIR = "/data/";
    private final String EXT = ".dat";

    public Persistence() {
        file = new File(APP_PATH + STORAGE_DIR);
        if (file.exists() != true) {
            file.mkdir();
        }
        System.out.println(APP_PATH);
    }

    public void save(Segmentation segmentation) {
        try {
            fileWrite = new FileOutputStream(APP_PATH + STORAGE_DIR + getName(segmentation.getFileName()) + EXT);

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
        File[] list = file.listFiles();
        try {
            for (int i = 0; i < list.length; i++) {
                //Carrega o arquivo

                fileRead = new FileInputStream(APP_PATH + STORAGE_DIR + getName(list[i].getName()) + EXT);
                //Classe responsavel por recuperar os objetos do arquivo
                objRead = new ObjectInputStream(fileRead);

                //list.add(objRead);
                System.out.println(objRead.readObject());

                objRead.close();

                fileRead.close();
            }
        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public File[] listFiles() {
        return file.listFiles();
    }

    private String getName(String fileName) {
        String name[] = fileName.replaceAll("[\n]", "").split("[.]", -1);
        
        return name[0];
    }

}
