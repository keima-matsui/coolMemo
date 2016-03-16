package tokyo.hal.ac.jp.kadai06;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import android.support.v7.appcompat.R;


public class MainActivity extends ActionBarActivity {

    EditText et1;
    EditText et2;
    private ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }et1 = (EditText)findViewById(R.id.editText);

    et2 = (EditText)findViewById(R.id.editText2);
    ImageButtonButton add = (ImageButton)findViewById(R.id.imageButton);
    adapter = new ArrayAdapter<Product>(this,android.R.layout.simple_list_item_1);

    ListView lv = (ListView)findViewById(R.id.listView);
    lv.setAdapter(adapter);

    MyDatabaseHelper h = new MyDatabaseHelper(this);
    SQLiteDatabase db = h.getReadableDatabase();

    //ÉeÅ[ÉuÉãÇÃÉJÉâÉÄñºÇîzóÒÇ…Ç∑ÇÈ(îzóÒñº:col)
    String[] col = {"hinmei","tenmei"};

    //ÉJÅ[É\ÉãÇê›íËÇµñ‚Ç¢çáÇÌÇπÇé¿çs
    Cursor c = db.query("Products", col, null, null, null, null, null);

    //ÉJÅ[É\ÉãÇêÊì™Ç…à⁄ìÆÇµåJÇËï‘Ç∑
    boolean flg = c.moveToFirst();


    while(flg){
        adapter.add(new Product(c.getString(0),c.getString(1)));
        flg = c.moveToNext();
    }



    add.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub


            MyDatabaseHelper h = new MyDatabaseHelper(MainActivity.this);
            SQLiteDatabase db = h.getWritableDatabase();

            String hinmei = et1.getText().toString();
            String tenmei = et2.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("hinmei", hinmei);
            cv.put("tenmei", tenmei);

            db.insert("Products", null, cv);

        }

    });


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
