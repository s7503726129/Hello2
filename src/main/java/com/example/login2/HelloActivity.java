package com.example.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    private EditText EditTextnum1;
    private EditText EditTextnum2;
    private TextView TextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        EditTextnum1=findViewById(R.id.TextNUM1);
        EditTextnum2=findViewById(R.id.TextNUM2);
        TextViewResult=findViewById(R.id.textresult);

        //이전 Activity에 보낸 Intent에 속한 bundle 객체를 가져온다.
        Bundle bundle = getIntent().getExtras();
        //Bundle에 포함된 email 값을 가져온다.
        /*String email = bundle.getString("email");
        String password = bundle.getString("password");
        TextViewResult.setText(email);*/
       }
    public void onClick(View view) {
        int num1;
        int num2;
        int result = 0;

        num1 = Integer.parseInt(EditTextnum1.getText().toString());
        num2 = Integer.parseInt(EditTextnum2.getText().toString());

        if(view.getId()== R.id.buttonadd){
            result = num1 + num2;
        }
        else if(view.getId() == R.id.buttonamin){
            result = num1 - num2;
        }
        else if(view.getId() == R.id.buttonmul){
            result = num1 * num2;
        }
        else if(view.getId() == R.id.buttondiv){
            result = num1 / num2;
        }
        String resultStr = Integer.toString(result);
        TextViewResult.setText(resultStr);

        Intent intent = new Intent();

        intent.putExtra("add", result);

        setResult(10, intent);

        finish();
    }
}