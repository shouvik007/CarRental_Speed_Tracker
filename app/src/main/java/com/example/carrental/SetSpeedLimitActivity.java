package com.example.carrental;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class SetSpeedLimitActivity extends AppCompatActivity {

    // EditText for inputing the speed limit
    private EditText etSpeedLimit;
    private Button btnSetSpeed;     // Button to set the speed limit

    private DatabaseReference databaseReference;  // Reference to the Firebase database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_speed_limit);

        // Initialize the UI elements
        etSpeedLimit = findViewById(R.id.et_speed_limit);
        btnSetSpeed = findViewById(R.id.btn_set_speed);

        // Get a reference to the "SpeedLimit" node in Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("SpeedLimit");

        // Set a click listener on the button to save the speed limit to Firebase
        btnSetSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered speed limit
                String speedLimit = etSpeedLimit.getText().toString();
                // Check if the speed limit input is not empty
                if (!speedLimit.isEmpty()) {
                    // Save the speed limit to Firebase
                    databaseReference.setValue(speedLimit);
                    // Show a toast message to indicate success
                    Toast.makeText(SetSpeedLimitActivity.this, "Speed limit set to " + speedLimit + " km/h", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
