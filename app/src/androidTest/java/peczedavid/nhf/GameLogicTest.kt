package peczedavid.nhf


import android.widget.GridLayout
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.AdapterViewProtocol
import androidx.test.espresso.action.AdapterViewProtocols
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.assertion.PositionAssertions
import androidx.test.espresso.assertion.PositionAssertions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import peczedavid.nhf.activities.GameActivity

@RunWith(AndroidJUnit4::class)
class GameLogicTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(GameActivity::class.java)

    @Before
    fun init() {
        activityRule.scenario.onActivity { activity ->
            activity.gameBoard.uiTestMode = true
            activity.gameBoard.uiTestNextTileValue = 2
            activity.gameBoard.newGame()
        }
    }

    @After
    fun after() {
    }

    @Test
    fun loadTest() {
        onView(withId(R.id.newGameBtn))
            .check(matches(isDisplayed()))
            .check(matches(withText("NEW GAME")))
            .check(isCompletelyAbove(withId(R.id.gameBoard)))
            .check(isCompletelyLeftOf(withId(R.id.stepBackBtn)))

        onView(withId(R.id.stepBackBtn))
            .check(matches(isDisplayed()))
            .check(matches(withText("STEP BACK")))
            .check(isCompletelyAbove(withId(R.id.gameBoard)))
            .check(isCompletelyRightOf(withId(R.id.newGameBtn)))

        onView(withId(R.id.gameBoard))
            .check(matches(isDisplayed()))

        onView(withId(R.id.pointsTv))
            .check(matches(isDisplayed()))
            .check(isCompletelyBelow(withId(R.id.gameBoard)))
            .check(isCompletelyLeftOf(withId(R.id.timeTv)))
            .check(matches(withText("Points: 0")))

        onView(withId(R.id.timeTv))
            .check(matches(isDisplayed()))
            .check(isCompletelyBelow(withId(R.id.gameBoard)))
            .check(isCompletelyRightOf(withId(R.id.pointsTv)))
    }

    @Test
    fun tileWithValue2SpawnsInTheFirstPosition() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))
    }

    @Test
    fun swipeDown() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeDown())

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 13))))
            .check(isCompletelyBelow(withParent(withId(910 + 8))))
    }

    @Test
    fun swipeRight() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))
    }

    @Test
    fun swipeLeft() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeLeft())

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(isCompletelyAbove(withParent(withId(910 + 4))))
    }

    @Test
    fun swipeUp() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeLeft())

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(isCompletelyAbove(withParent(withId(910 + 4))))
    }

    @Test
    fun swipeRightTwice() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("4")))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))

        onView(withText("2"))
            .check(matches(isDisplayed()))
    }

}