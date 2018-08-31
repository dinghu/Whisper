package cn.ding.hale.whisper;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.ding.hale.whisper.view.star.StarSkyView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    StarSkyView starSkyView;
    ListView diaryList;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diaryList = findViewById(R.id.diaryList);
        starSkyView = findViewById(R.id.starSkyView);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ArrayList<String> stringActivity = new ArrayList<>();
        stringActivity.add("111");
        stringActivity.add("222");
        stringActivity.add("333");
        stringActivity.add("333");
        stringActivity.add("333");
        stringActivity.add("333");
        stringActivity.add("333");
        stringActivity.add("333");
        stringActivity.add("333");stringActivity.add("333");
        stringActivity.add("333");
        stringActivity.add("333");

        diaryList.setAdapter(new ItemDiaryMainAdapter<>(this,stringActivity));
    }

    @Override
    protected void onPause() {
        super.onPause();
        starSkyView.pauseAnim();
    }

    @Override
    protected void onResume() {
        super.onResume();
        starSkyView.resumeAnim();
    }

}
