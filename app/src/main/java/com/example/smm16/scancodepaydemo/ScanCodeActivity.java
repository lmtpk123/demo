package com.example.smm16.scancodepaydemo;

import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.mylhyl.zxing.scanner.OnScannerCompletionListener;
import com.mylhyl.zxing.scanner.ScannerView;
import com.mylhyl.zxing.scanner.camera.CameraManager;

import static com.google.zxing.client.result.ParsedResultType.URI;

public class ScanCodeActivity extends AppCompatActivity {
    private ScannerView scannerView;
    private TextView open;
    private boolean isOPen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);
        initweightView();
    }

    private void initweightView() {
        scannerView = findViewById(R.id.scanView);
        open = findViewById(R.id.tv_openLight);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ScanCodeActivity.this, "打开闪光灯", Toast.LENGTH_LONG).show();
                if (isOPen) {
                    Toast.makeText(ScanCodeActivity.this, "打开闪光灯1", Toast.LENGTH_LONG).show();
                    scannerView.toggleLight(true);
                    isOPen = false;
                } else {
                    Toast.makeText(ScanCodeActivity.this, "打开闪光灯2", Toast.LENGTH_LONG).show();
                    scannerView.toggleLight(false);
                    isOPen = true;
                }
            }
        });
        scannerView.setOnScannerCompletionListener(new OnScannerCompletionListener() {
            @Override
            public void onScannerCompletion(Result result, ParsedResult parsedResult, Bitmap bitmap) {
                Toast.makeText(ScanCodeActivity.this, "扫描完成", Toast.LENGTH_LONG).show();
                Log.e("扫描结果", "result:==" + result.getText() + "parsedResult:type==" + parsedResult.getType() + "文本：==" + parsedResult.toString() + ":==" + parsedResult.getDisplayResult() + "bitmap:==" + (bitmap == null));
                if (result != null) {
                    if (URI.equals(parsedResult.getType())) {
                        Intent openScan = new Intent();
                        openScan.setAction(Intent.ACTION_VIEW);
                        Uri uri = Uri.parse(result.getText().toString());
                        openScan.setData(uri);
                        startActivity(openScan);
                    }
                    open.setText("");
                    open.setText(result.getText().toString());
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (scannerView != null)
            scannerView.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (scannerView != null)
            scannerView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("扫描结果2", "requestCode:==" + requestCode+ "resultCode:type==" + resultCode + "data：==" + (data==null));
        Log.e("扫描结果3",  "data：==" + data.getDataString()+"type:="+data.getType()+"Uri:=="+data.getData());

    }
}
