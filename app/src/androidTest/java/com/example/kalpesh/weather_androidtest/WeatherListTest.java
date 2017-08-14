package com.example.kalpesh.weather_androidtest;

/**
 * Created by kalpesh on 14/08/2017.
 */

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WeatherListTest {

    @Rule
    public FragmentTestRule<WeatherList> mFragmentTestRule = new FragmentTestRule<>(WeatherList.class);

    @Before
    public void setUp() throws Exception {
        mFragmentTestRule.launchActivity(null);
    }

    @Test
    public void fragment_can_be_instantiated() {
        // Launch the activity to make the fragment visible
        // Then use Espresso to test the Fragment
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerView(){
        onView(withId(R.id.recycler_weather_list)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_weather_list)).perform(scrollToPosition(10))
                .check(matches(isDisplayed()));
        onView(withId(R.id.recycler_weather_list)).perform(scrollToPosition(4));
        //Espresso seems to need some time before it can register an item within the
        //Recycler View, thus the need to putt the thread to sleep after scrolling to a position
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withText("1021.31")).check(matches(isDisplayed()));
    }

}
