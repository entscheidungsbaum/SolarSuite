package com.entscheidungsbaum.android.solarMonitor.datasource;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

/**
 * @author mschlech
 * 
 *         DataBaseHelper
 */

public class DataBaseHelper implements DBConstants {
	private Context context;
	private SQLiteDatabase db;

	private SQLiteStatement insertStmt;

	public DataBaseHelper(Context context) {
		this.context = context;
		SolarOpenHelper soh = new SolarOpenHelper(this.context, "SOLAR_DB", null, DBConstants.DATABASE_VERSION);
		this.db = soh.getWritableDatabase();
		this.insertStmt = this.db.compileStatement(DBConstants.INSERT);
	}

	/**
	 * insert
	 * 
	 * @TODO key value
	 * @param name
	 */
	public long insertInto(String name) {
		this.insertStmt.bindString(1, name);
		return this.insertStmt.executeInsert();
	}

	/**
	 * delete all
	 */
	public void deletAll() {
		this.db.delete(DBConstants.SOLAR_TABLE_NAME, null, null);

	}

	/**
	 * select all statement to retrieve all elements from  the database
	 * @return
	 */
	public List<String> selectAll() {
			      List<String> list = new ArrayList<String>();
			      Cursor cursor = this.db.query(DBConstants.SOLAR_TABLE_NAME, new String[] { "name" },
			        null, null, null, null, "name desc");
			      if (cursor.moveToFirst()) {
			         do {
			            list.add(cursor.getString(0));
			         } while (cursor.moveToNext());
		      }
			      if (cursor != null && !cursor.isClosed()) {
			         cursor.close();
			      }
			      return list;
			   }
}
