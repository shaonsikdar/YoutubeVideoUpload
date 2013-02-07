package com.example.youtubevideoupload;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	WebView websiteWebView;
	Button btnPre,btnNext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	
	public void initView(){
		
		websiteWebView = (WebView) findViewById(R.id.videowebView1);
		
		btnNext = (Button)findViewById(R.id.button2);
		
		btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				googlePing();
				
			}
		});
		
	}
	
	public void googlePing(){
		
		WebSettings webSettings = websiteWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		String url = "http://www.google.com";
		
		shouldOverrideUrlLoading(websiteWebView, url);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
     
		view.loadUrl(url);
        return true;
        
    }

}