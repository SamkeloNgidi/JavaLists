
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class SongList implements SongInterface
{
    private ArrayList<Song> entry;
    private int length;
    private static final int max_size = 50;
    Song vArr[]=new Song[10];
    public int vCount =0;
            
    public int getLength()
    {
        return length;
    }
   	
    public SongList()
    {
        length = 0;
        entry = new ArrayList<Song>();
    }
    
    public void createList()
    {
        entry.add(new Song("Track 1"));
        entry.add(new Song("Track 2"));
        entry.add(new Song("Track 3"));
        entry.add(new Song("Track 4"));
        writeBackup(); 
    }

    public ArrayList<Song> displayList()
    {
        readBackup();
        return entry;
    }

    public boolean addSong(Song song)
    {
        try
        {
            readBackup();
            entry.add(new Song(song.getSName()));
            writeBackup();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
 
    public Song removeSong(int position)
    {
        readBackup();
        Song song =  entry.remove(position);
        writeBackup();
         
        return song;
    }

    public String Save()
    {
        readBackup();
        try {
            File file = new File("Songs.txt");
            file.delete();
            if (!file.exists())
            {
               file.createNewFile();
            }
         
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i <entry.size(); i++)
            {
               //bw.write("Song "+(i+1));
               //bw.write("****************");
               bw.write(/*"Song Name: "+*/entry.get(i).getSName());
               bw.newLine();
            }
            bw.close();
         
            return "Saved successfully";
        } 
         
        catch (IOException e) {
            e.printStackTrace();
               return "failed";
        }  
    }
       
    public String Load()
    {
        try
        {
            FileReader fr =new FileReader("Songs.txt"); 
            BufferedReader textReader = new BufferedReader(fr);
           
            String SName;
            while((SName = textReader.readLine()) != null)
            {
                SName = textReader.readLine();
                entry.add(new Song(SName));
            }
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }   
        return "Data has been loaded";
    }
       
    public void Exit()
    {
        System.exit(0);
    }
      
    public void writeBackup()
    {
        try {         
            File file = new File("backupFile.txt");
            file.delete();
            if (!file.exists())
            {
               file.createNewFile();
            }
         
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
           
            for(int i = 0; i <entry.size(); i++)
            {
               //bw.write("Song "+(i+1));
               //bw.write("****************");
               bw.write(/*"Song Name: "+*/entry.get(i).getSName());
               bw.newLine();   
            }
            bw.close();

        } 
         
        catch (IOException e) {
            e.printStackTrace();
               
        }  
    }
      
    public void readBackup()
    {
        try
        {
            FileReader fr =new FileReader("backupFile.txt"); 
            BufferedReader textReader = new BufferedReader(fr);
            String SName;
            while((SName = textReader.readLine()) != null)
            {              
               SName = textReader.readLine();
               
               String space = textReader.readLine();
               entry.add(new Song(SName ));
            }    
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }   
         
    }
   
}