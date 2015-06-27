package com.nickel.android.cloudmemo.network.memo;

import com.nickel.android.cloudmemo.entity.Memo;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by shingo on 2015/06/27.
 */
public interface MemoService {
	@GET("/memos")
	void getMemos(@QueryMap Map<String, String> params, Callback<List<Memo>> cb);
}
