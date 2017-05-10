package com.app.zes.gotoclass.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.app.zes.gotoclass.R;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.utils.Utils;

import butterknife.Bind;

/**
 * Created by zes on 17-3-18 10:09
 */
public class InteractFragment extends BaseFragment {
    @Bind(R.id.wb_interact)
    WebView wbInteract;
    //    @Bind(R.id.interact_rv)
//    RecyclerView interactRv;
//
//    private InteractAdapter adapter;
//    private List<String> mDatas;
    private int lessonId;
    private int courseId;

    public static InteractFragment newInstance(int lessonId, int courseId) {
        InteractFragment f = new InteractFragment();
        Bundle args = new Bundle();
        args.putInt("lessonId", lessonId);
        args.putInt("courseId", courseId);
        f.setArguments(args);
        return f;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_interact;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {

        lessonId = getArguments().getInt("lessonId");
        courseId = getArguments().getInt("courseId");

        Log.e("lessonId", lessonId + "");
        Log.e("courseId", courseId + "");
        WebSettings webSettings = wbInteract.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        String url = "http://119.29.186.230/education/APPcourseInteraction.html?" + "courseId=" + courseId + "&" + Utils.getSpUtils().getString("token");
        wbInteract.loadUrl(url);
        wbInteract.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        wbInteract.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    if (wbInteract != null && wbInteract.canGoBack()) {
                        wbInteract.goBack();
                    }
                    return true;
                }
                return false;
            }
        });
//        initData();
//        adapter = new InteractAdapter(getActivity(), mDatas, R.layout.item_interact);
//        interactRv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        interactRv.addItemDecoration(new DividerItemDecoration(getActivity(),
//                DividerItemDecoration.VERTICAL_LIST));
//        interactRv.setAdapter(adapter);
    }


//    protected void initData() {
//        mDatas = new ArrayList<>();
//        for (int i = 'A'; i < 'z'; i++) {
//            mDatas.add("" + (char) i);
//        }
//    }


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
