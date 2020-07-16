package com.destr0yer29.threadandasynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class ExampleAsyncTask extends AsyncTask<Integer,Void,Void> {
    @Override
    protected Void doInBackground(Integer... integers) {
        for (int i=0;i<integers[0];i++){
            Log.d(TAG , "doInBackground: i was "+ i);
            SystemClock.sleep(2000);
        }
        return null;
    }

}
