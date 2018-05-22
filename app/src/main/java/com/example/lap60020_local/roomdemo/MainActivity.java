package com.example.lap60020_local.roomdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
//        User user = new User();
//        user.setFirstName("Ajay");
//        user.setLastName("Saini");
//        user.setAge(25);
//        appDatabase.getUserDao().insertAll(user);
        Flowable<User> flowable =  appDatabase.getUserDao().getAll();
        flowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(u->{
            Log.d("ghi log",u.getFirstName());
            Log.d("ghi log",u.getLastName());
        },e->{
            Log.d("ghi log", "no data");
        },()->{
            Log.d("ghi log","complete ne");
        });

    }
}
