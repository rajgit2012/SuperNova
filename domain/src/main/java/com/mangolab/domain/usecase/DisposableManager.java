package com.mangolab.domain.usecase;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by rajforhad on 15/01/2018.
 */

public class DisposableManager {
	private static CompositeDisposable compositeDisposable;

	public static void add(Disposable disposable){
		getCompositeDisposable().add(disposable);
	}

	private static CompositeDisposable getCompositeDisposable(){
		if(compositeDisposable == null || compositeDisposable.isDisposed()){
			compositeDisposable = new CompositeDisposable();
		}

		return compositeDisposable;
	}

	private DisposableManager(){
	}
}
