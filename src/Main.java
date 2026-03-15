import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

    String filePath = "C:\\Users\\bhumi\\OneDrive\\Desktop\\Gta 4.wav";
     File file = new File(filePath);

     try(Scanner sc = new Scanner(System.in);
         AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

         Clip clip = AudioSystem.getClip();
         clip.open(audioStream);
         clip.start();

         String response = "";
         while(!response.equals("Q")){
             System.out.println("P for play");
             System.out.println("S for stop");
             System.out.println("R for reset");
             System.out.println("Q for quit");
             System.out.println("enter choice :");

             response = sc.next().toUpperCase();
             switch(response){
                 case "P" -> clip.start();
                 case "S" -> clip.stop();
                 case "R" -> clip.setMicrosecondPosition(10000000);
                 case "Q" -> clip.close();
             }

         }


     } catch(FileNotFoundException e){
         System.out.println("File Not Found");
     }
     catch(UnsupportedAudioFileException e){
         System.out.println("Audio must be wav, au or aiff");
     } catch (LineUnavailableException e){
         System.out.println("Unable to access audio");
     }
     catch(IOException e){
         System.out.println("Something went wrong");
     } finally{
         System.out.println("Done");
     }
    }
    }