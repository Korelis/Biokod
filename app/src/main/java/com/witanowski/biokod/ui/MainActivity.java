package com.witanowski.biokod.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.witanowski.biokod.R;
import com.witanowski.biokod.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
