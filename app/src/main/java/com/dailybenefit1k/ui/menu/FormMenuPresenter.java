package com.dailybenefit1k.ui.menu;

import android.content.Context;
import static com.dailybenefit1k.util.Contants.EMAIL_PATERN;


public class FormMenuPresenter  implements  FormMenuInterface.Presenter {

    Context context;
    FormMenu formMenu;

    public FormMenuPresenter(Context context, FormMenu formMenu) {
        this.context = context;
        this.formMenu = formMenu;

    }

    @Override
    public void checkField(String name, String surname, String mail, String password, String phone, String city) {

        if (name.length()<5){

            formMenu.completeName();

        }else if (surname.length()<5){

            formMenu.completeSurname();

        }else if (!mail.matches(EMAIL_PATERN)){

            formMenu.completeEmail();

        }else if (password.length()<6){

            formMenu.completePassword();

        }else if (phone.length()<9){

            formMenu.completePhone();

        }

        else if (city.isEmpty()){

            formMenu.completeCity();

        }else {

            formMenu.succes();
        }

    }
}
