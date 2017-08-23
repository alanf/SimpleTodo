package com.professionalaf.alan.simpletodo;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by alan on 8/22/17.
 */

@Database(name = SimpleTodoDatabase.NAME, version = SimpleTodoDatabase.VERSION)
public class SimpleTodoDatabase {
    public static final String NAME = "SimpleTodo";

    public static final int VERSION = 1;
}