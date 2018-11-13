package com.example.sagar.lecture3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


   private static final String[] words =
           {"sagar","suraj","raja ","naxt","wwew1","smackdown","raw"," wwe ","suraj1"};


   // hashmap is created to store the value
   public HashMap<String,String> dictionary;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list=new ArrayList<String>();
 for (int i=0;i<words.length;i+=2)
 {
     list.add(words[i]);
     dictionary=new HashMap<>();
     dictionary.put(words[i],words[i+1]);
 }


 // five random words are selected
 ArrayList<String> fivewords=new ArrayList<String>();
 for (int i=0;i<5;i++)

     Collections.shuffle(list);
        for (int i=0;i<5;i++)
        {
     fivewords.add(list.get(i));
 }
 // wordds will show on top
 final String thewords=fivewords.get(0);
// five defination of the random words
 final ArrayList<String> fivedef=new ArrayList<String>();
        for(String words:fivewords)
        {
fivedef.add(dictionary.get(words));
        }
        // Collection.shuffle method is used to shuffle the lsit
        Collections.shuffle(fivedef);
ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fivedef);
        ListView listView=
                (ListView)findViewById(R.id.lv1);
        listView.setAdapter(adapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("list","you clicked" +position);

        String onclicked=fivedef.get(position);
String rightanswer=dictionary.get(thewords);
if (onclicked.equals(rightanswer))
{
    Toast.makeText(MainActivity.this,"you are awesomee",Toast.LENGTH_SHORT);
}
else
{
    Toast.makeText(MainActivity.this,"you suck",Toast.LENGTH_SHORT);

}
        //String defiantion= words[position*2+1];
        //TextView textView=(TextView)findViewById(R.id.tv1);
       // textView.setText(defiantion);

    }
});

    }
}
