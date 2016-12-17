package com.shizy.androidsample.ui.refresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.shizy.androidsample.R;

/**
 * Created by shizy on 2016/12/17.
 */

public class SwipeRefreshActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_refresh);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(SwipeRefreshActivity.class.getSimpleName());
		setSupportActionBar(toolbar);
	}
}
