package com.dailybenefit1k.ui.base;


public interface Base {

    interface MvpPresenter  <V extends MvpView> {

        void onAttach(V mvpView);

        void onDetach();
    }

    interface MvpView {

        void onSucess();

        void onError();

        void checkInternetConnection();

    }
}