package iam.deprest.kamelenrace.util;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class progressBarHandler extends Handler {
    private ProgressBar progressBar;

    public progressBarHandler(ProgressBar progressBar){
        this.progressBar = progressBar;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        progressBar.setProgress(msg.arg1);
    }
}
