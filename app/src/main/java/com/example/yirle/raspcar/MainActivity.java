package com.example.yirle.raspcar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button[] allButtons;
    private EditText txtInput;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void initButtons(){
        txtInput = findViewById(R.id.txtInput);
        allButtons = new Button[6];
        allButtons[0] = findViewById(R.id.btnVorwaerts);
        allButtons[1] = findViewById(R.id.btnLinks);
        allButtons[2] = findViewById(R.id.btnRechts);
        allButtons[3] = findViewById(R.id.btnRueckwaerts);
        allButtons[4] = findViewById(R.id.btnLinksDrehen);
        allButtons[5] = findViewById(R.id.btnRechtsDrehen);

        for(int i = 0; i < allButtons.length; i++){
            allButtons[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        v.setBackgroundColor(Color.GREEN);
                        Button btn = (Button) v;
                        if(btn.getText().toString().equalsIgnoreCase("vorwaerts")){
                            SendData data = new SendData(txtInput.getText().toString());
                            data.execute("vorwaerts");
                            Log.d(TAG, "onTouch: vor"+txtInput.getText(

                            ).toString());
                        }else if(btn.getText().toString().equalsIgnoreCase("links")){
                            SendData data = new SendData(txtInput.getText().toString());
                            data.execute("links");
                            Log.d(TAG, "onTouch: l");
                        }else if(btn.getText().toString().equalsIgnoreCase("rechts")){
                            SendData data = new SendData(txtInput.getText().toString());
                            data.execute("rechts");
                            Log.d(TAG, "onTouch: r");
                        }else if(btn.getText().toString().equalsIgnoreCase("rueckwaerts")){
                            SendData data = new SendData(txtInput.getText().toString());
                            data.execute("rueckwaerts");
                            Log.d(TAG, "onTouch: rü");
                        }else if(btn.getText().toString().equalsIgnoreCase("links-drehen")){
                            SendData data = new SendData(txtInput.getText().toString());
                            data.execute("links-drehen");
                            Log.d(TAG, "onTouch: links dr");
                        }else if(btn.getText().toString().equalsIgnoreCase("rechts-drehen")){
                            SendData data = new SendData(txtInput.getText().toString());
                            data.execute("rechts-drehen");
                            Log.d(TAG, "onTouch: rechts drehen");
                        }
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        v.setBackgroundColor(Color.LTGRAY);
                        SendData data = new SendData(txtInput.getText().toString());
                        data.execute("up");
                    }
                    return true;
                }
            });
        }
    }
}
