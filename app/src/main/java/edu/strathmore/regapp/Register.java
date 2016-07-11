package edu.strathmore.regapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    private EditText edtFirstName, edtEmail, edtPassword;
    private RadioButton rbMale, rbFemale;
    private Spinner spCountry;
    private Button regButton;

    private String firstName, email, password, gender, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFirstName = (EditText) findViewById(R.id.edt_first_name);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtPassword = (EditText) findViewById(R.id.edit_password);
        rbMale = (RadioButton) findViewById(R.id.rd_male);
        rbFemale = (RadioButton) findViewById(R.id.rd_female);
        spCountry = (Spinner) findViewById(R.id.sp_country);
        regButton = (Button) findViewById(R.id.bt_submit);

        String[] countries = {"KE", "TZ", "UG", "RW"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Register.this, android.R.layout.simple_spinner_item, countries);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spCountry.setAdapter(adapter);

        regButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                firstName = edtFirstName.getText().toString().trim();
                email = edtEmail.getText().toString().trim();
                password = edtPassword.getText().toString().trim();
                if (rbMale.isChecked())
                    gender = "1";
                if (rbFemale.isChecked())
                    gender = "0";
                country = spCountry.getSelectedItem().toString();

                new RegisterTask().execute();
            }
        });
    }

    class RegisterTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids){
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("action","register"));
            nameValuePairs.add(new BasicNameValuePair("first_name",firstName));
            nameValuePairs.add(new BasicNameValuePair("password",password));
            nameValuePairs.add(new BasicNameValuePair("email",email));
            nameValuePairs.add(new BasicNameValuePair("gender",gender));
            nameValuePairs.add(new BasicNameValuePair("country",country));

            HttpRequestHandler requestHandler = new HttpRequestHandler();
            return requestHandler.post(nameValuePairs);
        }

        protected void onPostExecute(String result){
//            UI Thread
            Log.w("RESULT ", result);
        }
    }
}
