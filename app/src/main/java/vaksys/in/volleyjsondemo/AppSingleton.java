package vaksys.in.volleyjsondemo;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by dell980 on 4/12/2016.
 */
public class AppSingleton extends Application {

    public static final String TAG = AppSingleton.class.getSimpleName();

    private RequestQueue requestQueue;

    private static AppSingleton appSingleton;

    @Override
    public void onCreate() {
        super.onCreate();
        appSingleton = this;
    }

    public static synchronized AppSingleton getInstance() {
        return appSingleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }
}
