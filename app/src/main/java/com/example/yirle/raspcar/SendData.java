package com.example.yirle.raspcar;

import android.os.AsyncTask;
import android.util.Log;

public class SendData extends AsyncTask<String, Void, Boolean> {
    private static final String TAG = "SendData";
    private String ip;

    @Override
    protected Boolean doInBackground(String... strings) {
        boolean status;

        UDPClient client = new UDPClient(4444, ip);
        status = client.sendMessage(strings[0]);
        return status;
    }


    public SendData(String ip) {
        this.ip = ip;
    }

}
