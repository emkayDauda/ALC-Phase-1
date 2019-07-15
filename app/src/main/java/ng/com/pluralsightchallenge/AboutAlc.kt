package ng.com.pluralsightchallenge

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.net.http.SslError
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.webkit.*
import android.widget.Toast

class AboutAlc : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)

        val webView: WebView = findViewById(R.id.aboutAlcWebView)
        progressDialog = ProgressDialog(this)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object: WebViewClient(){


            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Toast.makeText(this@AboutAlc, "Load finished", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }

            override fun onReceivedHttpError(view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) {
                super.onReceivedHttpError(view, request, errorResponse)
                Toast.makeText(this@AboutAlc, errorResponse?.toString()?: "https://andela.com/alc/ Error", Toast.LENGTH_LONG).show()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressDialog.setTitle("Page Loading")
                progressDialog.setMessage("Loading Alc website")
                progressDialog.show()
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
//                super.onReceivedSslError(view, handler, error)
                handler?.proceed()
            }

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
            }
        }

        webView.loadUrl("https://andela.com/alc/")

    }
}
