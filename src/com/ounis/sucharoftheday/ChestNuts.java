/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ounis.sucharoftheday;

import com.ounis.utils.Strings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author AndroidDev
 */
public class ChestNuts {
//    C:\Users\AndroidDev\IdeaProjects\SucharOfTheDay\chestnutsutf8.txt 
    public static final String FILE_CHEST_NUTS = "/home/ounis/chestnuts.txt";//"chestnuts.txt";//"C:\\Users\\AndroidDev\\IdeaProjects\\SucharOfTheDay\\chestnutsutf8.txt";
    
    private String filename;
    
    private List<String> chestNutsList;
    
    private int lastDrawChestNutNum = -1;
    public int getLastDrawChestNutNum() {
        return this.lastDrawChestNutNum;
    }
    
    private int clearChestNutsList() {
        int result = 0;
        
        while (this.chestNutsList.size() > 0) {
            this.chestNutsList.remove(0);
            result++;
        }
        
                
        return result;
    }
    
    ChestNuts(String aFileName) {
//        wczytywanie listy sucharów z pliku
//        System.out.println(FILE_CHEST_NUTS);
        
        chestNutsList = new ArrayList<String>();
        this.filename = aFileName;
        try {
            BufferedReader textFile = new BufferedReader(
                          new InputStreamReader(new FileInputStream(this.filename)));
            String line;
            
            for (;true;) {
                
                line = textFile.readLine();
                if (line != null) {
                    if (!line.startsWith("#")) {
//                        tutaj wydruk kodów ascii
//                        System.out.println(line);
//                        for (char c: line.toCharArray()) {
//                            System.out.printf("%d ",Strings.ord(c));
//                        }
//                        System.out.println();
                        chestNutsList.add(line);
                    }
                }
                else
                    break;
            }
            
//            alternatywny sposób wczytywania danych z pliku tekstowego
//            while ((line = textFile.readLine()) != null) {
//                if (!line.startsWith("#")) 
//                    chestNutsList.add(line);
//            }
//            System.out.println(chestNutsList.size());
            textFile.close();
        }
        catch (Exception e) {
//            throw new Exception(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null,String.format("Błąd wczytywania pliku: %s", FILE_CHEST_NUTS));
//            System.err.println(String.format("Błąd wczytywania pliku: %s", FILE_CHEST_NUTS));
        }
    }
    
    private String genChestNut() {
//        losowanie suchara
        String result = "";
        if (!chestNutsList.isEmpty()) {
            this.lastDrawChestNutNum = new Random().nextInt(chestNutsList.size()-1);
             
            result = chestNutsList.get(this.lastDrawChestNutNum);
//            System.out.println(rnd);
        }
        return result;
    }

    
    @Override
    public String toString() {
        return genChestNut();
    }

}
