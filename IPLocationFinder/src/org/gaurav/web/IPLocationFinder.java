package org.gaurav.web;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length!=1)
		{
			System.out.println("You need an IP address");
		}
		else
		{
			String IP=args[0];
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap obj=ipService.getGeoIPServiceSoap();
			GeoIP geoIp=obj.getGeoIP(IP);
			System.out.println("Country : " + geoIp.getCountryName());
			
		}
	}

}
