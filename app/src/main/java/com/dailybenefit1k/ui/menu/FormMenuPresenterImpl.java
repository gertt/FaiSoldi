package com.dailybenefit1k.ui.menu;

import com.dailybenefit1k.ui.base.BasePresenter;

import javax.inject.Inject;

import static com.dailybenefit1k.util.Contants.EMAIL_PATERN;


public class FormMenuPresenterImpl  < T extends FormMenu.View > extends BasePresenter<T> implements FormMenu.Presenter<T>{


      FormMenuImpl formMenuImpl;

      @Inject
      public FormMenuPresenterImpl() {

      }

    @Override
    public void checkField(String name, String surname, String mail, String password, String phone, String city) {

        if (name.length() < 5) {
            formMenuImpl.completeName();
        } else if (surname.length() < 5) {
            formMenuImpl.completeSurname();
        } else if (!mail.matches(EMAIL_PATERN)) {
            formMenuImpl.completeEmail();
        } else if (password.length() < 6) {
            formMenuImpl.completePassword();
        } else if (phone.length() < 9) {
            formMenuImpl.completePhone();
        } else if (city.isEmpty()) {
            formMenuImpl.completeCity();
        } else {
            formMenuImpl.succes();
        }
    }
}
