package ibcontroller;

import javax.swing.*;
import java.io.FileOutputStream;


/**
 * Created by dev on 2/17/16.
 */
public class RestartTask implements Runnable{
    @Override
    public void run() {
        stopMainWindow();
        System.gc();

        try{
            Thread.sleep(3000);

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

    public void stopMainWindow(){
//        stopLogFileFd();
        JFrame jf = TwsListener.getMainWindow();
//        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
//        long fd = ((UnixOperatingSystemMXBean)os).getOpenFileDescriptorCount();

        jf.dispose();
//        WindowEvent wev = new WindowEvent(jf, WindowEvent.WINDOW_CLOSING);
//        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

        Utils.logToConsole("exit main window");
    }

    public void stopLogFileFd(){
        String logFile = "/home/dev/code/java/ib-controller/ibgateway.Fri.log";
        try{
            FileOutputStream stream = new FileOutputStream(logFile);
            stream.close();
        }catch (Exception e){
            Utils.logToConsole("eeeeeeee:" + e.getMessage());
        }
    }
}
