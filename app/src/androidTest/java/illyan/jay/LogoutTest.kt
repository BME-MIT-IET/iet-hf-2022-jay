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
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LogoutTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun logoutTest() {
        try{
            onView(withId(R.id.signOutButton))?.perform(click())
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

        val materialButton = onView(
            allOf(
                withId(R.id.signOutButton), withText("Log out"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.homeNavHost),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val viewGroup = onView(
            allOf(
                withId(androidx.appcompat.R.id.action_bar),
                withParent(
                    allOf(
                        withId(androidx.appcompat.R.id.action_bar_container),
                        withParent(withId(androidx.appcompat.R.id.decor_content_parent))
                    )
                ),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withText("Login"),
                withParent(
                    allOf(
                        withId(androidx.appcompat.R.id.action_bar),
                        withParent(withId(androidx.appcompat.R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withText("Login"),
                withParent(
                    allOf(
                        withId(androidx.appcompat.R.id.action_bar),
                        withParent(withId(androidx.appcompat.R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Login")))

        val frameLayout = onView(
            allOf(
                withId(R.id.googleSignInButton),
                withParent(withParent(withId(R.id.loginNavHostFragment))),
                isDisplayed()
            )
        )
        frameLayout.check(matches(isDisplayed()))

        val textView3 = onView(
            allOf(
                withId(R.id.loginStatus), withText("Logged out!"),
                withParent(withParent(withId(R.id.loginNavHostFragment))),
                isDisplayed()
            )
        )
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(R.id.loginStatus), withText("Logged out!"),
                withParent(withParent(withId(R.id.loginNavHostFragment))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Logged out!")))

        val textView5 = onView(
            allOf(
                withId(R.id.loginStatus), withText("Logged out!"),
                withParent(withParent(withId(R.id.loginNavHostFragment))),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("Logged out!")))
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
