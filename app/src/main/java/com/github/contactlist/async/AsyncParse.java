package com.github.contactlist.async;
import android.os.AsyncTask;

public class AsyncParse extends AsyncTask {

    private final Callback callback;

    public AsyncParse(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        // TODO parse json
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        callback.processFinish();
    }
}
