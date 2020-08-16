package com.dailybenefit1k.ui.email;

import com.dailybenefit1k.ui.base.Base;


/**
 * Created by gPrifti on 7/5/2018.
 */

public interface EmailMenu  extends  Base.MvpView {

    interface View extends Base.MvpView {

        void onTick(String millisUntilFinished);

        void checkEmail();

        void success();
    }


    interface Presenter  <T extends Base.MvpView>  extends Base.MvpPresenter<T>{

        void setView(T view);

        void countnNumber();

        void checkField(String string);

        void rxUnsubscribe();
    }
}
