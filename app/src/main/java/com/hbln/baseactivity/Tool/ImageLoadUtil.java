package com.hbln.baseactivity.Tool;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.hbln.baseactivity.R;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * 网络图片请求类
 * Created by lwc on 2015/12/11.
 */
public class ImageLoadUtil {
    private static ImageLoadUtil ourInstance = new ImageLoadUtil();

    public static ImageLoadUtil getInstance() {
        return ourInstance;
    }

    private ImageLoadUtil() {
        imageOptions = new ImageOptions.Builder().setImageScaleType(ImageView.ScaleType.CENTER_CROP).setLoadingDrawableId(R.mipmap.ic_launcher).setFailureDrawableId(R.mipmap.ic_launcher).build();
    }

    ImageOptions imageOptions;

    /**
     * 正常显示图片
     *
     * @param url 图片链接
     * @param imageView 显示图片控件
     */
    public void display(String url, ImageView imageView) {
        // assets file
        //x.image().bind(iv_big_img, "assets://test.gif", imageOptions);

        // local file
        //x.image().bind(iv_big_img, new File("/sdcard/test.gif").toURI().toString(), imageOptions);
        //x.image().bind(iv_big_img, "/sdcard/test.jpg", imageOptions);
        //x.image().bind(iv_big_img, "file:///sdcard/test.gif", imageOptions);
        //x.image().bind(iv_big_img, "file:/sdcard/test.gif", imageOptions);

        x.image().bind(imageView, url, imageOptions);
    }

    /**
     * 正常显示图片
     *
     * @param url 图片链接
     * @param imageView 显示图片控件
     */
    public void displayWithFile(String url, ImageView imageView) {
        x.image().bind(imageView, url, imageOptions);
    }

    /**
     * 显示有进度条的图片
     * @param url 图片链接
     * @param imageView 显示图片控件
     * @param progressBar 图片进度条
     */
    public void displayWithFile(String url, ImageView imageView, final ProgressBar progressBar) {
        progressBar.setProgress(0);
        x.image().bind(imageView, url, imageOptions, new Callback.ProgressCallback<Drawable>() {
            @Override
            public void onWaiting() {
                progressBar.setProgress(0);
            }

            @Override
            public void onStarted() {

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                progressBar.setProgress((int) (current * 100 / total));
            }

            @Override
            public void onSuccess(Drawable result) {
                progressBar.setProgress(100);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 通过图片地址得到图片
     * @param url 图片地址
     * @param callBack 图片回调函数
     */
    public void getDrable(String url, final CallBackDrawble callBack) {
        x.http().post(new RequestParams(url), new Callback.CacheCallback<Drawable>() {
            @Override
            public boolean onCache(Drawable result) {
                callBack.getDrawble(result);
                return false;
            }

            @Override
            public void onSuccess(Drawable result) {
                callBack.getDrawble(result);
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
            }
        });
    }

    public interface CallBackDrawble {
        void getDrawble(Drawable drawable);
        void onError(String reason,int errCode);
    }
}
