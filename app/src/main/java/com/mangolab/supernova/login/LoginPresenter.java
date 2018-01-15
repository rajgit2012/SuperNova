package com.mangolab.supernova.login;

/**
 * Created by rajforhad on 15/01/2018.
 */

public class LoginPresenter implements LoginContract.LoginPresenter {
	private static final int MAX_ATTEMPTS = 3;
	private LoginContract.LoginView loginView;
	private int loginAttempt;

	public LoginPresenter(LoginContract.LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void doLogin(String username, String password) {
		if(isLoginAttemptExceeded()){
			loginView.showErrorMessageForMaxLoginAttempt();
			return;
		}

		if(username.equals("rajforhad") && password.equals("123456")){
			loginView.showLoginSuccessMessage();
			resetLoginAttempt();

			return;
		}

		incrementLoginAttempt();
		loginView.showErrorMessageForWrongUsernamePassword();
	}

	private void resetLoginAttempt() {
		loginAttempt = 0;
	}

	public int incrementLoginAttempt() {
		loginAttempt = loginAttempt + 1;
		return loginAttempt;
	}

	public boolean isLoginAttemptExceeded() {
		return loginAttempt >= MAX_ATTEMPTS;
	}
}
