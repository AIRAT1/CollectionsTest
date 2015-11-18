package de.java.collectionstest;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    private List<Person> friends;
    private Context context;

    public FriendsAdapter(List<Person> friends, Context context) {
        this.friends = friends;
        this.context = context;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person p = friends.get(position);
        View friendView = convertView;
        if (friendView == null) {
            friendView = LayoutInflater.from(context).inflate(R.layout.listitem_friend, null);
        }
        ImageView ivAvatar = (ImageView) friendView.findViewById(R.id.avatar);
        if (p.isAvatarExist()) {
            ivAvatar.setImageResource(R.drawable.friend1);
        } else {
            ivAvatar.setImageResource(R.drawable.no_avatar);
        }
        TextView tvName = (TextView) friendView.findViewById(R.id.name);
        tvName.setText(p.getName());
        ImageView ivFavourite = (ImageView) friendView.findViewById(R.id.favourite);
        if (p.isFavourite()) {
            ivFavourite.setVisibility(View.VISIBLE);
        } else {
            ivFavourite.setVisibility(View.GONE);
        }
        TextView tvContacts = (TextView) friendView.findViewById(R.id.email);
        tvContacts.setText(p.getTelephone() + " " + p.getEmail());
        TextView tvBirthday = (TextView) friendView.findViewById(R.id.birthday);
        tvBirthday.setText(DateFormat.format("ДР: dd.MM.yyyy", p.getBirth()));
        return friendView;
    }
}
