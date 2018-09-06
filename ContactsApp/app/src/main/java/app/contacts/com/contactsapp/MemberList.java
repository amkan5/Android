package app.contacts.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list);
        Context _this = MemberList.this;
     /*   findViewById(R.id.listToAddbtn).setOnClickListener(
                (View v)->{
                    this.startActivity(new Intent(_this, MemberAdd.class));
                }
        );
        findViewById(R.id.listToDetailbtn).setOnClickListener(
                (View v)->{
                    this.startActivity(new Intent(_this, MemberDetail.class));
                }*/
        );
    }
}
