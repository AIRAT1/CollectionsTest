package de.java.collectionstest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Person> friends;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_friends);
        createFriends();
        fillList();
    }
    private void fillList() {
        listView.setAdapter(new FriendsAdapter(friends, this));
    }

    private void createFriends() {
        friends = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            Person p = new Person();
            p.setName("Иван Петрович № " + i);
            p.setBirth(System.currentTimeMillis() - 1000000000L * i);
            if (i % 2 == 0) {
                p.setEmail("myemail" + i + "@mail.ru");
            }
            p.setAvatarExist(i % 3 == 0);
            p.setFavourite(i % 3 == 0);
            p.setTelephone("+7-986-555-5555");
            friends.add(p);
        }
    }
}
