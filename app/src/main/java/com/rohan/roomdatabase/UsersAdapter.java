package com.rohan.roomdatabase;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rohan.roomdatabase.databinding.ItemUserBinding;

import java.util.List;

/**
 * Created by rohan on 05/01/18.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {

    private Context context;
    private List<User> usersList;

    public UsersAdapter(List<User> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        return new UsersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.bindData(user);
    }

    @Override
    public int getItemCount() {
        if (usersList == null) {
            return 0;
        }
        return usersList.size();
    }
}