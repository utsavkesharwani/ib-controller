package ibcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by dev on 2/17/16.
 */
public class RestartTask implements Runnable{
    @Override
    public void run() {
        stopMainWindow();
        IBController.startTwsOrGateway();
    }

    private void stopMainWindow(){
        JFrame jf = TwsListener.getMainWindow();

        WindowEvent wev = new WindowEvent(jf, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }
}
