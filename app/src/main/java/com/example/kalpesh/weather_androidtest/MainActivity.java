package com.example.kalpesh.weather_androidtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
/**
 * Created by kalpesh on 14/08/2017.
 */
public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    private static final String TAG_RETAINED_FRAGMENT = "RetainedFragment";
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            // The Activity is NOT being re-created so we can instantiate a new Fragment
            // and add it to the Activity
            mFragment = WeatherList.newInstance();
            fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    // It's almost always a good idea to use .replace instead of .add so that
                    // you never accidentally layer multiple Fragments on top of each other
                    // unless of course that's your intention
                    .add(R.id.fragment_container, mFragment, TAG_RETAINED_FRAGMENT)
                    .commit();
        }
        else{
            // The Activity IS being re-created so we don't need to instantiate the Fragment or add it,
            // but if we need a reference to it, we can use the tag we passed to .replace
            mFragment = getSupportFragmentManager().findFragmentByTag(TAG_RETAINED_FRAGMENT);
        }

    }
}
