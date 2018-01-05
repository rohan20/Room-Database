package com.rohan.roomdatabase;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.rohan.roomdatabase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private UsersAdapter mAdapter;
    private List<User> mUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                mUsersList = AppController.getInstance(MainActivity.this).userDao().getAllUsers() == null ?
                        new ArrayList<User>() : AppController.getInstance(MainActivity.this).userDao().getAllUsers();
            }
        });

        mAdapter = new UsersAdapter(mUsersList, this);
        mBinding.rvDbItems.setAdapter(mAdapter);
    }

    public void buttonClicked(View view) {
        switch (view.getId()) {
            case R.id.b_insert:
                insert();
                break;
        }
    }

    private void insert() {
        final User user = new User();
        user.setUserId(1);
        user.setUserFullName(mBinding.etEnterText.getText().toString().trim());
        user.setUserImage(R.drawable.ic_android_black_24dp);
        user.setUserName(user.getUserFullName().substring(0, 1));

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                long userIdAdded = AppController.getInstance(MainActivity.this).userDao().insert(user);
                mUsersList.add(AppController.getInstance(MainActivity.this).userDao().getUser((int) userIdAdded));
            }
        });

        updateAdapter();
    }

    private void updateAdapter() {
        mAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Count: " + mAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
    }
}
