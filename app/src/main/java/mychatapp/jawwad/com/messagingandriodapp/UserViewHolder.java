package mychatapp.jawwad.com.messagingandriodapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Jawwad on 18/08/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    public View userView;

    public UserViewHolder(View itemView) {
        super(itemView);
        userView = itemView;
    }

    public void setDisplayName(String name) {
        TextView userNameView = (TextView) userView.findViewById(R.id.username);
        userNameView.setText(name);
    }

    public void setUserStatus(String status) {
        TextView userStatusView = (TextView) userView.findViewById(R.id.userstatus);
        userStatusView.setText(status);
    }

    public void setUserOnlineStatus(String status) {
        ImageView userOnlineView = (ImageView) userView.findViewById(R.id.imageView);
        if (status.equals("true")) {
            userOnlineView.setVisibility(View.VISIBLE);
        } else {
            userOnlineView.setVisibility(View.INVISIBLE);
        }
    }
}
