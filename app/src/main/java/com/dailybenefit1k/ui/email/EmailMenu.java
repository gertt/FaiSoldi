package com.dailybenefit1k.ui.email;

/**
 * Created by gPrifti on 7/5/2018.
 */

public interface EmailMenu {

    interface View {

        void onTick(String millisUntilFinished);

        void checkEmail();

        void success();
    }

    interface Presenter {

        void setView(EmailMenu.View view);

        void countnNumber();

        void checkField(String string);

        void rxUnsubscribe();
    }
}
