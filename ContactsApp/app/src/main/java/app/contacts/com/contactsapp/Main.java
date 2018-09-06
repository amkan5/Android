package app.contacts.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context _this = Main.this;
        findViewById(R.id.mainToLoginbtn).setOnClickListener(
                (View v)->{
                    SQLiteHelper helper = new SQLiteHelper(_this);
                    this.startActivity(new Intent(_this, Login.class));
                }
        );
    }

    static class Member{int seq; String name, pw, email,phone,addr,photo;}
    //빈을만듬
        static interface ListService { public List<?> perform ();}
        static interface DetailService { public Object perform ();}
        static interface StatusService {public void perform();}
        static String DBNAME = "kanee.db";
        static String MEMTAB = "MEMBER";
        static String MEMSEQ = "SEQ";
        static String MEMNAME = "NAME";
        static String MEMPW = "PW"; //요새 트렌드는 짧고강렬
        static String MEMEMAIL = "EMAIL";
         static String MEMADDR = "ADDR";
        static String MEMPHONE = "PHONE";
        static String MEMPHOTO = "PHOTO";

        static abstract class QueryFactory{
            Context _this;
            public QueryFactory(Context _this) { //알트+Insert
                this._this = _this;
            }
            public abstract SQLiteDatabase getDatabase(); //내장DB 리눅스위에서돌아감 리드온니(수정불가) 토드못씀 안드로이드에서만 수정가능
        }

        static class SQLiteHelper extends SQLiteOpenHelper{
            public SQLiteHelper(Context context) { //알트+insert
                super(context, DBNAME, null, 1); //null하면 내장되어있는애 쓴다고
                this.getWritableDatabase(); //수정가능 이클래스안에서
            }

            @Override
            public void onCreate(SQLiteDatabase db) { //온크리트는 바로 db가생성되면 실행됨
                String sql = String.format(
                        "CREATE TABLE IF NOT EXISTS %s "+
                        " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " %s TEXT," +
                        " %s TEXT," +
                        " %s TEXT," +
                        " %s TEXT," +
                        " %s TEXT," +
                        " %s TEXT" +
                        ")",MEMTAB,MEMSEQ,MEMNAME,MEMPW,
                        MEMEMAIL,MEMADDR,MEMPHONE,MEMPHOTO
                        ); //어드레스?
                Log.d("실행할 쿼리 : ",sql);
                db.execSQL(sql);
                Log.d("============================","create쿼리완료");
                String[] names = {"정기석","아이유","조승우","이동욱","수지"};
                String[] emails = {"ki@test.com","iu@test.com","jo@test.com","lee@test.com","soo@test.com"};
                for(int i=0;i<5;i++){
                    db.execSQL(sql = String.format(
                            "INSERT INTO %s "+
                                    " (%s ," +
                                    " %s ," +
                                    " %s ," +
                                    " %s ," +
                                    " %s ," +
                                    " %s " +
                                    ") VALUES " +
                                    " ('%s' ," +
                                    " '%s' ," +
                                    " '%s' ," +
                                    " '%s' ," +
                                    " '%s' ," +
                                    " '%s' )"
                            ,MEMTAB,MEMNAME,MEMPW,
                            MEMEMAIL,MEMADDR,MEMPHONE,MEMPHOTO,
                            names[i],"1",emails[i],
                            "신촌 "+i+"길","010-1234-567"+i,"profile_"+i
                    ));
                }
                Log.d("============================","insert 쿼리실행완료");
            }
            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS "+MEMTAB);
                onCreate(db);
            }
        }


}
