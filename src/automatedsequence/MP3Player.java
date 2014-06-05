package automatedsequence;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Purpose: MP3 Player Class
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class MP3Player {

    private FileInputStream FIS;
    private BufferedInputStream BIS;
    public Player player;

    /**
     * Method starts the song
     *
     * @param path path of the song
     */
    public void Play(String path) {
        if (player == null) { // if there is no player
            try {
                FIS = new FileInputStream(path); // assigns path to the file input stream 
                BIS = new BufferedInputStream(FIS); // assigns the file input stream to the buffered input stream

                player = new Player(BIS);
            } catch (JavaLayerException | FileNotFoundException ex) {
                System.out.println(ex);
            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play(); // play
                    } catch (JavaLayerException ex) {
                        System.out.println(ex);
                    }
                }
            }.start();
        }
    }

    /**
     * Method stops the song
     */
    public void Stop() {
        if (player != null) { // if there is something playing
            player.close(); // stop
            player = null; // set it to null
        }
    }
}
