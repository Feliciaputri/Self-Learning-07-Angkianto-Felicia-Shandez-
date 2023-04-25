package AdventureTime;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SE {

    private Clip clip;

    public void setFile(URL name)
    {
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch(Exception e)
        {

        }
    }

    public void play(URL name)
    {
        clip.setFramePosition(0);
        clip.start();
    }

}
