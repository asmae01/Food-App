package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.appfood.adapter.RecycleViewAdapter;
import com.example.appfood.model.Recettes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity implements SearchView.OnQueryTextListener , RecycleViewOnItemClick{
    RecyclerView recyclerView;
    //    List<Users> list = new ArrayList<>();
    RecycleViewAdapter adapter;

    SearchView searchView;
    List<Recettes> recettes =new ArrayList<>();
    List<Recettes> list = new ArrayList<>();
    ArrayList<Recettes> arraylist =new ArrayList<>() ;


    @SuppressLint({"ClickableViewAccessibility", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //TextView title = (TextView) findViewById(R.id.activityTitle2);
        //  title.setText("Home");
        ListView myList;
        Toolbar toolbar;
        TextView num_fav;

        searchView = (SearchView) findViewById(R.id.searchId);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.saved:
                    Intent b = new Intent(Search.this,Saved.class);
                    startActivity(b);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.home:
                    Intent a = new Intent(Search.this,MainActivity.class);
                    startActivity(a);
                    overridePendingTransition(0,0);
                    return true;

                case R.id.search:
                    return true;
                case R.id.upload:
                    Intent c = new Intent(Search.this,Upload.class);
                    startActivity(c);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return false;
        });


        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recettes.add(new Recettes("les pattes","desc desc desc desc desc","Food",R.drawable.pattes));
        recettes.add(new Recettes("berger","L'heure du berger désigne \n le moment où la nuit tombe  ","Food",R.drawable.berger));
        recettes.add(new Recettes("les pattes","desc desc desc desc desc","Food",R.drawable.pattes));
        recettes.add( new Recettes("pizza","desc desc desc desc desc","Pizza",R.drawable.pizza));
        recettes.add(new Recettes("salad","desc desc desc desc desc","Salads",R.drawable.salad));
        recettes.add(   new Recettes("soup","desc desc desc desc desc","Soups",R.drawable.soup));
        recettes.add( new Recettes("soup","desc desc desc desc desc","Soups",R.drawable.soup));


        arraylist.addAll(recettes);

        recyclerView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return false;
        });

//        String username[] = getResources().getStringArray(R.array.usernames);
//        int profileImage[] ={R.drawable.salad,R.drawable.berger,R.drawable.pizza,R.drawable.soup,R.drawable.pattes,R.drawable.salad,R.drawable.berger,R.drawable.pizza,R.drawable.soup,R.drawable.pattes,R.drawable.salad,R.drawable.berger,R.drawable.pizza,R.drawable.soup,R.drawable.pattes};
//        String descForAll = getResources().getString(R.string.userDes);
//
//        for (int i = 0 ; i<username.length;i++){
//            Users users = new Users(profileImage[i],username[i],descForAll);
//            list.add(users);        }
        adapter = new RecycleViewAdapter(this,arraylist,this);
        recyclerView.setAdapter(adapter);


    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String text = s;
        adapter.filter(text);
        return false;
    }
    public void filterBtn(View view) {
        Intent i = new Intent(this , Upload.class);
        startActivity(i);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,DetailsRecette.class);
        intent.putExtra("image", recettes.get(position).getImage());
        intent.putExtra("name", recettes.get(position).getName());
        intent.putExtra("type", recettes.get(position).getType());

        startActivity(intent);

    }

    @Override
    public void onLongItemClick(int position) {
        recettes.remove(position);
        adapter.notifyItemRemoved(position);

    }
}