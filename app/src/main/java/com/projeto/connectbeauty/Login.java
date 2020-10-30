package com.projeto.connectbeauty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText campoEmail, campoSenha;
    private Button botaoEntrar;
    private ProgressBar progressBar;

    private Usuario usuario;
    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializarComponentes();

        progressBar.setVisibility( View.GONE);
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();
                if ( !textoEmail.isEmpty() ){
                    if ( !textoSenha.isEmpty() ){

                        usuario = new Usuario();
                        usuario.setEmail( textoEmail );
                        usuario.setSenha( textoSenha );
                        validarLogin( usuario );

                    }else{
                        Toast.makeText(Login.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Login.this, "Preencha o email!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void validarLogin(Usuario usuario){
        progressBar.setVisibility(View.VISIBLE);
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful() ){
                    progressBar.setVisibility( View.GONE);
                    startActivity(new Intent(getApplicationContext(), Principal.class));
                    finish();
                }else
                {
                    Toast.makeText(Login.this, "Erro ao fazer login",
                            Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
    public void goBack (View view) {
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
    }

    public void goToPrincipal (View view) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void goToEsqueci (View view) {
        Intent intent = new Intent(this, EsqueciMinhaSenha.class);
        startActivity(intent);
    }
    public void inicializarComponentes(){
        campoEmail = findViewById(R.id.editLoginEmail);
        campoSenha = findViewById(R.id.editLoginSenha);
        botaoEntrar = findViewById(R.id.buttonEntrar);
        progressBar = findViewById(R.id.progressLogin);

        campoEmail.requestFocus();
    }
}
