/**
 * 
 */
package de.wolfsline.networkdevicefindern;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Sebastian
 *
 */
public class NetworkDeviceFinderTask extends Thread {

	private String IP;

	/**
	 * 
	 * @param ip
	 */
	public NetworkDeviceFinderTask(String ip) {
		this.IP = ip;
		this.start();
	}

	@Override
	public void run() {
		try {
			InetAddress adr = InetAddress.getByName(IP);
			if (adr.isReachable(3000)) {
				NetworkDeviceFinder.setNetworkState(IP, true);
				return;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NetworkDeviceFinder.setNetworkState(IP, false);
	}
}