package com.sauzny.jkitchen_note.ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class PingUtils {

	public static long ping(String ip){

        long a = System.currentTimeMillis();

        boolean isping = false;
        try {
            isping = InetAddress.getByName(ip).isReachable(1000);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        long b = System.currentTimeMillis();
        
        if(isping){
            return b-a;
        }else{
            return -1;
        }
    }
}
