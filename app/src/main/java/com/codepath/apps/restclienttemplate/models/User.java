package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public long uid;
    public String screenName;
    public String profileImageURL;

    public static User fromJSON(JSONObject object) throws JSONException {
        User user = new User();
        user.name = object.getString("name");
        user.uid = object.getLong("id");
        user.screenName = object.getString("screen_name");
        user.profileImageURL = object.getString("profile_image_url_https");
        return user;
    }

    public String getName() {
        return name;
    }
}
