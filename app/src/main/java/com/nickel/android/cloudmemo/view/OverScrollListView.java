package com.nickel.android.cloudmemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * オーバースクロールするListView
 * Created by shingo on 2015/06/27.
 */
public class OverScrollListView extends ListView {

	public OverScrollListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOverScrollMode(OVER_SCROLL_ALWAYS);
	}
}
