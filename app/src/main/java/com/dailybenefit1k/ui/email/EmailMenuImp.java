package com.dailybenefit1k.ui.email;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dailybenefit1k.BuildConfig;
import com.dailybenefit1k.R;
import com.dailybenefit1k.ui.base.BaseActivity;
import com.dailybenefit1k.ui.menu.FormMenuImpl;
import javax.inject.Inject;

/**
 * Created by gPrifti on 7/5/2018.
 */

public class EmailMenuImp extends BaseActivity implements EmailMenu.View {

    private Button startButton;
    private TextView mailEditext;
    private TextView countDownTextView;

    @Inject EmailMenu.Presenter emailMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getmActivityComponent().inject(this);

        setView();

        startButton.setOnClickListener(v -> emailMenuPresenter.checkField(mailEditext.getText().toString()));

        emailMenuPresenter.onAttach(this);
        emailMenuPresenter.countnNumber();
    }

    private  void setView(){
        startButton = findViewById(R.id.bt_start);
        mailEditext = findViewById(R.id.txt_email);
        countDownTextView = findViewById(R.id.txt_coundoun);
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
}
