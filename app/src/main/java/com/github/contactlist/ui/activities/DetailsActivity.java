package com.github.contactlist.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.contactlist.model.Contact;
import com.github.contactlist.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();
        Contact contact = (Contact) i.getSerializableExtra("contact");

        // show all contact's information
        ImageView photo = findViewById(R.id.ivContactAvatar);
        byte[] byteArray = contact.getPhoto();
        photo.setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));

        TextView header = findViewById(R.id.tvNameHeader);
        header.setText(contact.getFullName());

        TextView name = findViewById(R.id.tvNameContent);
        name.setText(contact.getName());

        TextView surname = findViewById(R.id.tvSurnameContent);
        surname.setText(contact.getSurname());

        TextView fullName = findViewById(R.id.tvFullNameContent);
        fullName.setText(contact.getFullName());

        TextView age = findViewById(R.id.tvAgeContent);
        age.setText("" + contact.getAge());

        TextView email = findViewById(R.id.tvMailContent);
        email.setText(contact.getEmail());
    }
}