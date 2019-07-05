package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{

    private List<Tweet> mTweets;
    Context context;

    public TweetAdapter(List<Tweet> tweets) {
        mTweets = tweets;
    }

    //only used when a user needs a new row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_tweet, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Tweet tweet = mTweets.get(i);

        viewHolder.tvUsername.setText(tweet.user.getName());
        viewHolder.tvBody.setText(tweet.body);

        Glide.with(context).load(tweet.user.profileImageURL).into(viewHolder.ivProfileImage);

        viewHolder.tvAt.setText("@" + tweet.user.screenName);
        viewHolder.tvTime.setText(getRelativeTimeAgo(tweet.createdAt));

        //viewHolder.tvUserName.setText("sarah:)");
        //viewHolder.tvUserAt.setText("@sunshine_saraah");
        //Glide.with(context).load("https://pbs.twimg.com/profile_images/1067724980484370434/1EVuQTnS_400x400.jpg").into(viewHolder.ivProfileImage);

    }

    public String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvUsername;
        TextView tvBody;
        TextView tvTime;
        TextView tvAt;

        //for composing a tweet
        TextView tvUserName;
        TextView tvUserAt;
        ImageView ivUserProfilePic;

        public ViewHolder(View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvAt = itemView.findViewById(R.id.tvAt);
            tvTime = itemView.findViewById(R.id.tvTime);


            //adding the username, screenname, and profile pic
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserAt = itemView.findViewById(R.id.tvUserAt);
            ivUserProfilePic = itemView.findViewById(R.id.ivUserProfilePic);

        }

    }

}
