package com.dailybenefit1k.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.dailybenefit1k.R;
import com.dailybenefit1k.app.App;
import com.jaredrummler.materialspinner.MaterialSpinner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import static com.dailybenefit1k.util.Contants.URL_PRIVACY;


/**
 * Created by gPrifti on 7/5/2018.
 */

public class FormMenu extends AppCompatActivity  implements  FormMenuInterface.View {


   private EditText edx_name;
   private EditText edx_surname;
   private EditText edx_mail;
   private EditText edx_password;
   private EditText edx_phone;

   private TextView txt_bottom;
   private TextView txt_privacy;

   private Button bt_signup;

   private FormMenuPresenter formMenuPresenter;


   String city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ((App)getApplication()).getComponent().inject(this);
        setContentView(R.layout.activity_form_menu);

        city = "Italy";

        edx_name = (EditText)findViewById(R.id.edx_name);
        edx_surname = (EditText)findViewById(R.id.edx_surname);
        edx_mail = (EditText)findViewById(R.id.edx_email);
        edx_password = (EditText)findViewById(R.id.edx_password);
        edx_phone = (EditText)findViewById(R.id.edx_phone);

        txt_bottom = (TextView)findViewById(R.id.txt_botom);
        txt_privacy = (TextView)findViewById(R.id.txt_privacy);

        bt_signup = (Button) findViewById(R.id.bt_signup);





        Collection secondList = new ArrayList();
        secondList.add("apple");
        secondList.add("orange");
        secondList.add("strawberry");
        secondList.add("banana");


        Collection firstList = new ArrayList();
        firstList.add("apple");
        firstList.add("orange");
        firstList.add("banana");



        boolean isAmazon = false;
        boolean isGas = false;
        boolean isEnergia = false;
        boolean isPermitet = true;
        Iterator<String> iterator = firstList.iterator();

        secondList.removeAll(firstList);



        Iterator<String> iterator2 = secondList.iterator();

        if (secondList.size()==0){

            String first = iterator2.next();

        }else if(secondList.size()==0){

            while (iterator.hasNext()) {

                if (iterator.next().equalsIgnoreCase("AMAZON")) {

                    isAmazon = true;
                }

                if (iterator.next().equalsIgnoreCase("ENERGIA")) {

                    isEnergia = true;
                }
                if (iterator.next().equalsIgnoreCase("GAS")) {

                    isGas = true;
                }
            }
        }

        if(isAmazon){

            if (!isEnergia){

                //fail

            }else if(!isGas){


                //fail
            }


        }else {



          //  is ok
        }






        List<String> myList = new ArrayList<>();


       // boolean isAmazon = false;



        for (int i = 0;i<myList.size();i++){

            if (myList.get(i).equalsIgnoreCase("AMAZON")){

                isAmazon =  true;
            }

            if (myList.get(i).equalsIgnoreCase("ENERGIA")){

                isEnergia =  true;
            }

            if (myList.get(i).equalsIgnoreCase("GAS")){

                isGas =  true;
            }

        }


        if (isAmazon){


            if (isEnergia && isGas){


            }else if(isEnergia){


            }else if (isGas){


            }


        }else{



        }





        formMenuPresenter = new FormMenuPresenter(getApplicationContext(),this);

        txt_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                urlPrivacy();

            }
        });


        txt_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                urlPrivacy();
            }
        });


        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                formMenuPresenter.checkField(edx_name.getText().toString(),edx_surname.getText().toString(),
                        edx_mail.getText().toString(),edx_password.getText().toString(),edx_phone.getText().toString(),city);

            }
        });


        String[] some_array = getResources().getStringArray(R.array.states);

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems(some_array);
        spinner.setSelectedIndex(107);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
              //  Snackbar.make(View,item+"  "+ id, Snackbar.LENGTH_LONG).show();

                city = item;
            }
        });
        spinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override public void onNothingSelected(MaterialSpinner spinner) {
              //  Snackbar.make(spinner, "Nothing selected", Snackbar.LENGTH_LONG).show();


                spinner.setSelectedIndex(0);

                city="";
            }
        });
        
    }

    @Override
    public  void  onBackPressed(){


    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        // all touch events close the keyboard before they are processed except EditText instances.
        // if focus is an EditText we need to check, if the touchevent was inside the focus editTexts
        final View currentFocus = getCurrentFocus();
        if (!(currentFocus instanceof EditText) || !isTouchInsideView(ev, currentFocus)) {
            ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        return super.dispatchTouchEvent(ev);
    }

    private boolean isTouchInsideView(final MotionEvent ev, final View currentFocus) {
        final int[] loc = new int[2];
        currentFocus.getLocationOnScreen(loc);
        return ev.getRawX() > loc[0] && ev.getRawY() > loc[1] && ev.getRawX() < (loc[0] + currentFocus.getWidth())
                && ev.getRawY() < (loc[1] + currentFocus.getHeight());
    }

    private  void  urlPrivacy() {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_PRIVACY));
        startActivity(browserIntent);

    }


    @Override
    public void completeName() {


        Toast.makeText(getApplicationContext(),R.string.check_name,Toast.LENGTH_LONG).show();

    }

    @Override
    public void completeSurname() {

        Toast.makeText(getApplicationContext(),R.string.check_surname,Toast.LENGTH_LONG).show();

    }

    @Override
    public void completeEmail() {

        Toast.makeText(getApplicationContext(),R.string.check_email,Toast.LENGTH_LONG).show();

    }

    @Override
    public void completePassword() {

        Toast.makeText(getApplicationContext(),R.string.check_password,Toast.LENGTH_LONG).show();

    }

    @Override
    public void completeCity() {

        Toast.makeText(getApplicationContext(),R.string.check_state,Toast.LENGTH_LONG).show();

    }

    @Override
    public void completePhone() {

        Toast.makeText(getApplicationContext(),R.string.check_phone,Toast.LENGTH_LONG).show();
    }


    @Override
    public void succes() {

        //Toast.makeText(getApplicationContext(),"OK OK OK ",Toast.LENGTH_LONG).show();

    }
}

