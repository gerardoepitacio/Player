
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 *
 *
 * 31/05/2014,01:49:01 PM
 *
 * @author Juan Gerardo Epitacio Galvez
 */
public class Listener implements LineListener {

    Principal principal;
    
    public Listener(Principal p) {
        principal = p;
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.OPEN) {
            System.out.println("OPEN");
        } else if (type == LineEvent.Type.CLOSE) {

        } else if (type == LineEvent.Type.START) {
            System.out.println("START");
            
            principal.setStateBar(principal.getActualPlay());
            
        } else if (type == LineEvent.Type.STOP) {
            //System.out.println(principal.clips.get(0).getFramePosition() + ":::::" + principal.clips.get(0).getFrameLength());
            if (principal.clips.get(0).getFramePosition() == principal.clips.get(0).getFrameLength()) {
                System.out.println("segundos:" + principal.clips.get(0).getMicrosecondPosition());
                try {
                    principal.ff();
                } catch (IOException ex) {
                    Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            System.out.println("STOP");

        }

    }

}
