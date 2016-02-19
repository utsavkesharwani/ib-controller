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
        try{
            Thread.sleep(30000);

        }catch (Exception e){

        }
        Utils.logToConsole("start new gateway");
//        IBController.startTwsOrGateway();
        MyCachedThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                if (IBController.isGateway()){
                    IBController.startGateway();
                } else {
                    IBController.startTws();
                }
            }
        });
        
    }

    private void stopMainWindow(){
        JFrame jf = TwsListener.getMainWindow();

        WindowEvent wev = new WindowEvent(jf, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }
}
