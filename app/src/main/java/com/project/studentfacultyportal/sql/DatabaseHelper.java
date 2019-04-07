package com.project.studentfacultyportal.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.studentfacultyportal.model.User;
import com.project.studentfacultyportal.model.Faculty;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_FACULTY= "faculty";


    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_BRANCH = "user_branch";
    private static final String COLUMN_USER_SEMESTER = "user_semester";
    private static final String COLUMN_USER_MOBILE = "user_mobile";
    private static final String COLUMN_USER_SCORE = "user_score";
    private static final String COLUMN_USER_TOP_SCORER = "user_top_scorer";
    private static final String COLUMN_USER_TOTAL_QUIZ = "user_total_quiz";







    private static final String COLUMN_FACULTY_ID = "faculty_id";
    private static final String COLUMN_FACULTY_NAME = "faculty_name";
    private static final String COLUMN_FACULTY_EMAIL = "faculty_email";
    private static final String COLUMN_FACULTY_PASSWORD = "faculty_password";



    // create table sql query
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, "
            + COLUMN_USER_EMAIL + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_BRANCH + " TEXT, "
            + COLUMN_USER_SEMESTER + " TEXT, " + COLUMN_USER_MOBILE + " TEXT," + COLUMN_USER_SCORE + " TEXT,"
            + COLUMN_USER_TOP_SCORER + " TEXT, " + COLUMN_USER_TOTAL_QUIZ + " TEXT " + " )";

    private static final String CREATE_FACULTY_TABLE = "CREATE TABLE " + TABLE_FACULTY + "("
            + COLUMN_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FACULTY_NAME + " TEXT, "
            + COLUMN_FACULTY_EMAIL + " TEXT, " + COLUMN_FACULTY_PASSWORD + " TEXT " + " )";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DROP_FACULTY_TABLE = "DROP TABLE IF EXISTS " + TABLE_FACULTY;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_FACULTY_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_FACULTY_TABLE);

        // Create tables again
        onCreate(db);

    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_BRANCH, user.getBranch());
        values.put(COLUMN_USER_SEMESTER, user.getSemester());
        values.put(COLUMN_USER_MOBILE,user.getMobile_no());
        values.put(COLUMN_USER_SCORE,0);
        values.put(COLUMN_USER_TOP_SCORER,0);
        values.put(COLUMN_USER_TOTAL_QUIZ,0);


        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public void addFaculty (Faculty faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FACULTY_NAME, faculty.getName());
        values.put(COLUMN_FACULTY_EMAIL, faculty.getEmail());
        values.put(COLUMN_FACULTY_PASSWORD, faculty.getPassword());

        // Inserting Row
        db.insert(TABLE_FACULTY, null, values);
        db.close();
    }

    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_BRANCH,
                COLUMN_USER_SEMESTER,
                COLUMN_USER_MOBILE,
                COLUMN_USER_SCORE,
                COLUMN_USER_TOP_SCORER,
                COLUMN_USER_TOTAL_QUIZ
        };


        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(((Cursor) cursor).getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    public List<Faculty> getAllFaculty() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_FACULTY_ID,
                COLUMN_FACULTY_EMAIL,
                COLUMN_FACULTY_NAME,
                COLUMN_FACULTY_PASSWORD
        };


        // sorting orders
        String sortOrderF =
                COLUMN_FACULTY_NAME + " ASC";
        List<Faculty> facultyList = new ArrayList<Faculty>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_FACULTY, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrderF); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Faculty faculty = new Faculty();
                faculty.setId(Integer.parseInt(((Cursor) cursor).getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                faculty.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                faculty.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                faculty.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                facultyList.add(faculty);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return facultyList;
    }


    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_BRANCH, user.getBranch());
        values.put(COLUMN_USER_SEMESTER, user.getSemester());
        values.put(COLUMN_USER_MOBILE,user.getMobile_no());
        values.put(COLUMN_USER_SCORE,user.getScore());
        values.put(COLUMN_USER_TOP_SCORER,user.getTop_scorer());
        values.put(COLUMN_USER_TOTAL_QUIZ,user.getTotal_quiz());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }


    public void updateFaculty(Faculty faculty) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FACULTY_NAME, faculty.getName());
        values.put(COLUMN_FACULTY_EMAIL, faculty.getEmail());
        values.put(COLUMN_FACULTY_PASSWORD, faculty.getPassword());

        // updating row
        db.update(TABLE_FACULTY, values, COLUMN_FACULTY_ID + " = ?",

                new String[]{String.valueOf(faculty.getId())});
        db.close();
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void deleteFaculty(Faculty faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_FACULTY, COLUMN_FACULTY_ID + " = ?",
                new String[]{String.valueOf(faculty.getId())});
        db.close();
    }


    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkFaculty(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_FACULTY_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_FACULTY_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_FACULTY, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                     //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


    public Cursor getSemester(String email, SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {COLUMN_USER_SEMESTER};
        String selection = COLUMN_USER_EMAIL+" LIKE ?";
        String[] selection_args={email};
        cursor = db.query(TABLE_USER, projections, selection, selection_args, null, null, null);
        return cursor;
    }

    public Cursor getBranch(String email, SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {COLUMN_USER_BRANCH};
        String selection = COLUMN_USER_EMAIL+" LIKE ?";
        String[] selection_args={email};
        cursor = db.query(TABLE_USER, projections, selection, selection_args, null, null, null);
        return cursor;
    }

    public Cursor getMobile(String email, SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {COLUMN_USER_MOBILE};
        String selection = COLUMN_USER_EMAIL+" LIKE ?";
        String[] selection_args={email};
        cursor = db.query(TABLE_USER, projections, selection, selection_args, null, null, null);
        return cursor;
    }

    public Cursor getInfo(String email, SQLiteDatabase sqLiteDatabase) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {COLUMN_USER_NAME,COLUMN_USER_MOBILE, COLUMN_USER_BRANCH, COLUMN_USER_SEMESTER, COLUMN_USER_TOTAL_QUIZ, COLUMN_USER_TOP_SCORER, COLUMN_USER_SCORE};
        String selection = COLUMN_USER_EMAIL+" LIKE ?";
        String[] seletion_args={email};
        Cursor cursor=sqLiteDatabase.query(TABLE_USER,projections,selection,seletion_args,null,null,null);
        return cursor;

    }

   /* public void updateScore(String email, SQLiteDatabase sqLiteDatabase,int score, int totalQuiz) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_SCORE,score);
        cv.put(COLUMN_USER_TOTAL_QUIZ,totalQuiz);
        sqLiteDatabase.update(TABLE_USER,cv,COLUMN_USER_EMAIL+ "=" + email,null);

    }*/



    public boolean checkFaculty(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_FACULTY_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_FACULTY_EMAIL + " = ?" + " AND " + COLUMN_FACULTY_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_FACULTY, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                     //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

}
