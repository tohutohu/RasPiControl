package com.trap.simplicity.raspicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button push = (Button)findViewById(R.id.button);
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("tohu","push!!");
                        try {
                            URL url= new URL("http://192.168.2.112:4649/start-or-stop");
                            HttpURLConnection con = (HttpURLConnection)url.openConnection();
                            con.connect();
                            Log.d("tohu",""+ con.getResponseCode());
                        }catch (Exception e){
                            Log.d("tohu",e.toString());
                        }
                    }
                }).start();
            }
        });
    }
}
