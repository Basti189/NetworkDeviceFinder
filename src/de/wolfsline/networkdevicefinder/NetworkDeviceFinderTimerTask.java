/**
 * 
 */
package de.wolfsline.networkdevicefinder;

import java.util.TimerTask;

/**
 * @author Sebastian
 *
 */
public class NetworkDeviceFinderTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Scanne ...");
		for (int i = 1; i <= 60; i++) {
			new NetworkDeviceFinderThread(NetworkDeviceFinder.subnet + "." + i);
		}
	}
}
