package com.app.zes.gotoclass.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.app.zes.gotoclass.App;
import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.utils.Utils;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.utils.MKToast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zes on 17-3-5 22:13
 */
public class SignFragment extends BaseFragment {
    @Bind(R.id.bt_assistant)
    Button btAssistant;
    @Bind(R.id.layout_interval)
    LinearLayout layoutInterval;
    @Bind(R.id.webView)
    WebView webView;
    @Bind(R.id.bt_sign)
    Button btSign;
    @Bind(R.id.et_sign_code)
    EditText etSignCode;
    private String longitude;
    private String latitude;
    //声明AMapLocationClient类对象
//    public AMapLocationClient mLocationClient = null;
//    @Bind(R.id.tv_sign_location)
//    TextView tvSignLocation;
//    //声明定位回调监听器
//    private AMapLocationClientOption locationOption = new AMapLocationClientOption();
//    /**
//     * 定位监听
//     */
//    AMapLocationListener locationListener = loc -> {
//        if (null != loc) {
//            //解析定位结果
//            String result = Utils.getLocationStr(loc);
//            tvSignLocation.setText(result);
//        } else {
//
//        }
//    };

    private AMapLocationClient locationClient = null;


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_assistant_location;
    }

//    /**
//     * 初始化定位
//     *
//     * @author hongming.wang
//     * @since 2.8.0
//     */
//    private void initLocation() {
//        //初始化client
//        mLocationClient = new AMapLocationClient(App.getAppContext());
//        //设置定位参数
//        mLocationClient.setLocationOption(getDefaultOption());
//        // 设置定位监听
//        mLocationClient.setLocationListener(locationListener);
//    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
//        initLocation();
//        startLocation();
        locationClient = new AMapLocationClient(App.getAppContext());

        WebSettings webSettings = webView.getSettings();
        // 允许webview执行javaScript脚本
        webSettings.setJavaScriptEnabled(true);
        // 设置是否允许定位，这里为了使用H5辅助定位，设置为false。
        //设置为true不一定会进行H5辅助定位，设置为true时只有H5定位失败后才会进行辅助定位
        webSettings.setGeolocationEnabled(false);


        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            // 处理javascript中的alert
            public boolean onJsAlert(WebView view, String url, String message,
                                     final JsResult result) {
                return true;
            }

            ;

            // 处理javascript中的confirm
            public boolean onJsConfirm(WebView view, String url,
                                       String message, final JsResult result) {
                return true;
            }

            ;

            // 处理定位权限请求
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin,
                                                           GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }

            @Override
            // 设置网页加载的进度条
            public void onProgressChanged(WebView view, int newProgress) {
                getActivity().getWindow().setFeatureInt(
                        Window.FEATURE_PROGRESS, newProgress * 100);
                super.onProgressChanged(view, newProgress);
            }

            // 设置应用程序的标题title
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        webView.addJavascriptInterface(new InJavaScriptLocalObj(), "control");
        locationClient.setLocationOption(getDefaultOption());
        locationClient.startAssistantLocation();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        locationClient.stopAssistantLocation();

    }

    @OnClick({R.id.bt_assistant, R.id.bt_sign})
    protected void click(View view) {

        switch (view.getId()) {
            case R.id.bt_assistant:
                webView.setVisibility(View.VISIBLE);
                //浏览器定位，加载预置的H5定位页面
                webView.loadUrl(Utils.URL_H5LOCATION);
                break;
            case R.id.bt_sign:
//                if (webView.getVisibility() != View.VISIBLE) {
//                    MKToast.showToast(getActivity(), "请先定位");
//                    break;
//                }
                webView.loadUrl("javascript:showInfoFromJava()");

                break;
        }
    }

    /**
     * 签到
     */
    private void signEvent() {
        String code = etSignCode.getText().toString();
        ApiFactory.attendance(code, longitude, latitude).subscribe(simpleResult -> {
            if (simpleResult != null) {
//                MKToast.showToast(getActivity(), simpleResult.getResult());
                switch (simpleResult.getResult()) {
                    case "CheckInDoesnotOpen":
                        MKToast.showToast(getActivity(), "未到签到时间");
                        break;
                    case "AlreadyCheckIn":
                        MKToast.showToast(getActivity(), "已经签到");
                        break;
                    case "success":
                        MKToast.showToast(getActivity(), "未到签到时间");
                        break;
                    case "Invaild":
                        MKToast.showToast(getActivity(), "输入有误");
                        break;
                    case "FailToSave":
                         break;
                    case "Incorrect":
                        MKToast.showToast(getActivity(), "找不到签到码");
                        break;
                }
            }
        }, throwable -> {

        });
    }


    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private AMapLocationClientOption getDefaultOption() {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //    /**
//     * 开始定位
//     *
//     * @author hongming.wang
//     * @since 2.8.0
//     */
//    private void startLocation() {
//        //根据控件的选择，重新设置定位参数
////        resetOption();
//        // 设置定位参数
//        mLocationClient.setLocationOption(locationOption);
//        // 启动定位
//        mLocationClient.startLocation();
//    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // TODO: inflate a fragment view
//        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        ButterKnife.bind(this, rootView);
//        return rootView;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ButterKnife.unbind(this);
//    }

    public class InJavaScriptLocalObj {
        @JavascriptInterface
        public void getPosition(String lng, String lat) {
//            longitude=l
//            MKToast.showToast(getActivity(), "经度:" + lng + " 纬度:" + lat);
            longitude = lng;
            latitude = lat;
            if (!TextUtils.isEmpty(lng) && !TextUtils.isEmpty(lat)) {
                signEvent();
            } else {
                MKToast.showToast(getActivity(), "定位失败");
            }
        }
    }
}
/**
 * 　　　　　　　　┏┓　　　┏┓
 * 　　　　　　　┏┛┻━━━┛┻┓
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　　┃　＞　　　＜　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃...　⌒　...　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃   神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┗━━━┓
 * 　　　　　　　　　┃　　　　　　　┣┓
 * 　　　　　　　　　┃　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛
 */
