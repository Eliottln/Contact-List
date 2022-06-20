package com.github.contactlist.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.contactlist.R;
import com.github.contactlist.model.Contact;
import com.github.contactlist.ui.adapter.ContactListAdapter;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<Contact> contactArrayList;
    private ContactListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent splash = getIntent();
        this.contactArrayList = (ArrayList<Contact>) splash.getSerializableExtra("list");
        this.adapter = new ContactListAdapter(contactArrayList, this);

        ListView lvContact = findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener((adapterView, view, position, l) -> {
            // TODO start new activity for details
        });

        adapter.notifyDataSetChanged();
    }
}