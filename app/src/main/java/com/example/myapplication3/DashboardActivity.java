package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    TextView nameuser;
    EditText name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nameuser = findViewById(R.id.txtUser);
        name = findViewById(R.id.txtNombre);
        email = findViewById(R.id.txtEmail);
        phone = findViewById(R.id.txtPhone);

        Bundle bundle = getIntent().getExtras();

        nameuser.setText(bundle.getString("user"));


    }

    public void Guardar (View view){
        String nombre = name.getText().toString();
        String correo = email.getText().toString();
        String tel = phone.getText().toString();

        EditText editnombre = findViewById(R.id.txtNombre);
        EditText editemail = findViewById(R.id.txtEmail);
        EditText editphone = findViewById(R.id.txtPhone);

        Usuario usuario = new Usuario(nombre, correo, tel);
        usuario.save();

        editnombre.setText("");
        editemail.setText("");
        editphone.setText("");
    }

    public void Consultar (View view){
        String tel = phone.getText().toString();
        List<Usuario> usuario = Usuario.find(Usuario.class, "phone="+tel, null);
        if(usuario.isEmpty()){
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
        }else{
            Usuario user = usuario.get(0);

            name.setText(user.getNombre());
            email.setText(user.getEmail());
        }

    }

    public void Eliminar (View view){
        String tel = phone.getText().toString();

        EditText editnombre = findViewById(R.id.txtNombre);
        EditText editemail = findViewById(R.id.txtEmail);
        EditText editphone = findViewById(R.id.txtPhone);

        List<Usuario> usuario = Usuario.find(Usuario.class, "phone="+tel, null);
        if(usuario.isEmpty()){
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
        }else {
            Usuario user = usuario.get(0);

            user.delete();
            Toast.makeText(this, "Usuario eliminado con exito", Toast.LENGTH_SHORT).show();

            editnombre.setText("");
            editemail.setText("");
            editphone.setText("");
        }
    }

    public void Actualizar (View view){
        String nombre = name.getText().toString();
        String correo = email.getText().toString();
        String tel = phone.getText().toString();

        EditText editnombre = findViewById(R.id.txtNombre);
        EditText editemail = findViewById(R.id.txtEmail);
        EditText editphone = findViewById(R.id.txtPhone);

        List<Usuario> usuario = Usuario.find(Usuario.class, "phone="+tel, null);
        if(usuario.isEmpty()){
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
        }else {
            Usuario user = usuario.get(0);

            user.setEmail(correo);
            user.setNombre(nombre);
            user.save();

            editnombre.setText("");
            editemail.setText("");
            editphone.setText("");
        }
    }

}
