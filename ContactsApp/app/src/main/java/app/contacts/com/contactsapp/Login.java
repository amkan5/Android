package app.contacts.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import static app.contacts.com.contactsapp.Main.MEMPW;
import static app.contacts.com.contactsapp.Main.MEMSEQ;
import static app.contacts.com.contactsapp.Main.MEMTAB;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Context _this = Login.this;
        findViewById(R.id.login_btn).setOnClickListener(
                (View v)->{
                    ItemExist exist = new ItemExist(_this);
                   // this.startActivity(new Intent(_this, MemberList.class));
                    EditText x = findViewById(R.id.inputID);
                    EditText y = findViewById(R.id.inputPW);
                    exist.id = x.getText().toString();
                    exist.pw = x.getText().toString();
                    new Main.StatusService(){
                        @Override
                        public void perform() {
                            if(exist.execute()){
                                Toast.makeText(_this,"로그인성공",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(_this, MemberList.class));
                            }else{
                                Toast.makeText(_this,"로그인실패",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(_this, Login.class));
                            }
                        }
                    }.perform(); //내가만든 람다식
                }
        );
    }
    private class LoginQuery extends Main.QueryFactory {
        SQLiteOpenHelper helper;
        public LoginQuery(Context _this) { //왜 생성자에 context를 전달하고있을까?
            super(_this);
            helper = new Main.SQLiteHelper(_this);
        }
        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getReadableDatabase(); //리드온니
        }
    }
    private class ItemExist extends LoginQuery{ //얘를 만들지않으면 진행못해
        String id,pw;
        public ItemExist(Context _this) {
            super(_this);
        }
        public boolean execute(){
            return super.getDatabase().rawQuery(String.format(
                    " SELECT*FROM %s " +
                            "WHERE %s LIKE '%s' AND %s LIKE '%s' ",
                    MEMTAB,
                    MEMSEQ,
                    id,
                    MEMPW,
                    pw
                    ),null)
                    .moveToNext();
        }
    }

}
