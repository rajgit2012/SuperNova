package com.mangolab.domain.usecase;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by rajforhad on 15/01/2018.
 */

abstract class UseCase<T>{
	private final CompositeDisposable compositeDisposable;
	private final Scheduler backendExecutor;
	private final Scheduler uiThreadExecutor;

	protected UseCase(Scheduler backendExecutorScheduler, Scheduler uiThread) {
		compositeDisposable = new CompositeDisposable();
		backendExecutor = backendExecutorScheduler;
		uiThreadExecutor = uiThread;
	}
}