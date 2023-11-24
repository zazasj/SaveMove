package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NotificationAdapter extends ArrayAdapter<NotificationItem> {
    private Context context;
    private List<NotificationItem> items;

    public NotificationAdapter(Context context, List<NotificationItem> items) {
        super(context, R.layout.list_item_notification, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_notification, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView descriptionTextView = convertView.findViewById(R.id.descriptionTextView);

        NotificationItem item = items.get(position);
        titleTextView.setText(item.getTitle());
        descriptionTextView.setText(item.getDescription());

        return convertView;
    }
}

