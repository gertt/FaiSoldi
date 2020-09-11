package com.dailybenefit1k.ui.base;

public  abstract class BasePresenter  <V extends Base.MvpView> implements Base.MvpPresenter<V>{

    private V mMvpView;

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
    }

    public V getmMvpView() {
        return mMvpView;
    }

    public void setmMvpView(V mMvpView) {
        this.mMvpView = mMvpView;
    }
}
