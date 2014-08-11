package com.chopitas.boeingairplanes;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
 
public class DisPlayWebPageActivity extends Activity {
 
    WebView webview;
//    ProgressBar progressBar;

 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        
        
 
        Intent in = getIntent();
        String page_url = in.getStringExtra("page_url");
 
        webview = (WebView) findViewById(R.id.webpage);
        
        
//        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        
        
        
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(page_url);
 
        webview.setWebViewClient(new DisPlayWebPageActivityClient());
        
        
/*
        
        String url = page_url;
  		Intent intent0 = new Intent(Intent.ACTION_VIEW);
  		intent0.setData(Uri.parse(url));
  		startActivity(intent0);
  */      
        
        
        final Activity activity = this;

        final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);

        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressDialog.show();
                progressDialog.setProgress(0);
                activity.setProgress(progress * 1000);

                progressDialog.incrementProgressBy(progress);

                if(progress == 100 && progressDialog.isShowing())
                    progressDialog.dismiss();
            }
            
            
        });
        
        
        
        
    }
    
    
     
    
    
 
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
    	
//    	if (keyCode == KeyEvent.KEYCODE_BACK){
            webview.goBack();
//        	webview.destroy();
//    		return(true);
            return true;
        }
       
        
        
        return super.onKeyDown(keyCode, event);
    }
 
    private class DisPlayWebPageActivityClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    
    
 
}