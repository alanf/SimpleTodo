package com.professionalaf.alan.simpletodo;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by alan on 8/22/17.
 */

@Table(database = SimpleTodoDatabase.class)
public class TodoItem  extends BaseModel{
    @Column
    @PrimaryKey(autoincrement=true)
    int id;

    @Column
    String description;

    public void setDescription(String description) {
        this.description = description;
    }
}
