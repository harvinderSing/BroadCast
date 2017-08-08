package harvinder.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView,textView2;
    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);
        textView2= (TextView) findViewById(R.id.textView2);


        IntentFilter intentFilter = new IntentFilter(
                "harvinder.broadcast.MAIN");

        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                //extract our message from intent
                String msg_for_me = intent.getStringExtra("some_msg");
                //log our message value
                Log.i("hello", msg_for_me);

            }
        };
        //registering our receiver
        this.registerReceiver(mReceiver, intentFilter);
        
        startService(new Intent(MainActivity.this,FirstService.class));

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        /*IntentFilter intentFilter = new IntentFilter(
                "harvinder.broadcast.MAIN");

        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                //extract our message from intent
                String msg_for_me = intent.getStringExtra("some_msg");
                //log our message value
                Log.i("InchooTutorial", msg_for_me);

            }
        };
        //registering our receiver
        this.registerReceiver(mReceiver, intentFilter);*/
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        //unregister our receiver
        this.unregisterReceiver(this.mReceiver);
    }
}
