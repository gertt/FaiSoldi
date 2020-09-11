package com.dailybenefit1k.ui.menu;

import android.content.Context;

import com.dailybenefit1k.di.scope.ApplicationContext;
import com.dailybenefit1k.repository.Repository;
import com.dailybenefit1k.repository.network.model.request.FormModel;
import com.dailybenefit1k.ui.base.BasePresenter;
import javax.inject.Inject;
import io.reactivex.disposables.Disposable;
import static com.dailybenefit1k.util.Cons.EMAIL_PATERN;
import static com.dailybenefit1k.util.NetworkVerification.isNetworkConnected;

public class FormMenuPresenterImpl<T extends FormMenu.View> extends BasePresenter<T> implements FormMenu.Presenter<T> {

   private Repository repository;

   private Disposable disposable;


   Context context;


    @Inject
    public FormMenuPresenterImpl(@ApplicationContext  Context ctx,Repository repository) {
        this.context = ctx;
        this.repository = repository;
    }

    @Override
    public void checkField(String name, String surname, String mail, String password, String phone, String city) {


        FormModel formModel = new FormModel();
        formModel.setName(name);
        formModel.setSurname(surname);
        formModel.setMail(mail);
        formModel.setPassword(password);
        formModel.setPhone(phone);
        formModel.setCity(city);

        if (isNetworkConnected(context)){

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
                disposable = repository.registration(formModel)
                        .subscribe(response -> getmMvpView().succes(),
                                throwable -> getmMvpView().succes());
            }

        }else {
            getmMvpView().checkInternetConnection();
        }
    }

    @Override
    public void setEmail() {
        getmMvpView().setEmail(repository.getEmail());
    }

    @Override
    public void rxUnsubscribe() {
        disposable.dispose();
    }
}
