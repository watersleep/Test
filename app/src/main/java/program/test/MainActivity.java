package program.test;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyCheckIntenet myCheckIntenet;
    private RelativeLayout rl;
    private ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        myCheckIntenet = new MyCheckIntenet();
        registerReceiver(myCheckIntenet, filter);
        init();

    }

    private void init() {
        rl = ((RelativeLayout) findViewById(R.id.rl));
        ListView lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list.add("李斯" + i);
        }
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
    }

    public void setShow() {
        rl.setVisibility(View.VISIBLE);
        //设置屏幕不可点击
        rl.setOnClickListener(null);
        rl.setBackgroundColor(getResources().getColor(R.color.gray));
    }

    public void setGone() {
        rl.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myCheckIntenet);
    }
}
