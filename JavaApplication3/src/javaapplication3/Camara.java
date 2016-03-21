/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Luis
 */




public class Camara {
    
    static Runtime rt = Runtime.getRuntime();
    static int increment;
    public static String fileName;
    FastRGB convertidor;
    int[][] result;
            
    public Camara(){
        
        result=null;
    }
    
    
    public void Tomar()
    {
       try {   
            System.out.println("tomando foto");
                    fileName = "/var/www/imagen" +  (increment++) + ".jpg";
                    Process p = rt.exec("raspistill -t 8000 -o " + fileName);
                    p.waitFor();
                    Analizar();
          } catch (Exception e) {
                        System.out.println("Exception:" + e.getMessage());
                        
          }            
    }
    
    public void Analizar()
    {
        
    BufferedImage hugeImage;
        try {
            hugeImage = ImageIO.read(new File(fileName));
            convertidor= new FastRGB(hugeImage);
            System.out.println("");
            int[][] result=null;
            System.out.println("Testing convertTo2DWithoutUsingGetRGB:");

            result = convertTo2DUsingGetRGB(hugeImage);
            System.out.println(result.length+", "+result[0].length);
            
            
            
            int regionder = convertidor.getWidth()/3;
            int regioncent=convertidor.getWidth()/2;
            
            
            for (int i = 0; i < regionder; i++) {
                for (int j = 0; j < convertidor.getHeight(); j++) {
                    
                    
                }
            }
            
            
           
            
        } catch (IOException ex) {
            Logger.getLogger(Camara.class.getName()).log(Level.SEVERE, null, ex);
        }
      /*
      System.out.println("Testing convertTo2DUsingGetRGB:");
      for (int i = 0; i < 10; i++) {
         long startTime = System.nanoTime();
         int[][] result = convertTo2DUsingGetRGB(hugeImage);
         long endTime = System.nanoTime();
         System.out.println(String.format("%-2d: %s", (i + 1), toString(endTime - startTime)));
      }*/
      
    
    }
    
   private  int[][] convertTo2DUsingGetRGB(BufferedImage image) {
      int width = image.getWidth();
      int height = image.getHeight();
      
      
            
      int[][] result = new int[width][height];
      
      for (int col = 0; col < width; col++) {
            
          for (int row = 0; row < height; row++) {
            result[col][row] = convertidor.getRGB(col,row);
         }
      }
      return result;
   }
   
   

}
