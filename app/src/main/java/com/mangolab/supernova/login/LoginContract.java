package com.mangolab.supernova.login;

import com.mangolab.supernova.base.BasePresenter;

/**
 * Created by rajforhad on 15/01/2018.
 */

public interface LoginContract extends BasePresenter {

	interface LoginPresenter{
		void doLogin(String rajforhad, String s);
	}

	interface LoginView{
		void showLoginSuccessMessage();
		void showErrorMessageForWrongUsernamePassword();
		void showErrorMessageForMaxLoginAttempt();
	}
}
