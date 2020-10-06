package com.example.login2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.EmailAddress);
        editTextPassword=findViewById(R.id.Password);

        Button button = findViewById(R.id.buttonLogin);
    }

    public void onClickBotton(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        String message = null;
        Intent intent = new Intent(this, HelloActivity.class);
        intent.putExtra("email", editTextEmail.getText().toString());

        if(email.equals(password)){
            message = "로그인 성공";
            //startActivity(intent);
            startActivityForResult(intent, 1);
        }else {
            message = "로그인 실패";
            // Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

    public void onClickCallHello(View view){
        Intent intent = new Intent(this, HelloActivity.class);
        intent.putExtra("email", editTextEmail.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int add = data.getIntExtra("add", -1);
        Toast.makeText(this, " 값 : " + add, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int menuItemId=item.getItemId();

        if(menuItemId == R.id.menu_add){
            //Add 기능호출
        }
        else if(menuItemId == R.id.menu_save){
            //Save 기능 호출
        }
        else if(menuItemId == R.id.menu_hello){
            Intent intent = new Intent(this, HelloActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
