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
class NotificationTest {

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
    fun notificationTest() {
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

        val textView = onView(
            allOf(
                IsInstanceOf.instanceOf(android.widget.TextView::class.java), withText("Jay"),
                withParent(
                    allOf(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                IsInstanceOf.instanceOf(android.widget.TextView::class.java), withText("Jay"),
                withParent(
                    allOf(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Jay")))

        val textView3 = onView(
            allOf(
                withId(android.R.id.title), withText("Current location"),
                withParent(
                    allOf(
                        IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                        withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(android.R.id.title), withText("Current location"),
                withParent(
                    allOf(
                        IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                        withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Current location")))

        val textView5 = onView(
            allOf(
                IsInstanceOf.instanceOf(android.widget.TextView::class.java),
                withText("Lat: 37.4219983 Lng: -122.084"),
                withParent(
                    allOf(
                        IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                        withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                IsInstanceOf.instanceOf(android.widget.TextView::class.java),
                withText("Lat: 37.4219983 Lng: -122.084"),
                withParent(
                    allOf(
                        IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                        withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(isDisplayed()))
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
