
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;     

public interface SongInterface
{   
    public void createList();
    public ArrayList<Song> displayList();
    public boolean addSong(Song song);
    public Song removeSong(int position);
    public String Save();
    public String Load() throws IOException;
    public void Exit();
   
}