package com.example.shashidhar.mytimetable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class fridayFragment extends Fragment {
    View v;
    public fridayFragment(){

    }
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    ArrayList<demo> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fri_fragment, container, false);
        recyclerView = v.findViewById(R.id.fri_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(get_json());
            JSONObject jsonObject1= jsonObject.getJSONObject("week").getJSONObject("friday");
            if(jsonObject1 != null){
                JSONArray jsonArray = jsonObject1.getJSONArray("class");
                for(int i=0; i<jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    demo demo = new demo(obj.getString("subject"), obj.getString("starttime"),
                            obj.getString("endtime"), obj.getString("teacher"), obj.getString("classroom"));
                    list.add(demo);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        adapter = new RecyclerViewAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
        return v;
    }
    public String get_json() {
        String json=null;

        try {
            InputStream is = getActivity().getAssets().open("MyTT.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
