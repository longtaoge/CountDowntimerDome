package org.xiangbalao.countdowntimerdome;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1;
    private Button mButton2;

    private TextView mTextView;

    private CountDownTimer mTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mTextView = (TextView) findViewById(R.id.textView);
        mButton1 = (Button) findViewById(R.id.button);
        mButton2 = (Button) findViewById(R.id.button2);


        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                if (mTimer == null) {
                    mTimer = new CountDownTimer(50050, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {


                            Log.i("mill", millisUntilFinished + "倒计时");
                            if (millisUntilFinished < 1050) {
                                mTextView.setText("倒计时：" + 0);
                            } else {
                                mTextView.setText("倒计时：" + millisUntilFinished / 1000);
                            }
                        }

                        @Override
                        public void onFinish() {

                            mTextView.setText("倒计时：结束");
                        }
                    };
                }


                mTimer.start();
                break;


            case R.id.button2:

                if (mTimer != null) {
                    mTimer.cancel();
                }


                break;

            default:
                break;


        }
    }
}
