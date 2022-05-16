package peczedavid.nhf

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
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
    private val time = 1000L

    @Before
    fun init() {
        activityRule.scenario.onActivity { activity ->
            activity.gameBoard.uiTestMode = true
            activity.gameBoard.uiTestNextTileValue = 2
            activity.gameBoard.newGame()
        }
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
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 12)), withParentIndex(0)))
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
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
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
        Thread.sleep(time)

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
            .perform(ViewActions.swipeUp())
        Thread.sleep(time)

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
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(isCompletelyAbove(withParent(withId(910 + 4))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))
            .check(matches(withText("4")))
    }

    @Test
    fun swipeDifferentDirections() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeDown())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(isCompletelyAbove(withParent(withId(910 + 4))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 12)), withParentIndex(0)))
            .check(isCompletelyBelow(withParent(withId(910 + 8))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 13))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 15)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 14))))
            .check(isCompletelyBelow(withParent(withId(910 + 11))))
            .check(matches(withText("2")))
    }

    @Test
    fun swipeRightTwicePoints() {
        activityRule.scenario.onActivity {
            it.gameBoard.points = 0
            it.drawBoard()
        }
        onView(withId(R.id.pointsTv))
            .check(matches(withText("Points: 0")))

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(withId(R.id.pointsTv))
            .check(matches(withText("Points: 4")))
    }

    @Test
    fun swipeRightThreeTimes() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))
            .check(matches(withText("4")))

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(isCompletelyAbove(withParent(withId(910 + 4))))
            .check(matches(withText("2")))
    }

    @Test
    fun swipeRightThreeTimesPoints() {
        onView(withId(R.id.pointsTv))
            .check(matches(withText("Points: 0")))

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(withId(R.id.pointsTv))
            .check(matches(withText("Points: 4")))
    }

    @Test
    fun newGameAfterTwoSwipes() {
        onView(withId(R.id.newGameBtn))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(withText("4"))
            .check(matches(isDisplayed()))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))

        onView(withId(R.id.newGameBtn))
            .perform(click())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))
            .check(isCompletelyLeftOf(allOf(withParent(withId(910 + 1)), withParentIndex(0))))
            .check(isCompletelyAbove(allOf(withParent(withId(910 + 4)), withParentIndex(0))))
    }

    @Test
    fun stepBackAfterTwoSwipes() {
        onView(withId(R.id.stepBackBtn))
            .check(matches(isDisplayed()))

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.parent_layout))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(withText("4"))
            .check(matches(isDisplayed()))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))

        onView(withId(R.id.stepBackBtn))
            .perform(click())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))
            .check(isCompletelyLeftOf(allOf(withParent(withId(910 + 1)), withParentIndex(0))))
            .check(isCompletelyAbove(allOf(withParent(withId(910 + 4)), withParentIndex(0))))

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))
            .check(isCompletelyRightOf(allOf(withParent(withId(910 + 2)), withParentIndex(0))))
            .check(isCompletelyAbove(allOf(withParent(withId(910 + 7)), withParentIndex(0))))
    }

    @Test
    fun swipeThenSwipeBack() {
        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(matches(isDisplayed()))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(isCompletelyAbove(withParent(withId(910 + 4))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 7))))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeLeft())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(isCompletelyAbove(withParent(withId(910 + 4))))
            .check(matches(withText("4")))

        onView(allOf(withParent(withId(910 + 1)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 0))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 2))))
            .check(isCompletelyAbove(withParent(withId(910 + 5))))
            .check(matches(withText("2")))
    }

    @Test
    fun timer() {
        activityRule.scenario.onActivity { it.resetTimer() }
        Thread.sleep(100)

        onView(withId(R.id.timeTv))
            .check(matches(withText("00:00:01")))
        Thread.sleep(1100)

        onView(withId(R.id.timeTv))
            .check(matches(withText("00:00:02")))
    }

    @Test
    fun swipeRightOnRowOfSameTiles() {
        activityRule.scenario.onActivity {
            it.gameBoard.spawnRandom()
            it.gameBoard.spawnRandom()
            it.gameBoard.spawnRandom()

            it.drawBoard()
        }

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 1)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 0))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 2))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 2)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 1))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 3))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 2)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 1))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 3))))
            .check(matches(withText("4")))

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(matches(withText("4")))

    }

    @Test
    fun doubleSwipeRightOnRowOfSameTiles() {
        activityRule.scenario.onActivity {
            it.gameBoard.spawnRandom()
            it.gameBoard.spawnRandom()
            it.gameBoard.spawnRandom()

            it.drawBoard()
        }

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 1)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 0))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 2))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 2)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 1))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 3))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(matches(withText("2")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(allOf(withParent(withId(910 + 0)), withParentIndex(0)))
            .check(isCompletelyLeftOf(withParent(withId(910 + 1))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 2)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 1))))
            .check(isCompletelyLeftOf(withParent(withId(910 + 3))))
            .check(matches(withText("2")))

        onView(allOf(withParent(withId(910 + 3)), withParentIndex(0)))
            .check(isCompletelyRightOf(withParent(withId(910 + 2))))
            .check(matches(withText("8")))
    }

    @Test
    fun doubleSwipeRightOnRowOfSameTilesPoints() {
        activityRule.scenario.onActivity {
            it.gameBoard.spawnRandom()
            it.gameBoard.spawnRandom()
            it.gameBoard.spawnRandom()

            it.drawBoard()
        }

        onView(withId(R.id.pointsTv))
            .check(matches(withText("Points: 0")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(withId(R.id.pointsTv))
            .check(matches(withText("Points: 8")))

        onView(withId(R.id.gameBoard))
            .perform(ViewActions.swipeRight())
        Thread.sleep(time)

        onView(withId(R.id.pointsTv))
            .check(matches(withText("Points: 16")))
    }
}