package br.edu.uscs.portalmobile.activitys;

/**
 * Created by Joao on 01/07/13.
 */

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import br.edu.uscs.portalmobile.R;

public class WebViewActivity extends Activity {

	private WebView webView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_layout);

		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.loadUrl("http://www.uscs.edu.br//publico/alun/esqueci.php");

	}

}
