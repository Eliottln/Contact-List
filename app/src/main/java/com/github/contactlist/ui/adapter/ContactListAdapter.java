package com.github.contactlist.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.contactlist.R;
import com.github.contactlist.model.Contact;
import com.github.contactlist.ui.activities.ListActivity;

import java.util.ArrayList;

public class ContactListAdapter extends BaseAdapter {
    private final ArrayList<Contact> contactArrayList;
    private final Context context;

    public ContactListAdapter(ArrayList<Contact> contactArrayList, Context context) {
        this.contactArrayList = contactArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ConstraintLayout layoutItem;
        LayoutInflater mInflater = LayoutInflater.from(context);

        if (view == null) {
            layoutItem = (ConstraintLayout) mInflater.inflate(R.layout.layout_contact_item, viewGroup, false);
        } else {
            layoutItem = (ConstraintLayout) view;
        }

        ImageView photo = layoutItem.findViewById(R.id.ivAvatar);
        byte[] byteArray = contactArrayList.get(position).getPhoto();
        photo.setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));

        ImageView mail = layoutItem.findViewById(R.id.ivMail);
        mail.setOnClickListener(function -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL , new String[]{contactArrayList.get(position).getEmail()});
            try {
                context.startActivity(Intent.createChooser(i, "Envoyer un email..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(context, "Aucune application de messagerie trouvée", Toast.LENGTH_SHORT).show();
            }
        });

        TextView fullName = layoutItem.findViewById(R.id.tvFullName);
        fullName.setText(contactArrayList.get(position).getName());

        return layoutItem;
    }
}
