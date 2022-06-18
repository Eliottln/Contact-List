package com.github.contactlist.async;
import android.content.Context;
import android.os.AsyncTask;

import com.github.contactlist.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AsyncParse extends AsyncTask {

    private final Callback callback;

    public AsyncParse(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        ArrayList<Contact> contactArrayList = (ArrayList<Contact>) objects[0];
        Context context = (Context) objects[1];
        String path = "";
        String jsonString ="";

        // Open and read file
        try {
            InputStream is = context.getAssets().open("technical_test");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        // Parse JSON
        try {
            JSONObject jObject = new JSONObject(jsonString);
            JSONArray jArray = jObject.getJSONArray("items");
            for (int i=0; i<jArray.length(); i++) {
                JSONObject contactObj = jArray.getJSONObject(i);

                int age = contactObj.optInt("age");
                String name = contactObj.optString("name");
                String surname = contactObj.optString("surname");
                String fullName = contactObj.optString("fullName");
                String email = contactObj.optString("email");
                String photo = contactObj.optString("photo");

                contactArrayList.add(new Contact(
                        age,
                        name,
                        surname,
                        fullName,
                        email,
                        photo));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



        return "Finish";
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        callback.processFinish((String) o);
    }
}
