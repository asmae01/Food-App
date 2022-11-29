package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.appfood.adapter.BestForYouAdapter;
import com.example.appfood.adapter.RecettesAdapter;
import com.example.appfood.adapter.RecycleViewAdapter;
import com.example.appfood.model.BestForYou;
import com.example.appfood.model.Recettes;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecycleViewOnItemClick{

    RecyclerView recyclerView;
    //    List<Users> list = new ArrayList<>();
    RecettesAdapter adapter;

    SearchView searchView;
    List<Recettes> recettes =new ArrayList<>();
    List<Recettes> list = new ArrayList<>();
    ArrayList<Recettes> arraylist =new ArrayList<>() ;


    RecyclerView bestForYouRecycler;
    private RecyclerView.LayoutManager layoutManager;

    @SuppressLint({"NonConstantResourceId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  TextView title = (TextView) findViewById(R.id.homeTitle1);
   //     title.setText("Home");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    return true;
                case R.id.saved:
                    Intent a = new Intent(MainActivity.this,Saved.class);
                    startActivity(a);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.search:
                    Intent b = new Intent(MainActivity.this,Search.class);
                    startActivity(b);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.upload:
                    Intent c = new Intent(MainActivity.this,Upload.class);
                    startActivity(c);
                    return true;
            }
            return false;
        });


        recyclerView= findViewById(R.id.best_for_you_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
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

//        bestForYouRecycler.setAdapter(adapter);


        adapter = new RecettesAdapter(this,arraylist, this);
        recyclerView.setAdapter(adapter);

//        List<BestForYou> bestForYouList=new ArrayList<>();
//        bestForYouList.add(new BestForYou("Couscous Royal", "Le couscous marocain est une spécialité culinaire du Maghreb. Il représente un mélange simplement de deux plats principaux. Il s'agit de la semoule de blé cuite dans un couscoussier à la vapeur et d'un corps gras qui peut être soit du beurre ou généralement de l'huile d'olive",4,"2h", R.drawable.berger));
//        bestForYouList.add(new BestForYou("Tagine de Poulet", "Le tajine de poulet au safran est un autre plat marocain avec un mélange subtil d'épices qui est facile à préparer ! Comme toutes les recettes marocaines, le mélange d'épices,", 3,"1h15min", R.drawable.cheking));
//        bestForYouList.add(new BestForYou("Seffa", "Le Seffa est un couscous sucré à la cannelle et aux amandes. Au Maroc, il peut aussi être fait avec du riz ou des vermicelles. Ce plat se mange généralement en fin de repas avant le dessert", 4,"1h20min", R.drawable.pattes));
//        bestForYouList.add(new BestForYou("La Harira ", "La harira est une soupe traditionnelle du Maroc et de l'ouest de l'Algérie d'origine andalouse. Elle est constituée de tomates, de légumes, de viande et d'oignon", 4,"2h25min", R.drawable.soup));
//
//        bestForYouRecycler = findViewById(R.id.best_for_you_recycler);
//        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
//        bestForYouRecycler.setLayoutManager(layoutManager);
//        bestForYouAdapter= new BestForYouAdapter(this,bestForYouList);
//        bestForYouRecycler.setAdapter(bestForYouAdapter);
//        System.out.println("yeeeeeeeeeeeeeeeeeeeeeeees");

    }


    private void setBestForYouRecycler(List<Recettes> bestForYouList){
        bestForYouRecycler = findViewById(R.id.best_for_you_recycler);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        bestForYouRecycler.setLayoutManager(layoutManager);
        adapter= new RecettesAdapter(this,bestForYouList,this);
        bestForYouRecycler.setAdapter(adapter);
        System.out.println("yeeeeeeeeeeeeeeeeeeeeeeees");
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

    }
}