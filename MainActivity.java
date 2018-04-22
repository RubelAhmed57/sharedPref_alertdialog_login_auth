package com.example.rubel.teammate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView)findViewById(R.id.welcomeText);
        String phone = utils.getPreference(getApplicationContext(),"phone");
        String pass = utils.getPreference(getApplicationContext(),"password");

        if(null != phone){

            tv.setText("Number "+phone+ "is being verified...");
        }
        else
        {
            showLoginDialog(tv);
        }
    }


    protected void showLoginDialog(final TextView v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.login, null))

                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Dialog f = (Dialog) dialog;
                        EditText uName, passWord;
                        uName = (EditText) f.findViewById(R.id.phone);
                        passWord = (EditText) f.findViewById(R.id.password);

                        utils.savePreference(getApplicationContext(),"phone",uName.getText().toString());
                        utils.savePreference(getApplicationContext(),"password",passWord.getText().toString());

                        v.setText("Number "+uName.getText().toString());

                        Log.i("user pass", uName.getText().toString() + " " + passWord.getText().toString());
            /* STOP */

//                        if(the_view.getSocketTask().isConnected) {
//                            the_view.getSocketTask().send_command("LOGIN ");
//                        } else {
//                            showToast("Not connected!");
//                        }
                    }
                })
                .setNegativeButton("cancel",  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

}
