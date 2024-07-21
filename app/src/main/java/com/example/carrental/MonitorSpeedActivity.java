package com.example.carrental;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MonitorSpeedActivity extends AppCompatActivity {

    // TextViews for displaying current speed
    private TextView currentSpeed;

    // Variable to store the speed limit
    private double speedLimit;

    // Reference to the Firebase database
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_speed);

        // Initialize the UI elements
        currentSpeed = findViewById(R.id.);
        // Get a reference to the "SpeedLimit" node in Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("SpeedLimit");

        // Simulate receiving speed data from an external sensor
        //we can get the data from MCU and use the senseor event to monitoring continuous speed.
        //SENSOR_EVENT.GETSPEED() - get speed from sensor
        sendNotification(SENSOR_EVENT.GETSPEED());  // Example: assume the speed is 50 km/h
    }

    // Method to simulate receiving speed data from a sensor
    private void sendNotification(double speed) {
        // Display the current speed
        currentSpeed.setText("Current Speed: " + speed + " km/h");

        // Check if the current speed exceeds the speed limit
        if (speed > speedLimit) {
            // Display an Toast messege if the speed limit is exceeded
            Toast.makeText(MonitorSpeedActivity.this, "Speed limit exceed to, SLOW DOWN" + speedLimit + " km/h", Toast.LENGTH_SHORT).show();
            // Send a notification to the rental company through Firebase
            sendNotification();
        }
    }

    // Method to send a notification through Firebase
    private void sendNotification() {
        // Create a notification message
        String notificationMessage = "Speed limit exceeded by user!";
        // Push the notification message to Firebase
        databaseReference.push().setValue(notificationMessage);
    }

}
