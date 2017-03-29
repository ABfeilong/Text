package com.example.btntest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class TestService extends Service {

	private static final String TAG="TestService";
	private String stringExtra;
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind");
		Log.d(TAG, "onBind");
		return null;
	}
	private Handler mHandler = new Handler(){
		public void handleMessage(Message msg) {
			String hha = (String) msg.obj;
			Log.d(TAG, "HANDLER="+hha);
		};
	};
	private String ss;

	@Override
	public void onCreate() {
		System.out.println("onCreate");
		Log.d(TAG, "onCreate");
		Intent intent = new Intent();
		ss = intent.getStringExtra("Test");
		Log.d(TAG, "onCingExtra="+ss);
		super.onCreate();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand");
		stringExtra = intent.getStringExtra("Test");
		Log.d(TAG, "stringExtra="+stringExtra);
		Message msg = new Message();
		msg.obj=stringExtra;
		mHandler.sendMessage(msg);
		return super.onStartCommand(intent, flags, startId);
	}
}
