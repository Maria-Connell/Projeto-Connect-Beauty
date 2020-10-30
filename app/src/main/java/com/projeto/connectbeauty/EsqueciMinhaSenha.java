package com.projeto.connectbeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class EsqueciMinhaSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_minha_senha);
    }

    public void goToLogin (View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
