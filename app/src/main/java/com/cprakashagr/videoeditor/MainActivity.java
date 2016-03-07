package com.cprakashagr.videoeditor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	private String TAG = "TAG VIDEO";
	
	static {
		
		System.loadLibrary("ndkfoo");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final String inFileName = "/storage/emulated/0/CP/festGr.flv";
		final String outFileName = "/storage/emulated/0/CP/festGrCP.mp4";
		
		
		new AsyncTask<String, String, String>(){

			ProgressDialog dialog;

			protected void onPreExecute() {
				Log.d("", "");
				dialog = new ProgressDialog(MainActivity.this);
				dialog.setMessage("Processing, please wait...");
				dialog.setCancelable(false);
				dialog.show();
			}

			@Override
			protected String doInBackground(String... params) {
				Log.d(TAG,getFromNative(inFileName, outFileName));
				return null;
			}

			protected void onPostExecute(String result) {
				if (dialog != null && dialog.isShowing()) {
					dialog.dismiss();
				}

				Log.d(TAG, "Video Processing Done.");
			};

		}.execute();		
	}
	
	public native String getFromNative(String in_fileName, String out_fileName);
}
