package com.example.yirle.raspcar;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
    private DatagramSocket socket;
    private DatagramPacket packet;
    private final int port;
    private InetAddress address;

    public boolean sendMessage(String msg) {
        boolean status = true;

        byte[] buff = msg.getBytes();
        try {

            socket = new DatagramSocket();

            packet = new DatagramPacket(buff, buff.length, address, port);
            socket.send(packet);
        } catch (SocketException e) {
            status = false;
            e.printStackTrace();
        } catch (IOException e) {
            status = false;
            e.printStackTrace();
        }

        return status;
    }

    public UDPClient(int port, String ip) {
        try {
            this.address = InetAddress.getByName(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.port = port;
    }
}
