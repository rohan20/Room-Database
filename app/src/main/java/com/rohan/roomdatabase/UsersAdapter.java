package com.rohan.roomdatabase;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohan.roomdatabase.R;
import com.rohan.roomdatabase.User;
import com.rohan.roomdatabase.databinding.ItemUserBinding;

import java.util.List;

/**
 * Created by rohan on 05/01/18.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {
    
    private final Context context;
    private List<User> items;

    public UsersAdapter(List<User> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {

        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        return new UsersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        User item = items.get(position);
        //TODO Fill in your logic for binding the view.
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }
}