/**
 * 
 */
package de.wolfsline.networkdevicefinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
/**
 * @author Sebastian
 *
 */


public class NetworkDeviceFinder {
	
	public final static String subnet = "192.168.178";

	private static List<String> networkDevices = new ArrayList<String>();
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new NetworkDeviceFinderTimerTask(), 1000, 5000);
	}
	
	/**
	 * 
	 * @param ip
	 * @param state
	 */
	public synchronized static void setNetworkState(String ip, boolean state){
		if(state == false){
			networkDevices.remove(ip);
		}
		else{
			networkDevices.add(ip);
		}
		System.out.println(ip + "->" + state);	
	}
}
