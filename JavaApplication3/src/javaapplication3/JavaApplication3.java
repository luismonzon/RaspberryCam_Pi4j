/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author lmonzon
 */
public class JavaApplication3 {
static FastRGB convertidor;
    /**
     * @param args the command line arguments
     */

/*    public static void main(String[] args) {
        try {
            // TODO code application logic here

            BufferedImage buffer = ImageIO.read(new File("C:\\Users\\lmonzon\\Documents\\cam.jpg"));
            byte[] pixels = ((DataBufferByte) buffer.getRaster().getDataBuffer()).getData();
            int count=0;
            
            for (int i = 0; i < buffer.getWidth(); i++) {
                for (int j = 0; j < buffer.getHeight(); j++) {
                    
                    int clr=  buffer.getRGB(i,j); 
                    int  red   = (clr & 0x00ff0000) >> 16;
                    int  green = (clr & 0x0000ff00) >> 8;
                    int  blue  =  clr & 0x000000ff;
                    System.out.println("Red Color value = "+ red+", "+"Green Color value = "+ green+", "+"Blue Color value = "+ blue);                    
                }
            }
            
            System.out.println("N. Pixeles: "+count);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication3.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
  */
    public static void main(String[] args) throws IOException {

      BufferedImage hugeImage = ImageIO.read(new File("C:\\Users\\lmonzon\\Documents\\cam.jpg"));
      /*
      System.out.println("Testing convertTo2DUsingGetRGB:");
      for (int i = 0; i < 10; i++) {
         long startTime = System.nanoTime();
         int[][] result = convertTo2DUsingGetRGB(hugeImage);
         long endTime = System.nanoTime();
         System.out.println(String.format("%-2d: %s", (i + 1), toString(endTime - startTime)));
      }*/
      convertidor= new FastRGB(hugeImage);
      System.out.println("");
      int[][] result=null;
      System.out.println("Testing convertTo2DWithoutUsingGetRGB:");
     
         result = convertTo2DUsingGetRGB(hugeImage);
      
   
      
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                Color nuevo = new Color(result[i][j]);
                
                System.out.println(nuevo.getBlue()+" "+ nuevo.getGreen()+ " "+nuevo.getRed());
            }
        }
      
   }
    
   private static int[][] convertTo2DUsingGetRGB(BufferedImage image) {
      int width = image.getWidth();
      int height = image.getHeight();
      int[][] result = new int[height][width];

      for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
             
            result[row][col] = convertidor.getRGB(col, row);
           
         }
      }
      return result;
   }

   

}
    
