package com.rohan.roomdatabase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by rohan on 05/01/18.
 */

class UsersViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private User mUser;

    public UsersViewHolder(View itemView) {
        super(itemView);
    }
}
