package com.example.andre.util;

import android.content.Context;
import android.view.View;
import android.widget.Toast;


/**
 * Created by Andre on 13/10/2017.
 */

public class Message {

    public void alert(View view, String s){
        Toast.makeText(view.getContext(),s,Toast.LENGTH_LONG).show();
    }

    public void alert(View view, int id){
        Toast.makeText(view.getContext(),view.getResources().getString(id),Toast.LENGTH_LONG).show();
    }
    public void alert(Context context, int id){
        Toast.makeText(context, context.getString(id),Toast.LENGTH_LONG).show();
    }
    public void alert(Context context, String s){
        Toast.makeText(context, s,Toast.LENGTH_LONG).show();
    }
}
