package com.example.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private Button btnMostrar;
    private String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnMostrar = findViewById(R.id.btnEntrar);


        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ejecutado", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });




        Log.d(TAG, "onCreate Called" );
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStar Called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume Called");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause Called");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop Called");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy Called");
    }
}
