package com.nickel.android.cloudmemo.network;

import android.content.Context;

import com.nickel.android.cloudmemo.BuildConfig;
import com.nickel.android.cloudmemo.utils.OkHttpClientUtil;
import com.nickel.android.cloudmemo.utils.Url;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.Client;

/**
 * Created by shingo on 2015/06/27.
 */
public final class ApiClient {

	// API KEY
	private static final String API_KEY = "test";
	// tag
	private static final String TAG = "ApiClient";
	// クライアント
	private static Client sClient;
	// シングルトンインスタンス
	private static ApiClient sInstance;
	private final Context mContext;

	/**
	 * コンストラクタ
	 *
	 * @param context
	 */
	private ApiClient(final Context context) {
		sClient = OkHttpClientUtil.getClient();
		this.mContext = context;
	}

	/**
	 * インスタンスを取得する
	 *
	 * @param context
	 * @return
	 */
	public static ApiClient getInstance(final Context context) {
		if (sInstance == null) {
			sInstance = new ApiClient(context);
		}
		return sInstance;
	}

	/**
	 * クライアントのサービスをインジェクションするためのアダプターを取得する
	 *
	 * @return
	 */
	public RestAdapter setupRestAdapter() {
		final RestAdapter.Builder builder = new RestAdapter.Builder()
				.setEndpoint(Url.API_HOST).setClient(sClient);
		if (BuildConfig.DEBUG) {
			builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("API tag"));
		}
		return builder.build();
	}


}
