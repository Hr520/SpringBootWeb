package com.ssm.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 *
 * 获取服务器的真实IP
 *
 *
 */
public class GetIp {
    public static String getIpInfo() {
        String IpAdrr="";
        Enumeration<NetworkInterface> allNetInterfaces;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isVirtual() || netInterface.getDisplayName().contains("VirtualBox")
                        || netInterface.getDisplayName().contains("VMnet1") || netInterface.getDisplayName().contains("VMnet8")) {
                    continue;
                }
                for (InterfaceAddress ifAddr : netInterface.getInterfaceAddresses()) {
                    InetAddress ip = ifAddr.getAddress();
                    if (ip != null && (ip instanceof Inet4Address)
                            && !ip.isLoopbackAddress() && !ip.isLinkLocalAddress()
                            && !ip.isAnyLocalAddress() && !ip.isMulticastAddress()) {
                     IpAdrr=ifAddr.getAddress().getHostAddress();
                    }
                }
            }
            return IpAdrr;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        String str=getIpInfo();
        System.out.println(str);
    }

}
