package com.dailybenefit1k.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.dailybenefit1k.R;
import com.dailybenefit1k.ui.base.BaseActivity;
import com.dailybenefit1k.ui.menu.FormMenuImpl;
import javax.inject.Inject;

/**
 * Created by gPrifti on 7/5/2018.
 */

public class EmailMenuImp extends BaseActivity implements EmailMenu.View {

    private Button startButton;
    private EditText mailEditext;
    private TextView countDownTextView;

    @Inject EmailMenu.Presenter emailMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getmActivityComponent().inject(this);

        setView();

        startButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                emailMenuPresenter.checkField(mailEditext.getText().toString());
            }
        });

        emailMenuPresenter.onAttach(this);

        emailMenuPresenter.countnNumber();
    }

    private  void setView(){

        startButton = (Button)findViewById(R.id.bt_start);
        mailEditext = (EditText)findViewById(R.id.editText);
        countDownTextView = (TextView)findViewById(R.id.txt_coundoun);
    }

    @Override
    public void onTick(String millisUntilFinished) {

        countDownTextView.setText(millisUntilFinished);
    }

    @Override
    public void checkEmail() {

        Toast.makeText(getApplicationContext(),R.string.check_email,Toast.LENGTH_LONG).show();
    }

    @Override
    public void success() {

     Intent intent =  new Intent(getApplicationContext(), FormMenuImpl.class);
     startActivity(intent);

    }

    @Override
    public void onDestroy() {
        emailMenuPresenter.rxUnsubscribe();
        emailMenuPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        final android.view.View currentFocus = getCurrentFocus();
        if (!(currentFocus instanceof EditText) || !isTouchInsideView(ev, currentFocus)) {
            ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        return super.dispatchTouchEvent(ev);
    }

    private boolean isTouchInsideView(final MotionEvent ev, final android.view.View currentFocus) {
        final int[] loc = new int[2];
        currentFocus.getLocationOnScreen(loc);
        return ev.getRawX() > loc[0] && ev.getRawY() > loc[1] && ev.getRawX() < (loc[0] + currentFocus.getWidth())
                && ev.getRawY() < (loc[1] + currentFocus.getHeight());
    }
}
