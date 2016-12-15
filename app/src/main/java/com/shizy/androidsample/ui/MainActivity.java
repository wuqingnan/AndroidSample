package com.shizy.androidsample.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.shizy.androidsample.R;
import com.shizy.androidsample.utils.AppUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);

		List<ActivityInfo> data = AppUtils.listActivities(this);
		String cName = getClass().getName();
		for (ActivityInfo info : data) {
			if (cName.equals(info.name)) {
				data.remove(info);
				break;
			}
		}
		mAdapter = new MainAdapter(data);
		mRecyclerView.setAdapter(mAdapter);
	}
}
