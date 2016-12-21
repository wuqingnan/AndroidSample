package com.shizy.androidsample.ui.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shizy.androidsample.R;
import com.shizy.androidsample.service.SampleJobService;

public class JobSchedulerActivity extends AppCompatActivity {

	private static final String TAG = JobSchedulerActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_job_scheduler);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void startJob(View view) {
		JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

		JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this, SampleJobService.class));
		builder.setPeriodic(5000);
		builder.setPersisted(true);
		//builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);

		if (scheduler.schedule(builder.build()) == JobScheduler.RESULT_FAILURE) {
			Log.d(TAG, "JobScheduler.RESULT_FAILURE");
		}
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void stopJob(View view) {
		JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
		scheduler.cancelAll();
	}

}
