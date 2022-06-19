package com.github.contactlist.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.contactlist.R;
import com.github.contactlist.model.Contact;
import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private final ArrayList<Contact> contactArrayList;
    private final Context context;

    public ListAdapter(ArrayList<Contact> contactArrayList, Context context) {
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
        photo.setImageBitmap(contactArrayList.get(position).getPhoto());

        TextView fullName = layoutItem.findViewById(R.id.tvFullName);
        fullName.setText(contactArrayList.get(position).getName());

        return layoutItem;
    }
}
