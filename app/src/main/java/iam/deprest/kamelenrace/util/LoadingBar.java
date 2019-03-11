package iam.deprest.kamelenrace.util;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.util.Random;

public class LoadingBar extends AsyncTask<Void, Integer, Void> {

    private ProgressBar pb;

    public LoadingBar(ProgressBar pb){
        this.pb = pb;
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i <= 20; i++){
            try {
                int randomGetal = (int)(Math.random()*50);
                Thread.sleep(randomGetal);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        for (Integer i : values){
            pb.setProgress(i);
        }
    }
}
