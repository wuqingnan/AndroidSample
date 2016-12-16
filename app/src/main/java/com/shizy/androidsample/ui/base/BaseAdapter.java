package com.shizy.androidsample.ui.base;

import android.support.v7.widget.RecyclerView;

/**
 * Created by shizy on 2016/12/16.
 */

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

	public interface OnItemClickListener {
		void onItemClick(int position);
	}

	protected OnItemClickListener mOnItemClickListener;

	public OnItemClickListener getOnItemClickListener() {
		return mOnItemClickListener;
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		this.mOnItemClickListener = listener;
	}
}
