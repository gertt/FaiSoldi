package com.dailybenefit1k.ui.menu;

import com.dailybenefit1k.ui.base.BasePresenter;
import javax.inject.Inject;
import static com.dailybenefit1k.util.Contants.EMAIL_PATERN;

public class FormMenuPresenterImpl  < T extends FormMenu.View > extends BasePresenter<T> implements FormMenu.Presenter<T>{

      @Inject
      public FormMenuPresenterImpl() {

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
            getmMvpView().succes();
        }
    }
}
