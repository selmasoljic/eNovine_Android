package android.fit.ba.myapp;

import android.content.Intent;
import android.fit.ba.myapp.data.AutentifikacijaResultVM;
import android.fit.ba.myapp.helper.MySession;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        AutentifikacijaResultVM x = MySession.getKorisnik();

        if (x==null)
        {
            startActivity(new Intent(this, LoginActivity.class));
        }
        else
        {
            startActivity(new Intent(this, GlavniActivity.class));
        }

    }
}
