package com.example.reshmi.myrecyclerview.Activity.Activity;

import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;


import com.example.reshmi.myrecyclerview.Activity.Classesssss.AppDatabase;
import com.example.reshmi.myrecyclerview.Activity.Classesssss.User;
import com.example.reshmi.myrecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormActivity extends AppCompatActivity {
    @BindView(R.id.eName)
    TextInputEditText name;
    @BindView(R.id.eAge)
    TextInputEditText age;
    @BindView(R.id.eNumber)
    TextInputEditText number;
    @BindView(R.id.bt_Add)
    AppCompatButton Add;   //expecting a btn

    AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);

        //initialise appdatabase here loook at the example
        //sorry no need it os a static function
        //now create setOnclick listener of add byn inside it retrirve all va;ues
        // of edittexts
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = name.getText().toString();
                String ageText = age.getText().toString();
                String numberText = number.getText().toString();

                // create a function to insert values to database
                User user = new User();
                user.setFirstName(nameText);
                user.setAge(Integer.parseInt(ageText));
                user.setNumber(Integer.parseInt(numberText));
                insertUser(user);
            }
        });

    }

    private void insertUser(final User user) {
        //inorder to use room database query execution we need a background thraed
        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                try{
                    AppDatabase.getAppDatabase(getApplicationContext()).userDao().insertAll(user);
                    return true;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if(aBoolean){
                    Toast.makeText(FormActivity.this, "User added", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }
}

