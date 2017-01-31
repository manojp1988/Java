package com.example.manoj.sampletestproject;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hamcrest.core.AllOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by manoj on 1/31/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SpinnerActivityTest {

    @Rule
    public ActivityTestRule<SpinnerActivity> activityTestRule =
            new ActivityTestRule<>(SpinnerActivity.class);


    @Test
    public void testSpinnerActivity(){

        onView(withId(R.id.countrySpinnerView)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("Malaysia"))).perform(click());

        onView(withId(R.id.countryTextView)).check(matches(withText("Malaysia")));

    }

}
