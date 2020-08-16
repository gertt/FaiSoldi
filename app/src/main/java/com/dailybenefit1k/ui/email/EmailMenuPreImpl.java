package com.dailybenefit1k.ui.email;


import com.dailybenefit1k.repository.pref.PrefStorage;
import com.dailybenefit1k.ui.base.BasePresenter;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import static com.dailybenefit1k.util.Contants.EMAIL_PATERN;

/**
 * Created by gPrifti on 7/5/2018.
 */

public class EmailMenuPreImpl  <T extends EmailMenu.View > extends BasePresenter<T> implements EmailMenu.Presenter<T>{

    private Disposable disposable;

    PrefStorage prefStorage;

    @Inject
    public EmailMenuPreImpl(PrefStorage prefStorage) {
        this.prefStorage = prefStorage;

    }


    @Override
    public void countnNumber() {
        long start = 120;
        disposable = Observable.interval(1, TimeUnit.SECONDS)
                .take(60)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        getmMvpView().onTick(Long.toString(start - aLong));
                    }
                });
    }

    @Override
    public void checkField(String email) {

        if (!email.matches(EMAIL_PATERN)) {
            getmMvpView().checkEmail();
        } else {
            prefStorage.saveEmail(email);
            getmMvpView().success();
        }
    }

    @Override
    public void rxUnsubscribe() {
        disposable.dispose();
    }
}


