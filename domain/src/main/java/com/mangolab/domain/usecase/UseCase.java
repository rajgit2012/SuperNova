package com.mangolab.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by rajforhad on 15/01/2018.
 */
abstract class UseCase<T>{
	private final Scheduler backendExecutor;
	private final Scheduler uiThreadExecutor;

	protected UseCase(Scheduler backendExecutorScheduler, Scheduler uiThread) {
		this.backendExecutor = backendExecutorScheduler;
		this.uiThreadExecutor = uiThread;
	}

	public void executeObserver(DisposableObserver<T> disposableObserver){
		if(disposableObserver == null){
			throw new IllegalArgumentException("Disposable must not be null");
		}
		final Observable<T> observableUseCase = this.createObservableUseCase().subscribeOn(backendExecutor).observeOn(uiThreadExecutor);
		DisposableObserver disposableObserverData = observableUseCase.subscribeWith(disposableObserver);

		DisposableManager.add(disposableObserverData);
	}

	protected abstract Observable createObservableUseCase();
}