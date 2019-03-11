package iam.deprest.kamelenrace;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Message;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import iam.deprest.kamelenrace.util.LoadingBar;
import iam.deprest.kamelenrace.util.progressBarHandler;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbLien, pbKim, pbKamiel;
    private TextView tvWinner, tvTweede, tvDerde;
    private progressBarHandler lienProgressBarHandler, kimProgressBarHandler, kamielProgressBarHandler;
    private ArrayList threads = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbLien = findViewById(R.id.pb_lien);
        pbKim = findViewById(R.id.pb_kim);
        pbKamiel = findViewById(R.id.pb_kamiel);
        tvWinner = findViewById(R.id.tv_winnaar);
        tvTweede = findViewById(R.id.tv_tweede);
        tvDerde = findViewById(R.id.tv_derde);
        lienProgressBarHandler = new progressBarHandler(pbLien);
        kimProgressBarHandler = new progressBarHandler(pbKim);
        kamielProgressBarHandler = new progressBarHandler(pbKamiel);
    }

    public void onStartClickedView (View v){
        Thread lienThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int randomGetal = new Random().nextInt(500)+1;
                for (int i = 0; i<=20; i++){
                    Message progressMessage = new Message();
                    progressMessage.arg1=i;
                    lienProgressBarHandler.sendMessage(progressMessage);

                    try {
                        Thread.sleep(randomGetal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progressMessage.arg1==20){
                        threads.add("Lien");
                    }
                }
            }
        });
        Thread kimThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int randomGetal = new Random().nextInt(500)+1;
                for (int i = 0; i<=20; i++){
                    Message progressMessage = new Message();
                    progressMessage.arg1=i;
                    kimProgressBarHandler.sendMessage(progressMessage);

                    try {
                        Thread.sleep(randomGetal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progressMessage.arg1==20){
                        threads.add("Kim");
                    }
                }
            }
        });
        Thread kamielThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int randomGetal = new Random().nextInt(500)+1;
                for (int i=0; i<=20; i++){
                    Message progressMessage = new Message();
                    progressMessage.arg1=i;
                    kamielProgressBarHandler.sendMessage(progressMessage);

                    try {
                        Thread.sleep(randomGetal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progressMessage.arg1==20){
                        threads.add("Kamiel");
                    }
                }
            }
        });
        lienThread.start();
        kimThread.start();
        kamielThread.start();

        //tvWinner.setText();
        }
    }

    /*public void onStartAsyncClicked(View v){
        LoadingBar loadingBarLien = new LoadingBar(pbLien);
        LoadingBar loadingBarKim = new LoadingBar(pbKim);
        LoadingBar loadingBarKamiel = new LoadingBar(pbKamiel);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
            loadingBarLien.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            loadingBarKim.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            loadingBarKamiel.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }else {
            loadingBarKim.execute();
            loadingBarKamiel.execute();
            loadingBarLien.execute();
        }
    }*/             //Werkt maar niet met 3 bars tegelijk

