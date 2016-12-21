package com.shizy.androidsample.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by shizy on 2016/12/19.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class SampleJobService extends JobService {

	private static final String TAG = SampleJobService.class.getSimpleName();

	@Override
	public boolean onStartJob(JobParameters jobParameters) {
		Log.d(TAG, "onStartJob");
		return false;
	}

	@Override
	public boolean onStopJob(JobParameters jobParameters) {
		Log.d(TAG, "onStartJob");
		return false;
	}

}
