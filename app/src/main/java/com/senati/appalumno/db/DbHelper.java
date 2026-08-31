package com.senati.appalumno.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "senati.db";
    // Corregido: Las tablas no llevan extensión .db
    private static final String TABLE_CONTACTOS = "alumnos";

    //Constructor DbHelper
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    //Evento para crear la base de datos y sus tablas
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTOS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "telefono TEXT NOT NULL, " +
                "correo_electronico TEXT)");
    }

    //Evento que se ejecuta cuando cambia la versión de la BD
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Corregido: Espacio después de TABLE y añadido IF EXISTS
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);
    }
}