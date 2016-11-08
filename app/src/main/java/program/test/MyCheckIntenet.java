package program.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/8 0008.
 */
public class MyCheckIntenet extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //手机的网络
        NetworkInfo mbNetworkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        //wifi的网络
        NetworkInfo WIFINetworkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        //如果都没有网的时候
        if (!mbNetworkInfo.isConnected() && !WIFINetworkInfo.isConnected()) {
            Toast.makeText(context, "11111", Toast.LENGTH_SHORT).show();
            ((MainActivity) context).setShow();

        } else {
            ((MainActivity) context).setGone();
        }

    }
}
