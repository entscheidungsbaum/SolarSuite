package com.entscheidungsbaum.android.solarMonitor.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author mschlech
 * 
 *         SolarSQLLiteDatasource
 */

public class SolarOpenHelper extends SQLiteOpenHelper implements DBConstants {

	// public SolarOpenHelper(Context context, String name, CursorFactory
	// factory, int version) {
	// super(context, name, factory, version);
	// }

	public SolarOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + DBConstants.SOLAR_TABLE_NAME + "  (id INTEGER PRIMARY KEY, name TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w("Example", "Upgrading database, this will drop tables and recreate.");
		db.execSQL("DROP TABLE IF EXISTS " + DBConstants.SOLAR_TABLE_NAME);
		onCreate(db);
	}

}
