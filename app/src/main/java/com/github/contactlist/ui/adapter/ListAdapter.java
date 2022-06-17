package com.github.contactlist.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.github.contactlist.model.Contact;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private final ArrayList<Contact> ContactArrayList;
    private final Context context;

    public ListAdapter(ArrayList<Contact> ContactArrayList, Context context) {
        this.ContactArrayList = ContactArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return ContactArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return ContactArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
