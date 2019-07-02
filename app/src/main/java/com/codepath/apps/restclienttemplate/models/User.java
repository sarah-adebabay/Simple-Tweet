package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    String name;
    long uid;
    String screenName;
    String profileImageURL;

    public static User fromJSON(JSONObject object) throws JSONException {
        User user = new User();
        user.name = object.getString("name");
        user.uid = object.getLong("uid");
        user.screenName = object.getString("screenName");
        user.profileImageURL = object.getString("profileImageURL");
        return user;
    }

    public String getName() {
        return name;
    }
}
