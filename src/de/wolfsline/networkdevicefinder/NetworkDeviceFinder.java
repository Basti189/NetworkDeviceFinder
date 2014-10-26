/**
 * 
 */
package de.wolfsline.networkdevicefinder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

/**
 * @author Sebastian
 *
 */

public class NetworkDeviceFinder {

	public final static String subnet = "192.168.178";
	public final static String fhemURL = "";

	private static List<String> networkDevices = new ArrayList<String>();
	private static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {
		//map.put(subnet + "xx", "NAME");
		Timer timer = new Timer();
		timer.schedule(new NetworkDeviceFinderTimerTask(), 1000, 5000);
	}

	/**
	 * 
	 * @param ip
	 * @param state
	 */
	public synchronized static void setNetworkState(String ip, boolean state) {
		if (state == false) {
			networkDevices.remove(ip);
		} else {
			networkDevices.add(ip);
			System.out.println(ip + "->" + state);
		}
		String name = map.get(ip);
		if (name != null && (!name.equalsIgnoreCase(""))) {
			setFHEMState(name, state);
		}
	}

	/**
	 * 
	 * @param name
	 * @param state
	 */
	private static void setFHEMState(String name, boolean state) {
		try {
			new URL(fhemURL + "?cmd=set%20" + name + "%20"
					+ translateState(state)).openStream().close();
		} catch (MalformedURLException e) {
			System.err.println("Fehler beim Aufruf der URL");
		} catch (IOException e) {
			System.err.println("Fehler beim Aufruf der URL");
		}
	}

	private static String translateState(boolean state) {
		if (state) {
			return "Anwesend";
		}
		return "Abwesend";
	}
}
