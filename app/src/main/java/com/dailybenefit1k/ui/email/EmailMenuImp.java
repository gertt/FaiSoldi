package com.dailybenefit1k.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.dailybenefit1k.R;
import com.dailybenefit1k.app.App;
import com.dailybenefit1k.ui.base.BaseActivity;
import com.dailybenefit1k.ui.menu.FormMenu;
import javax.inject.Inject;

/**
 * Created by gPrifti on 7/5/2018.
 */

public class EmailMenuImp extends BaseActivity implements EmailMenu.View {

    private ConstraintLayout constraintLayout;
    private Button bt;
    private Button button_inizia;
    private EditText edx_mail;

    @Inject EmailMenu.Presenter emailMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getApplication()).getActivityComponent().inject(this);

        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.button3);
        button_inizia = (Button)findViewById(R.id.button);
        edx_mail = (EditText)findViewById(R.id.editText);

       constraintLayout = (ConstraintLayout)findViewById(R.id.idid);

        button_inizia.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                emailMenuPresenter.checkField(edx_mail.getText().toString());

            }
        });

        constraintLayout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Intent intent =  new Intent(getApplicationContext(),FormMenu.class);
                startActivity(intent);
            }
        });

        emailMenuPresenter.setView(this);
        emailMenuPresenter.countnNumber();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onTick(String millisUntilFinished) {

        bt.setText(millisUntilFinished);

    }

    @Override
    public void checkEmail() {

        Toast.makeText(getApplicationContext(),R.string.check_email,Toast.LENGTH_LONG).show();

    }

    @Override
    public void success() {

     Intent intent =  new Intent(getApplicationContext(),FormMenu.class);
     startActivity(intent);

    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        // all touch events close the keyboard before they are processed except EditText instances.
        // if focus is an EditText we need to check, if the touchevent was inside the focus editTexts
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        emailMenuPresenter.rxUnsubscribe();
    }
}
