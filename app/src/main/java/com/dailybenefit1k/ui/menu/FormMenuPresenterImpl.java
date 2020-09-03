package com.dailybenefit1k.ui.menu;

import com.dailybenefit1k.repository.Repository;
import com.dailybenefit1k.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

import static com.dailybenefit1k.util.Contants.EMAIL_PATERN;


public class FormMenuPresenterImpl<T extends FormMenu.View> extends BasePresenter<T> implements FormMenu.Presenter<T> {

    Repository repository;

    private Disposable disposable;

    @Inject
    public FormMenuPresenterImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void checkField(String name, String surname, String mail, String password, String phone, String city) {

        if (name.length() < 5) {
            getmMvpView().completeName();
        } else if (surname.length() < 5) {
            getmMvpView().completeSurname();
        } else if (!mail.matches(EMAIL_PATERN)) {
            getmMvpView().completeEmail();
        } else if (password.length() < 6) {
            getmMvpView().completePassword();
        } else if (phone.length() < 9) {
            getmMvpView().completePhone();
        } else if (city.isEmpty()) {
            getmMvpView().completeCity();
        } else {

            disposable = repository.doCall()
                    .subscribe(userInfo ->
                                    getmMvpView().succes(userInfo.getAuthorizationsUrl()),
                            throwable -> {
                                getmMvpView().succes(throwable.toString());
                            });

        }
    }
}
