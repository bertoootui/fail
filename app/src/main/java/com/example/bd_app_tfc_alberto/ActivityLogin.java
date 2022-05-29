package com.example.bd_app_tfc_alberto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bd_app_tfc_alberto.database.Login_DB;

public class ActivityLogin extends AppCompatActivity {
    EditText edtpass, edtemail, edtconfirm;
    Button butregis, butlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtconfirm = findViewById(R.id.etdConfirmpass);
        edtpass = findViewById(R.id.etdPass);
        edtemail = findViewById(R.id.etdEmail);
        butregis = findViewById(R.id.butregister);
        butlogin = findViewById(R.id.butlogin);
        Login_DB login_db = new Login_DB(getApplicationContext());
        butregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtconfirm.setVisibility(View.VISIBLE);
                butregis.setVisibility(View.INVISIBLE);
            }
        });
        butlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = edtpass.getText().toString();
                String email = edtemail.getText().toString();
                if(pass.equals("") || email.equals(""))
                {
                    Toast.makeText(ActivityLogin.this, "No se pueden tener los campos vacíos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String confirm = edtconfirm.getText().toString();
                    if(confirm.equals(pass))
                    {
                        login_db.register(email,confirm);
                    }
                    else
                    {
                        Toast.makeText(ActivityLogin.this, "Las contraseñas no coínciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });


    }
}