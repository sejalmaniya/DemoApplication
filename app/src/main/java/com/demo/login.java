package com.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.model.Login;
import com.demo.model.Registration;
import com.demo.retrofit.APIClient;
import com.demo.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class login extends AppCompatActivity {
    ImageView i1;
    EditText e1, e2;
    TextView t1, t2, t3;
    Button b1;

    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        i1 = (ImageView) findViewById(R.id.i1);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        b1 = (Button) findViewById(R.id.b1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().length() == 0) {
                    e1.setError("Enter name");
                    return;
                }
                if (e2.getText().toString().length() == 0) {
                    e2.setError("Enter Password");
                    return;
                }
                login(e1.getText().toString(),e2.getText().toString(),"1","1");
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), registration.class);
                startActivity(it);
            }
        });
    }

    public void login(String username, String password,String device_id,String device_token) {
        {

            Call<Login> logincall = apiInterface.loginPojoCall(username, password,device_id,device_token);

            logincall.enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    if(response.body().getStatus().equals("success"))
                    {
                        Intent it = new Intent(getApplicationContext(),update.class);
                        it.putExtra("selected_screen","login");
                        startActivity(it);
                    }
                    else
                    {
                        Toast.makeText(login.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    t.getMessage();
                }
            });


        }
    }
}


