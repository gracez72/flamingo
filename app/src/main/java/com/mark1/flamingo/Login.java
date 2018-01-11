package com.mark1.flamingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class Login extends AppCompatActivity {
    private CardView homepageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        \\homepageButton = (CardView) findViewById(R.id.card);

    }
}
