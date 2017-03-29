package com.example.btntest;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn_test = (Button) findViewById(R.id.btn_test);
		btn_test.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),TestService.class);
				startService(intent);
			}
		});
		findViewById(R.id.btn_rela).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(getApplicationContext(),TestActivity.class);
//				startActivity(intent);
				HttpUtils utils = new HttpUtils();
				utils.send(HttpMethod.GET, "http://10.0.2.2:8080/zhbj/categories.json", new RequestCallBack<String>() {

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {
						String result = responseInfo.result;
						System.out.println("服务器返回结果："+result);
						
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						System.out.println("服务器返回失败");
					}
				});
			}
		});
	}
	@Override
	protected void onStop() {
//		MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ylzs);
//		mediaPlayer.setLooping(true);
//		mediaPlayer.start();
		super.onStop();
	}
}
