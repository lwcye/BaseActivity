package com.hbln.baseactivity.FrameWork;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 基础控制器类
 * Created by lwc on 2015/12/24.
 */
public abstract class BaseController {
    public BaseController() {
    }

    /**
     * 获得网络参数
     *
     * @param url 网络请求地址
     * @return RequestParams
     */
    public static RequestParams getRequestParams(String url) {
        return new RequestParams(url);
    }

    /**
     * 网络请求方法
     *
     * @param params   请求参数
     * @param callBack 请求回调函数
     */
    public void Request(RequestParams params, final RequestCallBack callBack) {
        params.setConnectTimeout(1000 * 10);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                if (result == null || result.equals("")) {
                    callBack.onError("没有获得数据", 0);
                    return;
                }
                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (ex instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) ex;
                    callBack.onError(httpEx.getMessage(), httpEx.getCode());
                } else { // 其他错误
                    callBack.onError("网络错误", 0);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                callBack.onFinished();
            }
        });
    }


    public interface RequestCallBack {
        void onSuccess(String result);

        void onFinished();

        void onError(String reason, int code);
    }
}
