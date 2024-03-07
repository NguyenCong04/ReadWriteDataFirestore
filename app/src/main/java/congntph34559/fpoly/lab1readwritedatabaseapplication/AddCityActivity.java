package congntph34559.fpoly.lab1readwritedatabaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AddCityActivity extends AppCompatActivity {

    AppCompatButton btnAddCity;
    EditText edName, edState, edCountry, edPopulation;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        btnAddCity = findViewById(R.id.btnAddCity);
        edName = findViewById(R.id.edNameCity);
        edState = findViewById(R.id.edStateCity);
        edCountry = findViewById(R.id.edCountryCity);
        edPopulation = findViewById(R.id.edPopulationCity);

        db = FirebaseFirestore.getInstance();

        btnAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    String name = edName.getText().toString();
                    String country = edCountry.getText().toString();
                    String state = edState.getText().toString();
                    long population = Long.parseLong(edPopulation.getText().toString());

                    Map<String, Object> data = new HashMap<>();
                    data.put("name", name);
                    data.put("country", country);
                    data.put("state", state);
                    data.put("population", population);

                    db.collection("City").document().set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(AddCityActivity.this, "Add city successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddCityActivity.this, MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddCityActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });


    }

    private boolean check() {


        if (edPopulation.getText().toString().equals("") || edName.getText().toString().equals("") || edCountry.getText().toString().equals("") || edState.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter information city", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }
}