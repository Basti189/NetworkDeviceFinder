/**
 * 
 */
package de.wolfsline.networkdevicefindern;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sebastian
 *
 */


public class NetworkDeviceFinder {
	
	private final static String subnet = "192.168.178";

	private static List<String> networkDevices = new ArrayList<String>();
	
	public static void main(String[] args) {
		for(int i = 1 ; i <= 60 ; i++){
			new NetworkDeviceFinderTask(subnet + "." + i);
		}
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
