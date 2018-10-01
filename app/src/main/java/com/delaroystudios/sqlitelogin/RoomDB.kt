package th.ac.up.se.testdb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class RoomDB(private val context: Context, private val year: String, private val month: String, private val day: String, private val defaultCapacity: Int) : SQLiteOpenHelper(context, RoomDB.ConvertToDatabaseName(year, month, day), null, 1) {

    private val TABLE_NAME: String = "ROOM"
    private val CAPACITY: String = "CAPACITY"
    private val CURRENT: String = "CURRENT"
    private val HOUR: String = "HOUR"
    private val MINUTE: String = "MINUTE"

    private var SUB_TABLE_NAME: String = "PERSON"

    private val NAME: String = "NAME"
    private val PHONE: String = "PHONE"
    private val CATEGORY: String = "CATEGORY"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE $TABLE_NAME (_id INTEGER PRIMARY KEY AUTOINCREMENT, $HOUR INTEGER,$MINUTE INTEGER,$CAPACITY INTEGER,$CURRENT INTEGER)")
        db.execSQL("CREATE TABLE $SUB_TABLE_NAME (_id INTEGER PRIMARY KEY AUTOINCREMENT, $HOUR INTEGER,$MINUTE INTEGER, $NAME TEXT,$PHONE TEXT,$CATEGORY INTEGER)")

        db.initMaster()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS $SUB_TABLE_NAME")

        onCreate(db)

    }

    private fun SQLiteDatabase.initMaster() {

        var startHour = 8
        var finishHour = 16

        var count = startHour

        while (count < finishHour) {
            this.insert(count, 0, defaultCapacity, 0)
            this.insert(count, 30, defaultCapacity, 0)
            count += 1
        }
    }

    fun changeCapacity(hour: Int, minute: Int, capacity: Int) {
        thisSqlite().execSQL("UPDATE $TABLE_NAME SET $CAPACITY = $capacity WHERE $HOUR = $hour AND $MINUTE = $minute")
    }

    fun booking(hour: Int, minute: Int, name: String, phone: String, category: Int): Boolean {
        val cursor: Cursor = thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME WHERE $HOUR = $hour AND $MINUTE = $minute", null)


        cursor.moveToFirst()
        val current = cursor.getInt(cursor.getColumnIndex(this@RoomDB.CURRENT))

        return if (isSpace(hour, minute)) {
            thisSqlite().execSQL("UPDATE $TABLE_NAME SET $CURRENT = ${current + 1} WHERE $HOUR = $hour AND $MINUTE = $minute")

            val values = ContentValues()
            values.apply {
                put(HOUR,hour)
                put(MINUTE,minute)
                put(NAME, name)
                put(PHONE, phone)
                put(CATEGORY, category)
            }

            thisSqlite().insert(this.SUB_TABLE_NAME, null, values)

            true
        } else {
            false
        }

    }

    fun isSpace(hour: Int, minute: Int): Boolean {
        val cursor: Cursor = thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME WHERE $HOUR = $hour AND $MINUTE = $minute", null)

        return try {
            var capacity = -1
            var current = -1
            cursor.apply {
                this.moveToFirst()
                current = cursor.getInt(cursor.getColumnIndex(this@RoomDB.CURRENT))
                capacity = cursor.getInt(cursor.getColumnIndex(this@RoomDB.CAPACITY))
            }
            current + 1 <= capacity
        } catch (e: Exception) {
            false
        }

    }

    private fun SQLiteDatabase.insert(hour: Int, minute: Int, capacity: Int, current: Int) {
        this.execSQL("INSERT INTO $TABLE_NAME ($HOUR,$MINUTE,$CAPACITY,$CURRENT) VALUES ($hour,$minute,$capacity,$current)")
    }


    fun asName(name: String): ArrayList<Room> {
        return thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME LEFT JOIN $SUB_TABLE_NAME ON $TABLE_NAME.$HOUR = $SUB_TABLE_NAME.$HOUR AND $TABLE_NAME.$MINUTE = $SUB_TABLE_NAME.$MINUTE WHERE $SUB_TABLE_NAME.$NAME = '$name'", null).getAllRoom()
    }

    fun asPhone(phone: String): ArrayList<Room> {
        return thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME LEFT JOIN $SUB_TABLE_NAME ON $TABLE_NAME.$HOUR = $SUB_TABLE_NAME.$HOUR AND $TABLE_NAME.$MINUTE = $SUB_TABLE_NAME.$MINUTE WHERE $SUB_TABLE_NAME.$PHONE = '$phone'", null).getAllRoom()
    }

    fun asCategory(category: String): ArrayList<Room> {
        return thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME LEFT JOIN $SUB_TABLE_NAME ON $TABLE_NAME.$HOUR = $SUB_TABLE_NAME.$HOUR AND $TABLE_NAME.$MINUTE = $SUB_TABLE_NAME.$MINUTE WHERE $SUB_TABLE_NAME.$CATEGORY = $category", null).getAllRoom()
    }

    fun asAllCategory(category: String): ArrayList<Person> {
        return thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME LEFT JOIN $SUB_TABLE_NAME ON $TABLE_NAME.$HOUR = $SUB_TABLE_NAME.$HOUR AND $TABLE_NAME.$MINUTE = $SUB_TABLE_NAME.$MINUTE WHERE $SUB_TABLE_NAME.$CATEGORY = $category", null).getAllPerson()
    }

    fun asAllRoom(): ArrayList<Room> {
        return thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME", null).getAllRoom()
    }

    fun infoRoom(hour: Int, minute: Int): Room {
        return thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME WHERE $TABLE_NAME.$HOUR = $hour AND $TABLE_NAME.$MINUTE = $minute", null).getAllRoom()[0]
    }

    fun asAllPerson(): ArrayList<Person> {
        return thisSqlite().rawQuery("SELECT * FROM $SUB_TABLE_NAME", null).getAllPerson()
    }

    fun asRoom(hour: Int, minute: Int): ArrayList<Person> {
        return thisSqlite().rawQuery("SELECT * FROM $TABLE_NAME LEFT JOIN $SUB_TABLE_NAME ON $TABLE_NAME.$HOUR = $SUB_TABLE_NAME.$HOUR AND $TABLE_NAME.$MINUTE = $SUB_TABLE_NAME.$MINUTE WHERE $SUB_TABLE_NAME.$HOUR = $hour AND $SUB_TABLE_NAME.$MINUTE = $minute", null).getAllPerson()
    }


    private fun Cursor.getAllRoom(): ArrayList<Room> {
        var data = ArrayList<Room>()
        return try {
            this.apply {
                this.moveToFirst()
                Log.e("COUNT", this.count.toString())
                //Log.e("ID",this.getString(this@RoomDB.ID))
                do {
                    data.add(Room(
                            this.getInt(this@RoomDB.HOUR)
                            , this.getInt(this@RoomDB.MINUTE)
                            , this.getInt(this@RoomDB.CAPACITY)
                            , this.getInt(this@RoomDB.CURRENT)))
                } while (this.moveToNext())
            }
            data
        } catch (e: Exception) {
            ArrayList<Room>()
        }
    }

    private fun Cursor.getAllPerson(): ArrayList<Person> {
        var data = ArrayList<Person>()
        return try {
            this.apply {
                this.moveToFirst()
                do {
                    data.add(Person(this.getString(this@RoomDB.NAME)
                            , this.getString(this@RoomDB.PHONE)
                            , this.getInt(this@RoomDB.CATEGORY)))
                } while (this.moveToNext())
            }
            data
        } catch (e: Exception) {
            ArrayList<Person>()
        }
    }

    private fun Cursor.getInt(id: String): Int {
        return this.getInt(this.getColumnIndex(id))
    }

    private fun Cursor.getString(id: String): String {
        return this.getString(this.getColumnIndex(id))
    }

    private fun Cursor.getStringPlus(id: String): String? {
        return this.getString(this.getColumnIndex(id))
    }

    private fun thisSqlite(): SQLiteDatabase {
        return this.writableDatabase
    }

    companion object {

        fun ConvertToDatabaseName(year: String, month: String, day: String): String {
            return "DATE_${year}_${month}_${day}"
        }
    }

    data class Room(val HOUR: Int, val MINUTE: Int, val CAPACITY: Int, val CURRENT: Int)
    data class Person(val NAME: String, val PHONE: String, val CATEGORY: Int)


}