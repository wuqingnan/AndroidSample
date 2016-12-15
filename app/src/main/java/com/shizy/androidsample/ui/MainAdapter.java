package com.shizy.androidsample.ui;

import android.content.pm.ActivityInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shizy.androidsample.R;

import java.util.List;

/**
 * Created by shizy on 2016/12/15.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

	private List<ActivityInfo> mDataList;

	public MainAdapter(List<ActivityInfo> data) {
		mDataList = data;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
		ViewHolder vh = new ViewHolder(tv);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		String cName = mDataList.get(position).name;
		holder.textView.setText(cName.substring(cName.lastIndexOf(".") + 1));
	}

	@Override
	public int getItemCount() {
		return mDataList == null ? 0 : mDataList.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		TextView textView;

		public ViewHolder(TextView tv) {
			super(tv);
			textView = tv;
		}
	}

}
