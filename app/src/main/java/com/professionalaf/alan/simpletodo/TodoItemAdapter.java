package com.professionalaf.alan.simpletodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alan on 8/22/17.
 */

public class TodoItemAdapter extends ArrayAdapter<TodoItem> {
    private ArrayList<TodoItem> items;

    public TodoItemAdapter(Context context, ArrayList<TodoItem> items) {
        super(context, 0, items);
        this.items = items;
    }

    public TodoItem getItem(int position) {
        return items.get(position);
    }

    public void editItemDescription(int position, String description) {
        TodoItem item = items.get(position);
        item.description = description;
        item.update();

        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        TodoItem toDelete = items.get(position);
        items.remove(position);
        toDelete.delete();

        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView textView = (TextView)convertView;
        TodoItem item = items.get(position);
        if (item == null) {
            textView.setText("");
        } else {
            textView.setText(item.description);
        }

        return convertView;
    }
}
