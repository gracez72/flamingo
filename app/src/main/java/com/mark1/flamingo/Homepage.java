package com.mark1.flamingo;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {
    private CardView diagnoseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        diagnoseButton = (CardView) findViewById(R.id.diagnose);
        diagnoseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGenInfo();
            }
        });

    };

    public void openGenInfo(){
        Intent intent = new Intent(this, GenInfo.class);
        startActivity(intent);
    }
    }



