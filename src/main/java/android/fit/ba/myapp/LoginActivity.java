package android.fit.ba.myapp;

import android.content.Intent;
import android.fit.ba.myapp.data.AutentifikacijaLoginPostVM;
import android.fit.ba.myapp.data.AutentifikacijaResultVM;
import android.fit.ba.myapp.helper.MyApiRequest;
import android.fit.ba.myapp.helper.MyRunnable;
import android.fit.ba.myapp.helper.MySession;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;
    private TextView goToReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_btnLoginClick();
            }
        });

    }

    private void do_btnLoginClick() {

        String strUsername = txtUsername.getText().toString();
        String strPassword = txtPassword.getText().toString();

        AutentifikacijaLoginPostVM model = new AutentifikacijaLoginPostVM(strUsername, strPassword);

        MyApiRequest.post(this, "Autentifikacija/LoginCheck", model, new MyRunnable<AutentifikacijaResultVM>() {
            @Override
            public void run(AutentifikacijaResultVM x) {
                checkLogin(x);
            }
        });
    }

    private void checkLogin(AutentifikacijaResultVM x) {
        if (x==null)
        {
            View parentLayout = findViewById(android.R.id.content);
            Snackbar.make(parentLayout, "Pogrešan username/password", Snackbar.LENGTH_LONG).show();
        }
        else
        {
            MySession.setKorisnik( x);
            startActivity(new Intent(this, GlavniActivity.class));
        }
    }
}
