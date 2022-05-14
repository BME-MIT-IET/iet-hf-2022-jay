package illyan.jay


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.GrantPermissionRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SessionCardDefaultAppearanceTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant(
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.FOREGROUND_SERVICE"
        )

    @Test
    fun sessionCardDefaultAppearanceTest() {
        val gz = onView(
            allOf(
                withText("Sign in"),
                childAtPosition(
                    allOf(
                        withId(R.id.googleSignInButton),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        gz.perform(click())

        val materialCardView = onView(
            allOf(
                withId(R.id.serviceOffCard),
                childAtPosition(
                    allOf(
                        withId(R.id.serviceToggleCardFlipper),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialCardView.perform(click())

        val materialCardView2 = onView(
            allOf(
                withId(R.id.serviceOffCard),
                childAtPosition(
                    allOf(
                        withId(R.id.serviceToggleCardFlipper),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialCardView2.perform(click())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.realtimeMapNavFragment), withContentDescription("Map"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationMain),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.sessionsNavFragment), withContentDescription("Sessions"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationMain),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.sessionTitle), withText("1"),
                withParent(withParent(withId(R.id.sessionCard))),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withId(R.id.sessionTitle), withText("1"),
                withParent(withParent(withId(R.id.sessionCard))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("1")))

        val textView3 = onView(
            allOf(
                withText("Duration"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withText("Duration"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Duration")))

        val textView5 = onView(
            allOf(
                withId(R.id.sessionDuration), withText("0"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView5.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                withId(R.id.sessionDuration), withText("0"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("0")))

        val textView7 = onView(
            allOf(
                withText("min"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView7.check(matches(isDisplayed()))

        val textView8 = onView(
            allOf(
                withText("min"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("min")))

        val textView9 = onView(
            allOf(
                withText("Distance"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView9.check(matches(isDisplayed()))

        val textView10 = onView(
            allOf(
                withText("Distance"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView10.check(matches(withText("Distance")))

        val textView11 = onView(
            allOf(
                withText("km"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView11.check(matches(isDisplayed()))

        val textView12 = onView(
            allOf(
                withText("km"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView12.check(matches(withText("km")))

        val textView13 = onView(
            allOf(
                withId(R.id.sessionDistance), withText("0.00"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView13.check(matches(isDisplayed()))

        val textView14 = onView(
            allOf(
                withId(R.id.sessionDistance), withText("0.00"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView14.check(matches(withText("0.00")))

        val textView15 = onView(
            allOf(
                withText("Start"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView15.check(matches(isDisplayed()))

        val textView16 = onView(
            allOf(
                withText("Start"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView16.check(matches(withText("Start")))

        val textView17 = onView(
            allOf(
                withId(R.id.sessionStart), withText("11:25 May 16"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView17.check(matches(isDisplayed()))

        val textView18 = onView(
            allOf(
                withText("End"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView18.check(matches(isDisplayed()))

        val textView19 = onView(
            allOf(
                withText("End"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView19.check(matches(withText("End")))

        val textView20 = onView(
            allOf(
                withId(R.id.sessionEnd),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView20.check(matches(isDisplayed()))

        val textView21 = onView(
            allOf(
                withId(R.id.sessionEnd),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView21.check(matches(withText("")))

        val button = onView(
            allOf(
                withId(R.id.viewInMapButton),
                withParent(withParent(withId(R.id.sessionCard))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(
                withId(R.id.viewInMapButton),
                withParent(withParent(withId(R.id.sessionCard))),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))
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
