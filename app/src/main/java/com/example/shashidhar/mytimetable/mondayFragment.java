package com.example.shashidhar.mytimetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class mondayFragment extends Fragment {
    View v;
    public mondayFragment() {

    }
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    ArrayList<demo> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.mon_fragment, container, false);

        recyclerView = v.findViewById(R.id.mon_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(get_json());
            JSONObject jsonObject1= jsonObject.getJSONObject("week").getJSONObject("monday");
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
