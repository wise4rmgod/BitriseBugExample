package com.dev.bitrisebugexample


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest2() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(7000)

        val editText = onView(
            allOf(
                withId(R.id.topic), withText("Topic"),
                withParent(withParent(withId(R.id.texttopic))),
                isDisplayed()
            )
        )
      //  editText.check(matches(withText("Topic")))

        val editText2 = onView(
            allOf(
                withText("Category"),
                withParent(withParent(withId(R.id.textcat))),
                isDisplayed()
            )
        )
       // editText2.check(matches(withText("Category")))

        val editText3 = onView(
            allOf(
                withId(R.id.description), withText("Description"),
                withParent(withParent(withId(R.id.textdesc))),
                isDisplayed()
            )
        )
     //   editText3.check(matches(withText("Description")))

        val button = onView(
            allOf(
                withId(R.id.btn), withText("SEND"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))


        val textInputEditText = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textcat),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )

        val materialButton = onView(
            allOf(
                withId(R.id.btn), withText("send"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
