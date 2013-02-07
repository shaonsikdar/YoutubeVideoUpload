package com.example.youtubevideoupload;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

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
		
		websiteWebView.setWebChromeClient(new WebChromeClient() {
	        public void onProgressChanged(WebView view, int progress)
	        {
	            MainActivity.this.setTitle("Loading...");
	            MainActivity.this.setProgress(progress * 100);

	            if(progress == 100)
	            	MainActivity.this.setTitle(R.string.app_name);
	        }
	    });
		
		websiteWebView.setWebViewClient(new WebViewClient() {
	        @Override
	        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
	        {
	            // Handle the error
	        }

	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url)
	        {
	            view.loadUrl(url);
	            return true;
	        }
	    });
	     
		websiteWebView.loadUrl("http://www.google.com");
		
//		WebSettings webSettings = websiteWebView.getSettings();
//		webSettings.setJavaScriptEnabled(true);
		
//		String url = "http://www.google.com";
//		shouldOverrideUrlLoading(websiteWebView, url);
		
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