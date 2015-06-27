package com.nickel.android.cloudmemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nickel.android.cloudmemo.R;
import com.nickel.android.cloudmemo.entity.Memo;

import java.util.List;

/**
 * Created by shingo on 2015/06/27.
 */
public class MemoAdapter extends ArrayAdapter<Memo> {

	public static class ViewHolder {
		public TextView body;

		public ViewHolder(View view) {
			body = (TextView) view.findViewById(R.id.text_body);
		}
	}

	public MemoAdapter(Context context, List<Memo> objects) {
		super(context, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View.inflate(getContext(), R.layout.adapter_memo, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Memo memo = getItem(position);

		holder.body.setText(memo.body);
		Log.d("", "memos:" + memo.body);

		return convertView;
	}
}
