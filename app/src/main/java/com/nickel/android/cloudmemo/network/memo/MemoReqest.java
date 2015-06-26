package com.nickel.android.cloudmemo.network.memo;

import android.content.Context;

import com.nickel.android.cloudmemo.network.ApiClient;

/**
 * Memoリクエストクラス
 * Created by shingo on 2015/06/27.
 */
public final class MemoReqest {

	public static MemoService getService(final Context context) {
		return ApiClient.getInstance(context).setupRestAdapter().create(MemoService.class);
	}
}
