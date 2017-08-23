package com.professionalaf.alan.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //ArrayList<TodoItem> items;
    TodoItemAdapter itemsAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView)findViewById(R.id.lvlItems);
        ArrayList<TodoItem> items = new ArrayList<>(SQLite.select().from(TodoItem.class).queryList());
        itemsAdapter = new TodoItemAdapter(this, items);
        lvItems.setAdapter(itemsAdapter);

        setupListViewListeners();
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();

        TodoItem item = new TodoItem();
        item.setDescription(itemText);
        itemsAdapter.add(item);
        item.save();

        etNewItem.setText("");
    }

    private void setupListViewListeners() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        itemsAdapter.deleteItem(pos);

                        return true;
                    }
                }
        );

        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View item, int pos, long id) {
                        Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                        i.putExtra(EditItemActivity.ItemTextKey, itemsAdapter.getItem(pos).description);
                        i.putExtra(EditItemActivity.ItemPositionKey, pos);

                        startActivityForResult(i, EditItemActivity.EditItemSuccessCode);
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EditItemActivity.EditItemSuccessCode) {
            int position = data.getIntExtra(EditItemActivity.ItemPositionKey, -1);
            if (position >= 0) {
                String updatedDescription = data.getStringExtra(EditItemActivity.ItemTextKey);
                itemsAdapter.editItemDescription(position, updatedDescription);
            }
        }
    }
}
