package com.dosse.upnp;

import java.net.NetworkInterface;

public class IFaceParser {
	private final boolean isLoopback;
	private final boolean isUp;
	private final boolean isVirtual;
	private final boolean isPointToPoint;

	public IFaceParser(NetworkInterface ni) {
		if (ni.getName().startsWith("lo") || ni.getDisplayName().toLowerCase().contains("loopback")) {
			isLoopback = true;
		}
		else {
			isLoopback = false;
		}

		if (ni.getInetAddresses().hasMoreElements()) {
			isUp = true;
		}
		else {
			isUp = false;
		}
		if (ni.getName().matches("vmnet\\d+|vboxnet\\d+|tun\\d+|tap\\d+")) {
			isVirtual = true;
		}
		else {
			isVirtual = false;
		}

		if (ni.getName().startsWith("ppp") || ni.getName().startsWith("tun")) {
			isPointToPoint = true;
		}
		else {
			isPointToPoint = false;
		}
	}

	public boolean isVirtual() {
		return isVirtual;
	}
	
	public boolean isPointToPoint() {
		return isPointToPoint;
	}
	
	public boolean isUp() {
		return isUp;
	}
	
	public boolean isLoopback() {
		return isLoopback;
	}
}
