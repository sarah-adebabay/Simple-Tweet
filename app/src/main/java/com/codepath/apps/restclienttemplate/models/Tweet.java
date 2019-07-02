package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {

    public String body;
    public long uid;
    public String createdAt;
    public User user;

    public static Tweet fromJSON(JSONObject object) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = object.getString("body");
        tweet.uid = object.getLong("uid");
        tweet.user = User.fromJSON(object.getJSONObject("user")); // oof how do i grab the user?
        tweet.createdAt = object.getString("createdAt");
        return tweet;
    }

}
