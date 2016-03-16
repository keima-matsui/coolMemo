package tokyo.hal.ac.jp.kadai06;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.view.View.OnClickListener;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "MyDatabase";
    private final static int DB_VERSION = 1;

    private final static String CREATE_PRODUCT_TABLE = "create table " +
            "products(hinmei text" +
            ",tenmei text)";

    public MyDatabaseHelper(Context context) {
        //ÉfÅ[É^ÉxÅ[ÉXÇÃçÏê¨
        super(context, DB_NAME, null, DB_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        //ÉeÅ[ÉuÉãÇÃçÏê¨
        db.execSQL(CREATE_PRODUCT_TABLE);

        //ÉTÉìÉvÉãÉfÅ[É^ÇÃçÏê¨
        //ContentValuesÉNÉâÉXÇóòópÇ∑ÇÈ

        ContentValues cv = new ContentValues();
        cv.put("name","ÇËÇÒÇ≤");
        cv.put("price",100);
        cv.put("others","ê¬êXåßéY");

        //DBÇ÷ÇÃë}ì¸
        db.insert("products", null, cv);

        //ContentVaÇåuesÇÃÉNÉäÉA
        cv.clear();

        cv.put("name","ÇŸÇ¡Ç´äL");
        cv.put("price",250);
        cv.put("others","ñkäCìπéY");

        //DBÇ÷ÇÃë}ì¸
        db.insert("products", null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
