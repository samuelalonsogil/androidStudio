package com.example.recyclerview01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactRecyclerView;
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactRecyclerView = findViewById(R.id.recyclerView01);

        contacts = new ArrayList<Contact>();
        addContacts();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerViewAdapter.setContacts(contacts);

        contactRecyclerView.setAdapter(recyclerViewAdapter);

        contactRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void addContacts() {
        contacts.add(new Contact("Samuel", "samuel@gmail.com", "https://static.wikia.nocookie.net/berserk/images/4/43/Guts_halc%C3%B3n.jpg/revision/latest/scale-to-width-down/250?cb=20160323161125&path-prefix=es"));
        contacts.add(new Contact("Max", "max@gmail.com", "https://i1.wp.com/collectible506.com/wp-content/uploads/2017/08/BareHandedBladeCatch.png?resize=474%2C337"));
        contacts.add(new Contact("Miguel", "miguel@gmail.com", "https://static.wikia.nocookie.net/berserk/images/f/f7/Guts_armor_manga.jpg/revision/latest/scale-to-width-down/250?cb=20170629022500&path-prefix=es"));
    }
}