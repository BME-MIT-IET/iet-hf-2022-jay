package illyan.jay


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
        try{
            onView(withId(R.id.signOutButton))?.perform(ViewActions.click())
        } catch(exc: Exception){

        }

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

        val bottomNavigationItemView = onView(
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
        bottomNavigationItemView.perform(click())

        val materialButton = onView(
            allOf(
                withId(R.id.deleteSessionsButton), withText("Delete sessions"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.sessionsNavHost),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.homeNavFragment), withContentDescription("Home"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationMain),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

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

        val materialCardView3 = onView(
            allOf(
                withId(R.id.serviceOnCard),
                childAtPosition(
                    allOf(
                        withId(R.id.serviceToggleCardFlipper),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialCardView3.perform(click())

        val bottomNavigationItemView3 = onView(
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
        bottomNavigationItemView3.perform(click())

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
                withId(R.id.sessionDuration), withText("0"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(R.id.sessionDuration), withText("0"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("0")))

        val textView5 = onView(
            allOf(
                withId(R.id.sessionDistance), withText("0.00"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView5.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                withId(R.id.sessionDistance), withText("0.00"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("0.00")))

        val textView7 = onView(
            allOf(
                withId(R.id.sessionStart),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView7.check(matches(isDisplayed()))

        val textView8 = onView(
            allOf(
                withId(R.id.sessionEnd),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.appcompat.widget.LinearLayoutCompat::class.java))),
                isDisplayed()
            )
        )
        textView8.check(matches(isDisplayed()))

        val button = onView(
            allOf(
                withId(R.id.viewInMapButton),
                withParent(withParent(withId(R.id.sessionCard))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val cardView = onView(
            allOf(
                withId(R.id.sessionCard),
                withParent(withParent(withId(R.id.sessionsRecycler))),
                isDisplayed()
            )
        )
        cardView.check(matches(isDisplayed()))

        val cardView2 = onView(
            allOf(
                withId(R.id.sessionCard),
                withParent(withParent(withId(R.id.sessionsRecycler))),
                isDisplayed()
            )
        )
        cardView2.check(matches(isDisplayed()))
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
