package com.mangolab.supernova.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mangolab.supernova.R;

/**
 * Created by rajforhad on 15/01/2018.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public void showLoginSuccessMessage() {

	}

	@Override
	public void showErrorMessageForWrongUsernamePassword() {

	}

	@Override
	public void showErrorMessageForMaxLoginAttempt() {

	}
}
