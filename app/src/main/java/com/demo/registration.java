package com.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.model.Login;
import com.demo.model.Registration;
import com.demo.retrofit.APIClient;
import com.demo.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registration extends AppCompatActivity {

    TextView t1, t2, t3, t4;
    EditText e1, e2, e3, e4;
    Button btn_sub1;

    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);

        btn_sub1 = (Button) findViewById(R.id.btn_sub1);

        btn_sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(e1.getText().toString().length()==0 || e2.getText().toString().length()==0
                        || e3.getText().toString().length()<8 || e4.getText().toString().length()!=10 )
                {
                    Toast.makeText(registration.this, "Fill all the details", Toast.LENGTH_SHORT).show();

                }
                else{
                    if(!(isValidEmail(e2.getText().toString())))
                    {
                        Toast.makeText(registration.this, "invalid email", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(registration.this, "registration Successfull", Toast.LENGTH_SHORT).show();

                        register(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),"123456","1");

                    }

                }
            }
        });

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    private boolean click() {
        if (e1.getText().toString().length() == 0) {
            e1.setError("first enter valid name");
            return false;
        }
        if (e2.getText().toString().length() == 0) {
            e2.setError("first enter email");
            return false;

        }
        if (e3.getText().toString().length() == 0) {
            e3.setError("enter minimum 8 digit");
            return false;
        }
        if (e4.getText().toString().length() == 0) {
            e4.setError("enter valid number");
            return false;
        }
        return true;
    }

    public void register(String username, String email, String password, String phone,
                         String device_token, String device_type) {
        {

            Call<Registration> registercall = apiInterface.registerPojoCall(username, email,
                    password, phone, device_token, device_type,1);

            registercall.enqueue(new Callback<Registration>() {
                @Override
                public void onResponse(Call<Registration> call, Response<Registration> response) {
                    if (response.body().getStatus().equals("success"))
                    {
                        Intent it = new Intent(getApplicationContext(), update.class);
                        it.putExtra("selected_screen","register");
                        startActivity(it);
                    }
                    else
                    {
                        Toast.makeText(registration.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Registration> call, Throwable t)
                {
                    t.getMessage();
                }
            });
        }
    }
}