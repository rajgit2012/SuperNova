package com.mangolab.supernova.login;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by rajforhad on 15/01/2018.
 */
public class LoginPresenterTest {
	private LoginPresenter loginPresenter;
	private LoginContract.LoginView loginView;

	@Before
	public void setUp() throws Exception {
		loginView = mock(LoginContract.LoginView.class);
		loginPresenter = new LoginPresenter(loginView);
	}

	@Test
	public void checkIfLoginAttemptExceeded(){
		Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
		Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
		//Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
		//Assert.assertEquals(4, loginPresenter.incrementLoginAttempt());

		Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
	}

	@Test
	public void checkIfLoginAttemptIsNotExceeded(){
		Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
	}

	@Test
	public void checkUsernamePasswordIsCorrect() throws Exception {
		loginPresenter.doLogin("rajforhad", "123456");
		verify(loginView).showLoginSuccessMessage();
	}

	@Test
	public void checkIfLoginAttemptExceededAndViewMethodCalled() throws Exception {
		loginPresenter.doLogin("rajfdorhad", "123456");
		loginPresenter.doLogin("rajforahad", "123456");
		loginPresenter.doLogin("rajfaaorhad", "123456");
		loginPresenter.doLogin("rajforhads", "123456");

		verify(loginView).showErrorMessageForMaxLoginAttempt();
	}

	@Test
	public void checkIfLoginAttemptIsExceededAndViewMethodCalled()
	{
		loginPresenter.doLogin("rajforhads", "123456");
		loginPresenter.doLogin("rajforhads", "123456");
		loginPresenter.doLogin("rajforhads", "123456");
		loginPresenter.doLogin("rajforhads", "123456");

		verify(loginView).showErrorMessageForMaxLoginAttempt();
	}
}