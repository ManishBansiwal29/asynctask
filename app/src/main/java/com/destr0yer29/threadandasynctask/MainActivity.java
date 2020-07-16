package com.destr0yer29.threadandasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView txt;
    private AsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Thread thread =  new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //code u want to run
//            }
//        });
//        thread.run(); // to create a background thread
        txt=findViewById(R.id.txt);

//        ExampleAsyncTask exampleAsyncTask = new ExampleAsyncTask();
//        exampleAsyncTask.execute(10);

        asyncTask = new SecondAsyncTask();
        asyncTask.execute(10);
    }

    //to avoid the memory leak when the application is closed.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != asyncTask){
            if (!asyncTask.isCancelled()){
                asyncTask.cancel(true);
            }
        }
    }

    private class SecondAsyncTask extends AsyncTask<Integer,Integer,String>{
        @Override
        protected String doInBackground(Integer... integers) {
            for (int i=0;i<integers[0];i++){
                publishProgress(i);
                SystemClock.sleep(2000);
            }
            return "Done";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values   );
            txt.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txt.setText(s);
        }
    }
}
