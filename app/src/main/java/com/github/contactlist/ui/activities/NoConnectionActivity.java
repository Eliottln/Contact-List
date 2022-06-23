package com.github.contactlist.ui.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.github.contactlist.R;
import com.github.contactlist.async.AsyncParse;
import com.github.contactlist.model.Contact;

import java.util.ArrayList;

public class NoConnectionActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);

        toast = Toast.makeText(getApplicationContext(), "No connection", Toast.LENGTH_SHORT);

        Button btn = findViewById(R.id.btnWarning);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reload(v);
            }
        });
    }

    public void reload(View view){
        if (isNetworkConnected()){
            Intent listActivity = new Intent(NoConnectionActivity.this, ListActivity.class);

            ArrayList<Contact> contactArrayList = new ArrayList<>();

            AsyncParse task = new AsyncParse(output -> {
                listActivity.putExtra("list", contactArrayList);
                startActivity(listActivity);
                finish();
            });
            task.execute(contactArrayList, this);
        }
        else {
            toast.cancel();
            toast.show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}