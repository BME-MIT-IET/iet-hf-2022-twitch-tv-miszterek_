package peczedavid.nhf.model

import android.util.Log
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsEqual.equalTo

import org.junit.After
import org.junit.Before
import org.junit.Test
import peczedavid.nhf.animation.MovementInfo

class GameBoardTest {

    @Test
    fun initBoardTest() {

        var testGameBoard = GameBoard()
        testGameBoard.initBoard()


        var gameBoardFields: MutableList<Int> = mutableListOf()

        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))

        assertThat(gameBoardFields, equalTo(testGameBoard.gameBoard))
    }

    @Test
    fun resetSummedHelperTest() {

        var testGameBoard = GameBoard()
        testGameBoard.resetSummedHelper()


        var summedHelperTestList: MutableList<Boolean> = mutableListOf()

        summedHelperTestList.addAll(mutableListOf(false, false, false, false))
        summedHelperTestList.addAll(mutableListOf(false, false, false, false))
        summedHelperTestList.addAll(mutableListOf(false, false, false, false))
        summedHelperTestList.addAll(mutableListOf(false, false, false, false))

        assertThat(summedHelperTestList, equalTo(testGameBoard.summedHelper))
    }

    @Test
    fun moveTileWith0StartValueTest() {
        var testGameBoard = GameBoard()

        val testStartValue = Point(0F, 0F)
        val testEndValue = testStartValue

        var movementInfoWith0StartValue =
        testGameBoard.moveTile(testStartValue, testEndValue)

        var testMovementInfoWith0StartValue = MovementInfo(testStartValue, testEndValue, 0, 0)

        assertThat(movementInfoWith0StartValue, equalTo(testMovementInfoWith0StartValue))
    }

}