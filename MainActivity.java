package com.example.user.backwork;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText sec1, sec2;
    int t1, t2;

    class CountTask extends AsyncTask<Integer, Integer, Void>{
        @Override
        protected Void doInBackground(Integer... integers) {
            int sec = integers[0];
            int pause = integers[1];
            for (int i = 0; i < sec; i++){
                try {
                    Thread.sleep(pause);
                    publishProgress(sec - i);
                }
                catch (InterruptedException e){}
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tv.setText("Hello!");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int seconds = values[0];
            tv.setText(seconds + " seconds");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textv);
        sec1 = findViewById(R.id.t1);
        sec2 = findViewById(R.id.t2);

    }

    public void onClick(View v){
        CountTask task = new CountTask();
        t1 = Integer.parseInt(sec1.getText().toString());
        t2 = Integer.parseInt(sec2.getText().toString());
        task.execute(t1, t2);
    }
}
