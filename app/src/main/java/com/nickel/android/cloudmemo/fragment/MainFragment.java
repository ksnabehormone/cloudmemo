package com.nickel.android.cloudmemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nickel.android.cloudmemo.R;
import com.nickel.android.cloudmemo.adapter.MemoAdapter;
import com.nickel.android.cloudmemo.entity.Memo;
import com.nickel.android.cloudmemo.network.memo.MemoReqest;
import com.nickel.android.cloudmemo.view.OverScrollListView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by shingo on 2015/06/27.
 */
public class MainFragment extends Fragment {

	private OverScrollListView mListView;

	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		mListView = (OverScrollListView) rootView.findViewById(R.id.list_memos);

		Map<String, String> params = new LinkedHashMap<String, String>();
		MemoReqest.getService(getActivity()).getMemos(params, callback);

		return rootView;
	}

	private final Callback<List<Memo>> callback = new Callback<List<Memo>>() {
		@Override
		public void success(List<Memo> memos, Response response) {
			MemoAdapter adapter = new MemoAdapter(getActivity(), memos);
			mListView.setAdapter(adapter);
		}

		@Override
		public void failure(RetrofitError error) {

		}
	};

}
