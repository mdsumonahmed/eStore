package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AccountSetting extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener{

    private TextView displayChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        displayChoice = findViewById(R.id.text_view_english_id);

        TextView accountInformation = (TextView) findViewById(R.id.text_view_account_information);
        accountInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountSetting.this, AccountInformationSetting.class);
                startActivity(intent);
            }
        });

        TextView addressBook = (TextView) findViewById(R.id.text_view_address_book);
        addressBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountSetting.this, AddressBookSetting.class);
                startActivity(intent);
            }
        });

        TextView message = (TextView) findViewById(R.id.text_view_message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountSetting.this,MessageSetting.class);
                startActivity(intent);
            }
        });

        TextView country = (TextView) findViewById(R.id.text_view_country);
        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountSetting.this,CountrySetting.class);
                startActivity(intent);
            }
        });

        TextView language = (TextView) findViewById(R.id.text_view_language);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment singleChoiceDialog =  new SingleChoiceDialogFragment();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(),"Single Choice Dialog");
            }
        });

        TextView policies = (TextView) findViewById(R.id.text_view_policies);
        policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountSetting.this,PoliciesSetting.class);
                startActivity(intent);
            }
        });

        TextView help = (TextView) findViewById(R.id.text_view_help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AccountSetting.this, "Click Help", Toast.LENGTH_SHORT).show();
            }
        });

        Button logOut = (Button) findViewById(R.id.button_log_out_id);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AccountSetting.this, "Logout CLick", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        displayChoice.setText("" + list[position]);
    }

    @Override
    public void onNegativeButtonClicked() {
        displayChoice.setText("English");
    }
}
