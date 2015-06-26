package com.nickel.android.cloudmemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nickel.android.cloudmemo.R;
import com.nickel.android.cloudmemo.network.memo.MemoReqest;
import com.nickel.android.cloudmemo.network.memo.MemoResponse;

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

	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		Map<String, String> params = new LinkedHashMap<String, String>();
		MemoReqest.getService(getActivity()).getMemos(params, callback);
		return rootView;
	}

	private final Callback<List<MemoResponse>> callback = new Callback<List<MemoResponse>>() {
		@Override
		public void success(List<MemoResponse> memoResponses, Response response) {
			for (MemoResponse memo : memoResponses) {
			}
		}

		@Override
		public void failure(RetrofitError error) {

		}
	};

}
