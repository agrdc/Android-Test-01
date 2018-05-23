package bilulo.mc1androidtest.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class RepositoryDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = RepositoryDbHelper.class.getSimpleName();
    public static final String DATABASE_NAME = "kotlinrepos.db";
    private static final int DATABASE_VERSION = 1;

    public RepositoryDbHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_KOTLIN_REPOS_TABLE =
                "CREATE TABLE " + RepositoryContract.RepositoryEntry.KOTLIN_REPOS_TABLE_NAME + " (" +
                        RepositoryContract.RepositoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        RepositoryContract.RepositoryEntry.COLUMN_REPO_ID + " INTEGER NOT NULL UNIQUE, "+
                        RepositoryContract.RepositoryEntry.COLUMN_NAME + " TEXT NOT NULL, "+
                        RepositoryContract.RepositoryEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, "+
                        RepositoryContract.RepositoryEntry.COLUMN_LOGIN + " TEXT NOT NULL, "+
                        RepositoryContract.RepositoryEntry.COLUMN_STARS + " INTEGER NOT NULL, "+
                        RepositoryContract.RepositoryEntry.COLUMN_FORKS + " INTEGER NOT NULL, "+
                        RepositoryContract.RepositoryEntry.COLUMN_AUTHOR_PICTURE + " TEXT NOT NULL, "+
                        " UNIQUE (" + RepositoryContract.RepositoryEntry.COLUMN_REPO_ID + ") ON CONFLICT REPLACE);";

        Log.d(LOG_TAG,"sql create kotlin repos table = " +SQL_CREATE_KOTLIN_REPOS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_KOTLIN_REPOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RepositoryContract.RepositoryEntry.KOTLIN_REPOS_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
