package AdventureTime;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

    private Clip clip;

    public void setFile(URL name)
    {
//        AudioInputStream sound = AudioSystem.getAudioInputStream(name);
//        clip = AudioSystem.getClip();
//        clip.open(sound);
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
//		fc.setValue(volume);
        clip.setFramePosition(0);
        clip.start();
    }
    public void loop(URL name)
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(URL name)
    {
        clip.stop();
        clip.close();
    }
}
