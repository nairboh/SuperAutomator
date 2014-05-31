package automatedsequence;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author brianho
 */
public class MainClass {

    FileInputStream FIS;
    BufferedInputStream BIS;

    public Player player;

    public void Stop() {
        if (player != null) {
            player.close();
        }
    }

    public void Play(String path) {
        if (player == null) {
            try {
                FIS = new FileInputStream(path);
                BIS = new BufferedInputStream(FIS);

                player = new Player(BIS);
            } catch (JavaLayerException | FileNotFoundException ex) {
                System.out.println(ex);
            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException ex) {
                        System.out.println(ex);
                    }
                }
            }.start();
        }
    }

    public boolean isComplete() {
        return player.isComplete();
    }

    public int getPosition() {
        return player.getPosition();
    }
}
