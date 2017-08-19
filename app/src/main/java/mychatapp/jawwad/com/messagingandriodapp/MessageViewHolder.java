package mychatapp.jawwad.com.messagingandriodapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Jawwad on 19/08/2017.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {
    public TextView messageText;
    public TextView displayName;
    public TextView time;

    public MessageViewHolder(View view) {
        super(view);
        messageText = (TextView) view.findViewById(R.id.messagetext);
        displayName = (TextView) view.findViewById(R.id.displayname);
        time = (TextView) view.findViewById(R.id.timestamp);
    }
}
