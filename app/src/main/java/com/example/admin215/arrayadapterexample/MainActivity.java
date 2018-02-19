package com.example.admin215.arrayadapterexample;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SimpleAdapter adapter;
    LinkedList <HashMap<String, Object>> list;
    Button writeButton, showButton;
    EditText author, name;
    Book book;
    String [] from = {"name", "author","cover"}; //список ключей
    int [] to = {R.id.name_book, R.id.authorbook, R.id.cover}; //список элементов разметки
    //массив идентификаторов картинок для случайного выбора
    int imageId[] = {R.drawable.cave, R.drawable.garden, R.drawable.ibikus, R.drawable.war, R.drawable.anna};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new LinkedList<HashMap<String, Object>>();
        writeButton = (Button)findViewById(R.id.write);
        showButton = (Button) findViewById(R.id.showlist);
        author = (EditText) findViewById(R.id.author);
        name = (EditText) findViewById(R.id.namebook);
        listView = (ListView) findViewById(R.id.listview);
      //  Resources res  = getResources();
       // adapter = new ArrayAdapter(this,R.layout.list_item, res.getStringArray(R.array.string_list));
       writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int k = Math.abs(random.nextInt()%5);
                Resources res  = getBaseContext().getResources();
                Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.cave);

                book = new Book(name.getText().toString(), author.getText().toString());
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("name", book.name);
                hashMap.put("author", book.author);
                hashMap.put("cover", imageId[k]);
                list.add(hashMap);
            }
        });
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new SimpleAdapter(getBaseContext(),list,R.layout.list_item,from,to);
                listView.setAdapter(adapter);
            }
        });



    }
}
