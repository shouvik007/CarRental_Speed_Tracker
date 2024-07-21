package com.example.carrental;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//launcher activity
public class MainActivity extends AppCompatActivity {

    //button for set speedlimit
    private Button btnSetSpeedLimit;
    //button for monitoring speed
    private Button btnMonitorSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetSpeedLimit = findViewById(R.id.btn_set_speed_limit);
        btnMonitorSpeed = findViewById(R.id.btn_monitor_speed);

        btnSetSpeedLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetSpeedLimitActivity.class);
                //start activity setSpeedLimitActivity
                startActivity(intent);
            }
        });

        btnMonitorSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MonitorSpeedActivity.class);
                //start activity MonitorSpeedActivity
                startActivity(intent);
            }
        });
    }
}
