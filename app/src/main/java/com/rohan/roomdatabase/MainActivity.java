package com.rohan.roomdatabase;

import android.databinding.DataBindingUtil;
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

        mUsersList = AppController.getDb().userDao().getAllUsers() == null ?
                new ArrayList<User>() : AppController.getDb().userDao().getAllUsers();

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
        User user = new User();
        user.setUserFullName("Lionel Messi");
        user.setUserImage(R.drawable.ic_android_black_24dp);
        user.setUserName("Messi");

        int userIdAdded = AppController.getDb().userDao().insert(user);
        mUsersList.add(AppController.getDb().userDao().getUser(userIdAdded));

        updateAdapter();
    }

    private void updateAdapter() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();
    }
}
