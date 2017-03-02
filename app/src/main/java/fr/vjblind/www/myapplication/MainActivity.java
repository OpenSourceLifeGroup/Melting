package fr.vjblind.www.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import android.support.v4.app.Fragment;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());


        setContentView(R.layout.activity_main);
loginButton= (LoginButton)findViewById(R.id.fb_login);
        textView=(TextView)findViewById(R.id.textView);
      callbackManager=CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                textView.setText("yes \n "+ loginResult.getAccessToken().getUserId()+"\n"
                        +loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
            textView.setText("no");
            }

            @Override
            public void onError(FacebookException e) {

            }
        });
  }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
