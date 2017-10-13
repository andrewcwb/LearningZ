package com.example.andre.learningz;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.andre.util.Message;

public class LoginSuccessfulActivity extends Activity {

    Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successful);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("LoginSuccessfulActivity.Class");
        actionBar.setDisplayHomeAsUpEnabled(true);

        message = new Message();

        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");

        TextView text = (TextView) findViewById(R.id.textLoginSuccessful);

        text.setText(getResources().getString(R.string.welcome) + " " + nome + ".");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent=new Intent();
            intent.putExtra("MESSAGE",getResources().getString(R.string.successfulReturn));
            setResult(2,intent);
            onBackPressed();  return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
