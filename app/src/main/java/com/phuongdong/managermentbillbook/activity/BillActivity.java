package com.phuongdong.managermentbillbook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.phuongdong.managermentbillbook.R;

import java.util.ArrayList;
import java.util.List;

public class BillActivity extends AppCompatActivity {

    TextView textTitle, textInformationBill, textInformationStatistical, textNameCustomer, textNumberBook,
             textMonney, textDisplayMonney, textTotalCustomer, textTotalCustomerVip, textTotalRevenue, textFooter;

    EditText editNameCustomer, editNumberBook, editTotalCustomer, editTotalCustomerVip, editTotalRevenue;

    CheckBox checkCustomerVip;

    Button buttonPaypal, buttonContinue, buttonStatistical;

    ImageButton imagebuttonExit;

    final int PRICE_BOOK = 20000;
    List<Bill> listBill = new ArrayList<Bill>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        init();
    }

    public void init(){

        // TextView
        textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle.setText(R.string.title);
        textInformationBill = (TextView) findViewById(R.id.textInformationBill);
        textInformationBill.setText(R.string.information_bill);
        textInformationStatistical = (TextView) findViewById(R.id.textInformationStatistical);
        textInformationStatistical.setText(R.string.information_statistical);
        textNameCustomer = (TextView) findViewById(R.id.textNameCustomer);
        textNameCustomer.setText(R.string.name_customer);
        textNumberBook = (TextView) findViewById(R.id.textNumberBook);
        textNumberBook.setText(R.string.number_book);
        textMonney = (TextView) findViewById(R.id.textMonney);
        textMonney.setText(R.string.monney);
        textDisplayMonney = (TextView) findViewById(R.id.textDisplayMonney);
        textTotalCustomer = (TextView) findViewById(R.id.textTotalCustomer);
        textTotalCustomer.setText(R.string.total_customer);
        textTotalCustomerVip = (TextView) findViewById(R.id.textTotalCustomerVip);
        textTotalCustomerVip.setText(R.string.total_customer_vip);
        textTotalRevenue = (TextView) findViewById(R.id.textTotalRevenue);
        textTotalRevenue.setText(R.string.total_revenue);
        textFooter = (TextView) findViewById(R.id.textFooter);

        // EditText
        editNameCustomer = (EditText) findViewById(R.id.editNameCustomer);
        editNumberBook = (EditText) findViewById(R.id.editNumberBook);
        editTotalCustomer = (EditText) findViewById(R.id.editTotalCustomer);
        editTotalCustomerVip = (EditText) findViewById(R.id.editTotalCustomerVip);
        editTotalRevenue = (EditText) findViewById(R.id.editTotalRevenue);

        // Checkbox

        checkCustomerVip = (CheckBox) findViewById(R.id.checkCustomerVip);
        checkCustomerVip.setText(R.string.check_customer_vip);

        // Button
        buttonPaypal = (Button) findViewById(R.id.buttonPaypal);
        buttonPaypal.setText(R.string.button_paypal);
        buttonPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paypalOnclick();
            }
        });
        buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonContinue.setText(R.string.button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continueOnlick();
            }
        });
        buttonStatistical = (Button) findViewById(R.id.buttonStatistical);
        buttonStatistical.setText(R.string.button_revenue);
        buttonStatistical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statisticalOnclick();
            }
        });

        // ImageButton
        imagebuttonExit = (ImageButton) findViewById(R.id.imagebuttonExit);
        imagebuttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void paypalOnclick(){
        int monney = Integer.parseInt(editNumberBook.getText().toString()) * PRICE_BOOK;
        if(checkCustomerVip.isChecked()) {
            textDisplayMonney.setText(String.valueOf(monney * 0.9));
        }else{
            textDisplayMonney.setText(String.valueOf(monney));
        }
        Bill b = new Bill();
        b.setCustomerName(editNameCustomer.getText().toString());
        b.setNumberBook(Integer.parseInt(editNumberBook.getText().toString()));
        b.setCheckCustomerVip(checkCustomerVip.isChecked());
        listBill.add(b);
    }

    public void continueOnlick(){
        editNameCustomer.setText(String.valueOf(""));
        editNumberBook.setText(String.valueOf(""));
        textDisplayMonney.setText(String.valueOf(""));
        editNameCustomer.requestFocus();
    }

    public void statisticalOnclick(){
        List<Bill> listCustomerVip = new ArrayList<Bill>();
        List<Bill> listCustomer = new ArrayList<Bill>();
        for (Bill b:listBill) {
            if(b.isCheckCustomerVip()){
                listCustomerVip.add(b);
            }else{
                listCustomer.add(b);
            }
        }
        int numberBook = 0;
        int numberBookVip = 0;
        for (Bill b:listCustomer) {
            numberBook += b.getNumberBook();
        }
        for (Bill b:listCustomerVip) {
            numberBookVip += b.getNumberBook();
        }
        editTotalCustomer.setText(String.valueOf(listCustomer.size()));
        editTotalCustomerVip.setText(String.valueOf(listCustomerVip.size()));
        double monneySaleOff = (numberBook * PRICE_BOOK) + ((numberBookVip * PRICE_BOOK) * 0.9);
        editTotalRevenue.setText(String.valueOf(monneySaleOff));
    }
}
