package com.example.stephen.housecall.models;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPSServerSocketFactory;

import java.io.PrintWriter;

/**
 * Created by Yi on 7/12/2016.
 */
public class RunTimeFTP {

    public void run() {
        int port1 = 0, port2 = 0;
        FTPSServerSocketFactory ftp1, ftp2;
        ProtocolCommandListener listener;
        listener = new PrintCommandListener(new PrintWriter(System.out), true);
       // ftp1 = new FTPSServerSocketFactory();
       // ftp1.addProtocolCommandListener(listener);



    }




}
