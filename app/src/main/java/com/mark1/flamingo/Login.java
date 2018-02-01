package com.mark1.flamingo;

import android.content.Intent;
import android.app.Dialog;
import android.widget.Toast;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.auth0.android.Auth0;
import com.auth0.android.authentication.AuthenticationAPIClient;
import com.auth0.android.authentication.AuthenticationException;
import com.auth0.android.callback.BaseCallback;
import com.auth0.android.provider.AuthCallback;
import com.auth0.android.provider.WebAuthProvider;
import com.auth0.android.result.Credentials;
import com.auth0.android.result.UserProfile;


public class Login extends Activity {
    private CardView homepageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        homepageButton = (CardView) findViewById(R.id.card);
        homepageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Your own Activity code
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Auth0 account = new Auth0(this);

        WebAuthProvider.init(account)
                .withConnectionScope("openid", "offline_access")
                .start(Login.this, mCallback);
    }

    public void openHomepage(){
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    private void showToastText(final String text) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(Login.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private final AuthCallback mCallback = new AuthCallback() {
        @Override
        public void onSuccess(Credentials credentials) {
            showToastText("Log In - Success");
            //Redirect to Homepage
            startActivity(new Intent(Login.this, Homepage.class));
            finish();
        }

    @Override
    public void onFailure(Dialog dialog) {
        showToastText("Log In - Cancelled");
    }

    @Override
    public void onFailure(AuthenticationException exception) {
        showToastText("Log In - Error Occurred");
    }
};}
