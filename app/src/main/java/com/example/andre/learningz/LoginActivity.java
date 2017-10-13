package com.example.andre.learningz;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.andre.util.Message;

public class LoginActivity extends Activity {

    Message message;
    int resultCode=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("LoginActivity.Class");
        actionBar.setDisplayHomeAsUpEnabled(true);

        message = new Message();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home) {

            onBackPressed();  return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void onClickButtons(View view){
        if(view.getId()==R.id.btLogin){
            TextView tLogin = (TextView) findViewById(R.id.tLogin);
            TextView tSenha = (TextView) findViewById(R.id.tSenha);
            tLogin.setText("andre");
            tSenha.setText("123");
            String login = tLogin.getText().toString();
            String senha = tSenha.getText().toString();
            if (login.equals("andre") && senha.equals("123")){
                Intent intent = new Intent(getApplicationContext(),LoginSuccessfulActivity.class);
                Bundle params = new Bundle();
                params.putString("nome","André");
                intent.putExtras(params);
                startActivityForResult(intent, this.resultCode);


            }else{
              message.alert(view,R.string.loginFaild);
            }
        }else if (view.getId() == R.id.btCancelar){
            message.alert(view,R.string.loginCanceled);
        }
    }


    //Método que vai pegar o resultado da segunda activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            this.message.alert(this.getApplicationContext(),"ResultCode = " + resultCode + " MESSAGE: " + message);

        }
    }


}
