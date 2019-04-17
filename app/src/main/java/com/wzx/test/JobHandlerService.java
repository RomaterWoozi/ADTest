package com.wzx.test;

import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * Created By WuZhouXing TestApplication
 * 2019/4/17 17:18
 */
public class JobHandlerService extends JobService {

    @Override
    public void onCreate() {
        super.onCreate();
    }



    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
