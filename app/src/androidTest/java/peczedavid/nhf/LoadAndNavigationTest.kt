package peczedavid.nhf

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.PositionAssertions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import peczedavid.nhf.activities.GameActivity
import peczedavid.nhf.activities.LeaderboardActivity
import peczedavid.nhf.activities.MainActivity

@RunWith(AndroidJUnit4::class)
class LoadAndNavigationTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun init() {
        Intents.init()
    }

    @After
    fun after() {
        Intents.release()
    }

    @Test
    fun appLoadsProperly() {
        onView(withText("2048"))
            .check(matches(isDisplayed()))
            .check(isCompletelyAbove(withText("PLAY GAME")))

        onView(withText("PLAY GAME"))
            .check(matches(withId(R.id.playGameBtn)))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
            .check(isCompletelyBelow(withText("2048")))
            .check(isCompletelyAbove(withText("LEADERBOARD")))

        onView(withText("LEADERBOARD"))
            .check(matches(withId(R.id.leaderboardBtn)))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
            .check(isCompletelyBelow(withText("2048")))
            .check(isCompletelyBelow(withText("PLAY GAME")))
    }

    @Test
    fun navigationToLeaderboard() {
        onView(withId(R.id.leaderboardBtn))
            .perform(click())

        intended(hasComponent(LeaderboardActivity::class.qualifiedName))
    }

    @Test
    fun navigationToGame() {
        onView(withId(R.id.playGameBtn))
            .perform(click())

        intended(hasComponent(GameActivity::class.qualifiedName))
    }

    @Test
    fun navigationToLeaderboardThenBack() {
        onView(withId(R.id.leaderboardBtn))
            .perform(click())

        intended(hasComponent(LeaderboardActivity::class.qualifiedName))

        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withText("2048"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun navigationToGameThenBack() {
        onView(withId(R.id.playGameBtn))
            .perform(click())

        intended(hasComponent(GameActivity::class.qualifiedName))

        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withText("2048"))
            .check(matches(isDisplayed()))
    }
}