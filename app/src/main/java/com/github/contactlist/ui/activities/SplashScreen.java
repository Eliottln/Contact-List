package com.github.contactlist.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.github.contactlist.async.AsyncParse;
import com.github.contactlist.model.Contact;
import java.util.ArrayList;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isNetworkConnected()) {
            Intent listActivity = new Intent(SplashScreen.this, ListActivity.class);

            ArrayList<Contact> contactArrayList = new ArrayList<>();

            AsyncParse task = new AsyncParse(output -> {
                listActivity.putExtra("list", contactArrayList);
                startActivity(listActivity);
                finish();
            });
            task.execute(contactArrayList, this);
        }
        else{
            startActivity(new Intent(SplashScreen.this, NoConnectionActivity.class));
            finish();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
