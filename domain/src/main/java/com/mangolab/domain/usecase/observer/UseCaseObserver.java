package com.mangolab.domain.usecase.observer;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by rajforhad on 15/01/2018.
 */

public class UseCaseObserver<T> extends DisposableObserver<T> {
	@Override
	public void onNext(T t) {

	}

	@Override
	public void onError(Throwable e) {

	}

	@Override
	public void onComplete() {

	}
}
