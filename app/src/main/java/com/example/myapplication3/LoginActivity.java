package com.example.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText usuario, clave;
    private Button btnIngresar;

    TextView regis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUsername);
        clave = findViewById(R.id.txtPassword);

        regis = findViewById(R.id.textViewRegister);

        btnIngresar = findViewById(R.id.btnLogin);


    }

    public void ingresar(View view){
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();

        if(user.equals("juan") && pass.equals("1234")){
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_LONG).show();
        }

    }

}
