package com.example.examentema7parte2jorgedcm.ManejoDatos;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContactosProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.examentema7parte2jorgedcm";
    private static final String URI = "content://" + AUTHORITY + "/Contactos";
    public static final Uri CONTENT_URI = Uri.parse(URI);

    private static final int CONTACTOS = 1;
    private static final int CONTACTOS_ID = 2;
    private static final UriMatcher URI_MATCHER;

    static{
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY,"Contactos",CONTACTOS);
        URI_MATCHER.addURI(AUTHORITY,"Contactos/#",CONTACTOS_ID);
    }

    public static final class Contactos implements BaseColumns {

        public Contactos() {}

        public static final String COL_NOMBRE = "nombre";
        public static final String COL_TELEFONO = "telefono";
        public static final String COL_PERSONAJE = "personaje";
    }

    private BBDD bbddContactos;

    private static final String BD_NOMBRE = "DBContactos";
    private static final int BD_VERSION = 1;
    private static final String TABLA_CONTACTOS = "Contactos";

    @Override
    public boolean onCreate() {
        bbddContactos = new BBDD(getContext(),BD_NOMBRE, null, BD_VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String where = selection;
        if (URI_MATCHER.match(uri)==CONTACTOS_ID){
            where = "_id=" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = bbddContactos.getWritableDatabase();
        Cursor c = db.query(TABLA_CONTACTOS, projection, where, selectionArgs, null, null, sortOrder);

        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        int match = URI_MATCHER.match(uri);

        switch (match) {
            case CONTACTOS:
                return "vmd.android.cursor.dir/vmd.com.example.Contactos";
            case CONTACTOS_ID:
                return "vmd.android.cursor.item/vmd.com.example.Contactos";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long regId;

        SQLiteDatabase db = bbddContactos.getWritableDatabase();
        regId = db.insert(TABLA_CONTACTOS, null, values);
        Uri newUri = ContentUris.withAppendedId(CONTENT_URI,regId);
        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        String where = selection;
        if (URI_MATCHER.match(uri)==CONTACTOS_ID){
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = bbddContactos.getWritableDatabase();
        cont = db.delete(TABLA_CONTACTOS,where,selectionArgs);

        return cont;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;

        String where = selection;
        if (URI_MATCHER.match(uri)==CONTACTOS_ID){
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = bbddContactos.getWritableDatabase();
        cont = db.update(TABLA_CONTACTOS,values,where,selectionArgs);

        return cont;
    }
    public ContactosProvider() {}
}
