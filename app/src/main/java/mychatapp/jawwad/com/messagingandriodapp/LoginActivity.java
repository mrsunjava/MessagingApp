package mychatapp.jawwad.com.messagingandriodapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {
    private Button signInButton;
    private TextInputLayout emailField;
    private TextInputLayout passwordField;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailField = (TextInputLayout) findViewById(R.id.emailField);
        passwordField = (TextInputLayout) findViewById(R.id.passwordField);
        firebaseAuth = FirebaseAuth.getInstance();
        signInButton = (Button) findViewById(R.id.signIn);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getEditText().getText().toString();
                String password = passwordField.getEditText().getText().toString();
                if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                    LoginUser(email, password);
                } else {
                    Toast.makeText(LoginActivity.this, "Email Address or Password can not be empty", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void LoginUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(mainIntent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
