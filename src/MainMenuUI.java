import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;



public class MainMenuUI {
	
	DesktopRemoteControllerRunnable remoteControllerRunnable;
	 Thread remoteControlCommandsSenderThread;
	 
	public MainMenuUI() {
		remoteControllerRunnable = new DesktopRemoteControllerRunnable();
	}

	
	 
	



	public  void initiateProceedings() {
		 
		OrionSwingJoystick joystick= new OrionSwingJoystick();
        joystick.setVisible(true);
        joystick.myJoystick.setOnSwingJostickMovedListener(_listener);
        //remoteControllerRunnable.setxSpeed(255);
		try {
			remoteControllerRunnable.setServersAddress(InetAddress.getByName("192.168.1.220"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		remoteControlCommandsSenderThread= new Thread(remoteControllerRunnable);
		remoteControlCommandsSenderThread.start();
    }


//SwingUtilities.invokeLater(gui);
	       /* Runnable gui = new Runnable() {
	            @Override
	            public void run() {
	            	
	            	
	            }*/
		
		
	
	private SwingJoystickMovedListener _listener = new SwingJoystickMovedListener() {
		
		@Override
		public void OnReturnedToCenter() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void OnReleased() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void OnMoved(int pan, int tilt) {
			remoteControllerRunnable.setxSpeed(tilt);
			remoteControllerRunnable.setySpeed(pan);
			
		}
	};

}
