package com.github.contactlist.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.contactlist.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}