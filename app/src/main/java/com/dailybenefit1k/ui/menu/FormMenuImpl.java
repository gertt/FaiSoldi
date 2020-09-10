package com.dailybenefit1k.ui.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.dailybenefit1k.R;
import com.dailybenefit1k.ui.base.BaseActivity;
import com.jaredrummler.materialspinner.MaterialSpinner;
import javax.inject.Inject;

import static com.dailybenefit1k.util.Cons.URL_PRIVACY;

/**
 * Created by gPrifti on 7/5/2018.
 */

public class FormMenuImpl extends BaseActivity implements FormMenu.View {

    private EditText edx_name;
    private EditText edx_surname;
    private EditText edx_mail;
    private EditText edx_password;
    private EditText edx_phone;

    private TextView txt_bottom;
    private TextView txt_privacy;

    private Button bt_signup;

    @Inject
    FormMenu.Presenter formMenuPresenter;

    String city = "Italy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_form_menu2);
        getmActivityComponent().inject(this);

        setView();

        txt_bottom.setOnClickListener(v -> urlPrivacy());

        txt_privacy.setOnClickListener(v -> urlPrivacy());

        bt_signup.setOnClickListener(v -> formMenuPresenter.checkField(fromTextToString(edx_name), fromTextToString(edx_surname), fromTextToString(edx_mail), fromTextToString(edx_password), fromTextToString(edx_phone), city));

        String[] some_array = getResources().getStringArray(R.array.states);

        MaterialSpinner spinner = findViewById(R.id.spinner);
        spinner.setItems(some_array);
        spinner.setOnItemSelectedListener((MaterialSpinner.OnItemSelectedListener<String>) (view, position, id, item) -> city = item);
        spinner.setOnNothingSelectedListener(spinner1 -> {
            spinner1.setSelectedIndex(0);
            city = "";
        });
    }

    private void setView() {

        edx_name = findViewById(R.id.edx_name);
        edx_surname = findViewById(R.id.edx_surname);
        edx_mail = findViewById(R.id.edx_email);
        edx_password = findViewById(R.id.edx_password);
        edx_phone = findViewById(R.id.edx_phone);

        txt_bottom = findViewById(R.id.txt_botom);
        txt_privacy = findViewById(R.id.txt_privacy);

        bt_signup = (Button) findViewById(R.id.bt_signup);

        formMenuPresenter.onAttach(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void urlPrivacy() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_PRIVACY));
        startActivity(browserIntent);
    }

    @Override
    public void completeName() {
        Toast.makeText(getApplicationContext(), R.string.check_name, Toast.LENGTH_LONG).show();
    }

    @Override
    public void completeSurname() {
        Toast.makeText(getApplicationContext(), R.string.check_surname, Toast.LENGTH_LONG).show();
    }

    @Override
    public void completeEmail() {
        Toast.makeText(getApplicationContext(), R.string.check_email, Toast.LENGTH_LONG).show();
    }

    @Override
    public void completePassword() {
        Toast.makeText(getApplicationContext(), R.string.check_password, Toast.LENGTH_LONG).show();
    }

    @Override
    public void completeCity() {
        Toast.makeText(getApplicationContext(), R.string.check_state, Toast.LENGTH_LONG).show();
    }

    @Override
    public void completePhone() {
        Toast.makeText(getApplicationContext(), R.string.check_phone, Toast.LENGTH_LONG).show();
    }

    @Override
    public void succes() {
        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        formMenuPresenter.rxUnsubscribe();
        formMenuPresenter.onDetach();
        super.onDestroy();
    }

    private String fromTextToString(EditText edx) {
        return edx.getText().toString();
    }
}

