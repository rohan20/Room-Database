package com.rohan.roomdatabase;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rohan.roomdatabase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        switch (view.getId()) {
            case R.id.b_insert:
                insert();
                break;
        }
    }

    private void insert() {
        User user = new User();
        user.setUserFullName("Lionel Messi");
        user.setUserImage(R.drawable.ic_android_black_24dp);
        user.setUserName("Messi");
        AppController.getDb().userDao().insert(user);

        updateAdapter();
    }

    private void updateAdapter() {

    }
}
