package com.nickel.android.cloudmemo.utils;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.client.Client;
import retrofit.client.OkClient;

/**
 * OkHttpクライアントUtil
 * Created by shingo on 2015/06/27.
 */
public final class OkHttpClientUtil {

	// タイムアウト
	private static final long CONNECT_TIMEOUT_MILLIS = 15L;
	// 読み込み時間
	private static final long READ_TIME_MILLIS = 20L;

	/**
	 * OkHttpのクライアントオブジェクトを返す
	 * @return
	 */
	public static Client getClient() {
		final OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.SECONDS);
		client.setReadTimeout(READ_TIME_MILLIS, TimeUnit.SECONDS);
		// final File cacheDir = context.getCacheDir();
		// final HttpResponseCache cache = new HttpResponseCache(cacheDir, 10 * 1024 * 1024);
		// client.setResponseCache(cache);
		return new OkClient(client);
	}
}
