package com.rohan.roomdatabase;

import android.database.sqlite.SQLiteConstraintException;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rohan.roomdatabase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private UsersAdapter mAdapter;
    private List<User> mUsersList;

    //TODO add delete method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.v("db items count: ", AppController.getInstance(getApplicationContext()).userDao().getAllUsers().size() + "");
                mUsersList = AppController.getInstance(MainActivity.this).userDao().getAllUsers();

                if (mUsersList == null)
                    mUsersList = new ArrayList<>();

                Log.v("size: ", mUsersList.size() + "");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setupRecyclerView();
                    }
                });
            }
        });


    }

    private void setupRecyclerView() {
        mAdapter = new UsersAdapter(mUsersList, this);
        mBinding.rvDbItems.setHasFixedSize(true);
        mBinding.rvDbItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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
        user.setUserId(Integer.parseInt(mBinding.etEnterUserId.getText().toString().trim()));
        user.setUserName(mBinding.etFullname.getText().toString().trim());
        user.setUserFullName(mBinding.etUsername.getText().toString().trim());
        user.setUserImage(R.drawable.ic_android_black_24dp);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    long userIdAdded = AppController.getInstance(MainActivity.this).userDao().insert(user);
                    mUsersList.add(AppController.getInstance(MainActivity.this).userDao().getUser((int) userIdAdded));
                    Log.v("size after adding: ", mUsersList.size() + "");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateAdapter();
                        }
                    });
                } catch (SQLiteConstraintException e) {
                    Log.v("Adding user: ", e.getMessage());
                }

            }
        });

    }

    private void updateAdapter() {
        mAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Count: " + mAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
    }
}
