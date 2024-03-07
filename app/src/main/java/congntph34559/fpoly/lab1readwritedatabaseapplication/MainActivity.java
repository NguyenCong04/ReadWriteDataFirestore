package congntph34559.fpoly.lab1readwritedatabaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    AdapterCity adapterCity;
    FloatingActionButton floatingActionButton;

    FirebaseFirestore db;
    List<City> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcvCity);
        floatingActionButton = findViewById(R.id.floatAddCity);

        db = FirebaseFirestore.getInstance();

        WriteData();
        ReadData();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,AddCityActivity.class));
            }
        });

    }

    private void ReadData() {

        db.collection("City")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                                City city = new City();
                                city.setNameCity(documentSnapshot.getString("name"));
                                city.setStateCity(documentSnapshot.getString("state"));
                                city.setCountryCity(documentSnapshot.getString("country"));
                                city.setPopulationCity(documentSnapshot.getLong("population"));
                                list.add(city);

                            }
                            adapterCity = new AdapterCity(list,MainActivity.this);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(adapterCity);
                            adapterCity.notifyDataSetChanged();
                        }

                    }
                });


    }

    private void WriteData() {


        CollectionReference collection = db.collection("City");

        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "Los Angeles");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("population", 860000);

        collection.document("LA").set(data1);
    }


}