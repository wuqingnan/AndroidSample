package com.shizy.androidsample.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.shizy.androidsample.R;
import com.shizy.androidsample.ui.base.BaseAdapter;
import com.shizy.androidsample.ui.widget.decorator.DividerItemDecoration;
import com.shizy.androidsample.utils.AppUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseAdapter.OnItemClickListener {

	private RecyclerView mRecyclerView;
	private MainAdapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	private List<ActivityInfo> mDataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setSubtitle(R.string.developer);
		setSupportActionBar(toolbar);

		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);

		mDataList = AppUtils.listActivities(this);
		String cName = getClass().getName();
		for (ActivityInfo info : mDataList) {
			if (cName.equals(info.name)) {
				mDataList.remove(info);
				break;
			}
		}
		mAdapter = new MainAdapter(mDataList);
		mAdapter.setOnItemClickListener(this);
		mRecyclerView.setAdapter(mAdapter);
	}

	@Override
	public void onItemClick(int position) {
		ActivityInfo info = mDataList.get(position);
		Intent intent = new Intent();
		intent.setClassName(info.packageName, info.name);
		startActivity(intent);
	}
}
