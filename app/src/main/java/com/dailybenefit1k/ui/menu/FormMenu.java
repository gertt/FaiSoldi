package com.dailybenefit1k.ui.menu;

import com.dailybenefit1k.ui.base.Base;

/**
 * Created by gPrifti on 7/5/2018.
 */

public interface FormMenu  extends  Base.MvpView {

    interface View  extends Base.MvpView {

        void completeName();

        void completeSurname();

        void completeEmail();

        void completePassword();

        void completeCity();

        void succes();

        void completePhone();

    }

    interface Presenter <T extends Base.MvpView>  extends Base.MvpPresenter<T> {

        void checkField(String name, String surname, String mail, String password, String phone, String city);
    }

    interface Model {

    }
}
