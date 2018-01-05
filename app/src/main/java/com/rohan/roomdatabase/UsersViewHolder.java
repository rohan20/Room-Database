package com.rohan.roomdatabase;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rohan.roomdatabase.databinding.ItemUserBinding;

/**
 * Created by rohan on 05/01/18.
 */

class UsersViewHolder extends RecyclerView.ViewHolder {

    private ItemUserBinding mBinding;

    public UsersViewHolder(ItemUserBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindData(User user) {
        mBinding.setUser(user);

        mBinding.ivUserImage.setImageResource(user.getUserImage());
    }
}
