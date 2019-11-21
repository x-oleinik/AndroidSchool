package io.realmagic.androidschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LecturesAdapter mLecturesAdapter;
    private LecturesProvider mProvider = new LecturesProvider();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRV();
        initSpinner();



    }

    private void initRV(){
        RecyclerView recyclerView = findViewById(R.id.rv);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mLecturesAdapter = new LecturesAdapter();
        recyclerView.setAdapter(mLecturesAdapter);
        mLecturesAdapter.setmLectures(mProvider.getmLectures());
    }

    private void initSpinner(){
        Spinner spinner = findViewById(R.id.spinner);
        LectorsSpinnerAdapter lectorsSpinnerAdapter = new LectorsSpinnerAdapter();
        final List<String> lectors = mProvider.getLectors();
        Collections.sort(lectors);
        lectors.add(0, getString(R.string.all_lectors));
        lectorsSpinnerAdapter.setmLectors(lectors);
        spinner.setAdapter(lectorsSpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("TAG", "hey!");

                if (i == 0){

                    mLecturesAdapter.setmLectures(mProvider.getmLectures());
                } else {
                    String lectorName = lectors.get(i);
                    List<Lecture> list = mProvider.filterBy(lectorName);
                    mLecturesAdapter.setmLectures(list);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
