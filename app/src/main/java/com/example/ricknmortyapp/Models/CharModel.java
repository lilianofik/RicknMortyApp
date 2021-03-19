package com.example.ricknmortyapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CharModel {

    public static final String TAG = "CharModel";

    public String name;
    public String status;
    public String species;
    public String gender;
    public String image;


    public CharModel(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        status = jsonObject.getString("status");
        species = jsonObject.getString("species");
        gender = jsonObject.getString("gender");
        image = jsonObject.getString("image");
    }

    public static List <CharModel> fromJsonArray(JSONArray charJsonArray) throws JSONException {
        List <CharModel> characters = new ArrayList<>();

        for(int i = 0; i < charJsonArray.length(); i++)
        {
            characters.add(new CharModel(charJsonArray.getJSONObject(i)));
        }

        return characters;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }
}
