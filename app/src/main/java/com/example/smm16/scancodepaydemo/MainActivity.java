package com.example.smm16.scancodepaydemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.client.result.ParsedResultType;
import com.mylhyl.zxing.scanner.encode.QREncode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ig_showCode, ig_ordinary;
    private TextView tv_show_pay;
    private Bitmap codeBitmap;//生成二维码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWeightView();

    }

    private void initWeightView() {
        findViewById(R.id.btn_productCode).setOnClickListener(this);
        findViewById(R.id.btn_wxpay_code).setOnClickListener(this);
        findViewById(R.id.btn_ylpay_code).setOnClickListener(this);
        findViewById(R.id.btn_zfbpay_code).setOnClickListener(this);
        findViewById(R.id.btn_scan_code).setOnClickListener(this);
        ig_showCode = findViewById(R.id.ig_code);
        ig_ordinary = findViewById(R.id.ig_ybcode);
        tv_show_pay = findViewById(R.id.tv_paytype_show);
    }

    @Override
    public void onClick(View v) {

        OrderBean orderBean = new OrderBean(1, 10001, "魅族手机Mx5", 0.001f);
        switch (v.getId()) {
            case R.id.btn_productCode:
//                //生成文本二维码
//                codeBitmap = new QREncode.Builder(this).setContents("蜜蜂商城上线").setLogoBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round)).build().encodeAsBitmap();
                //生成图文二维码ParsedResultType默认的类型时文本
                codeBitmap = new QREncode.Builder(this).setParsedResultType(ParsedResultType.TEXT).setContents("714353683@qq.com").setLogoBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_404)).build().encodeAsBitmap();
//生成对象二维码
                ig_ordinary.setImageBitmap(codeBitmap);

                break;
            case R.id.btn_wxpay_code:
                OrderPay wxpay = new OrderPay(000001, 0, orderBean);

                break;
            case R.id.btn_ylpay_code:
                OrderPay ylpay = new OrderPay(000001, 2, orderBean);

                break;
            case R.id.btn_zfbpay_code:
                OrderPay zfbpay = new OrderPay(000001, 1, orderBean);

                break;
            case R.id.btn_scan_code:
                startActivity(new Intent(MainActivity.this, ScanCodeActivity.class));
                break;
            default:
                break;
        }
    }
}
