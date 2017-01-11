package demotest.simpllearn.com.windowtest;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    WindowManager wm;

    Button textView;
    public void addView(View v){
          wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        textView = new Button(this);
        textView.setWidth(400);
        textView.setHeight(400);
        textView.setText("Adding Windows");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               wm.removeView(textView);
            }
        });
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);
         params.setTitle("Load Average");



        wm.addView(textView, params);

    }
}
