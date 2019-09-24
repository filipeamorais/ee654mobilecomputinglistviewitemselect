package com.example.listviewitemselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap <String, String> Data = new HashMap<String, String>();
    ListView simpleList;
    ArrayList<Item> flagList = new ArrayList<>();
    public final static String MESSAGE =  "CountryDescription";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adding the content to the HashMap
        Data.put("Brazil", "The capital of Brazil is Brasilia");
        Data.put("USA", "The capital of USA is Washington, D.C.");
        Data.put("EU", "The capital of EU is Brussels");
        Data.put("India", "The capital of India is New Delhi");
        Data.put("EU", "The capital of Germany is Berlin");
        Data.put("Korea", "The capital of Korea is Seoul");
        Data.put("Korea", "The capital of France is Paris");

        //defining a variable name for the ListView implemented on the main layout
        simpleList = (ListView) findViewById(R.id.simpleListView);

        //adding items to the ArrayList that will be displayed by the ListView
        flagList.add(new Item("Brazil", R.drawable.brazil_flag));
        flagList.add(new Item("USA", R.drawable.usa_flag));
        flagList.add(new Item("EU", R.drawable.eu_flag));
        flagList.add(new Item("India", R.drawable.india_flag));
        flagList.add(new Item("Germany", R.drawable.germany_flag));
        flagList.add(new Item("Korea", R.drawable.korea_flag));
        flagList.add(new Item("France", R.drawable.france_flag));

        //creating the adapter used to bind the ArrayList, the ListView and its layout
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_view_items, flagList);
        simpleList.setAdapter(myAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                      Item item = (Item)simpleList.getItemAtPosition(position);
                                      Toast.makeText(getBaseContext(), item.getFlagName(), Toast.LENGTH_SHORT).show();
                                      try {
                                          Intent intent = new Intent(MainActivity.this, EventLogTags.Description.class);
                                          intent.putExtra(MESSAGE, Data.get(item.getFlagName()));
                                          startActivity(intent);
                                      } catch (Exception e) {/* Log error messages */}
                                  }
                              });  //end of setOnClickListener()
    }   // end of onCreate()
}   // end of class MainActivity



    }
}
