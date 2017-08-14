package com.example.kalpesh.weather_androidtest.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by kalpesh on 14/08/2017.
 */

public class BasePresenter<T extends MVPView> implements MVPPresenter<T> {

    private T view;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(T mvpView) {
        view = mvpView;

    }

    @Override
    public void detachView() {
        compositeDisposable.clear();
        view = null;
    }

    public T getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    public void addSubscription(Disposable subscription) {
        this.compositeDisposable.add(subscription);
    }



    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
        }
    }
}
