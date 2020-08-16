package com.dailybenefit1k.ui.menu;

/**
 * Created by gPrifti on 7/5/2018.
 */

public interface FormMenuInterface {

    interface View {

        void completeName();

        void completeSurname();

        void completeEmail();

        void completePassword();

        void completeCity();

        void succes();

        void completePhone();

    }

    interface Presenter {

        void checkField(String name, String surname, String mail, String password, String phone, String city);
    }


    interface Model {

    }

}
