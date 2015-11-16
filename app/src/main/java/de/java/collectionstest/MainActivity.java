package de.java.collectionstest;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<Person> friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFriends();
        fillList();
    }

    private void fillList() {
        LinearLayout llFriends = (LinearLayout) findViewById(R.id.ll_friend);
        for (Person p : friends) {
            View friendView = getLayoutInflater().inflate(R.layout.listitem_friend, null);
            ImageView ivAvatar = (ImageView)friendView.findViewById(R.id.avatar);
            if (p.isAvatarExist()) {
                ivAvatar.setImageResource(R.drawable.friend1);
            }else {
                ivAvatar.setImageResource(R.drawable.no_avatar);
            }
            TextView tvName = (TextView) friendView.findViewById(R.id.name);
            tvName.setText(p.getName());
            ImageView ivFavourite = (ImageView) friendView.findViewById(R.id.favourite);
            if (p.isFavourite()) {
                ivFavourite.setVisibility(View.VISIBLE);
            }else {
                ivFavourite.setVisibility(View.GONE);
            }
            TextView tvContacts = (TextView) friendView.findViewById(R.id.email);
            tvContacts.setText(p.getTelephone() + " " + p.getEmail());
            TextView tvBirthday = (TextView) friendView.findViewById(R.id.birthday);
            tvBirthday.setText(DateFormat.format("ДР: dd.MM.yyyy", p.getBirth()));
            llFriends.addView(friendView);
        }
    }

    private void createFriends() {
        friends = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
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
