package peczedavid.nhf.model

import junit.framework.TestCase.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo

import org.junit.Test
import peczedavid.nhf.animation.MovementInfo
import peczedavid.nhf.model.Direction
import peczedavid.nhf.model.GameBoard
import peczedavid.nhf.model.Point
import peczedavid.nhf.model.Utils

class GameBoardTest {

    private var testGameBoard = GameBoard()

    //a GameBoard osztály initBoard() függvényét teszteli
    //összahesonlítja egy manuálisan létrehozott mátrixxal
    @Test
    fun initBoardTest() {

        testGameBoard.initBoard()

        var gameBoardFields: MutableList<Int> = mutableListOf()

        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))

        assertThat(gameBoardFields, equalTo(testGameBoard.gameBoard))
    }

    //a GameBoard osztály resetSummedHelper() függvényét teszteli
    //összahesonlítja egy manuálisan létrehozott mátrixxal
    @Test
    fun resetSummedHelperTest() {

        testGameBoard.resetSummedHelper()

        var summedHelperTestList: MutableList<Boolean> = mutableListOf()

        summedHelperTestList.addAll(mutableListOf(false, false, false, false))
        summedHelperTestList.addAll(mutableListOf(false, false, false, false))
        summedHelperTestList.addAll(mutableListOf(false, false, false, false))
        summedHelperTestList.addAll(mutableListOf(false, false, false, false))

        assertThat(summedHelperTestList, equalTo(testGameBoard.summedHelper))
    }

    //A moveTile() függvény visszatérési értékét teszteli
    //abban az esetben, ha a kapott startValue 0
    @Test
    fun moveTileWith0StartValueTest() {

        val testStartValue = Point(0F, 0F)
        val testEndValue = testStartValue

        var movementInfoWith0StartValue =
        testGameBoard.moveTile(testStartValue, testEndValue)

        var testMovementInfoWith0StartValue = MovementInfo(testStartValue, testEndValue, 0, 0)

        assertThat(movementInfoWith0StartValue, equalTo(testMovementInfoWith0StartValue))
    }

    //a GameBoard osztály getValue() függvényét teszteli
    //összahesonlítja egy manuálisan létrehozott 0 "tartalmú elemmel"
    @Test
    fun getValueTest() {

        testGameBoard.initBoard()
        var testGameBoardValue = testGameBoard.getValue(2, 2)
        assertEquals(testGameBoardValue, 0)
    }

    //a GameBoard osztály saveGameBoard() függvényét teszteli
    //megnézi, hogy a pointsBefore és a points változó értéke egyenlővé válik e a mentés hatására
    @Test
    fun saveGameBoardTest() {

        testGameBoard.pointsBefore = 10
        testGameBoard.points = 20

        testGameBoard.saveGameBoard()

        assertEquals(testGameBoard.pointsBefore, testGameBoard.points)
    }

    //a GameBoard osztály move(direction) és a pushTileDown(i, j) függvényét teszteli
    //összahesonlítja hogy az egész tábla mozgatása és csak 1 elem mozgatása ugyan azt az eredményt hozza-e
    @Test
    fun moveTest() {

        var gameBoardFields: MutableList<Int> = mutableListOf()

        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 2))
        gameBoardFields.addAll(mutableListOf(0, 0, 0, 0))

        var exampleGameBoard = GameBoard()
        exampleGameBoard.initBoard()

        exampleGameBoard.gameBoard = gameBoardFields
        testGameBoard = exampleGameBoard.clone()

        GameBoard.gameEndHelper = 0
        var movedField = testGameBoard.move(Direction.DOWN)

        var exampleMove = exampleGameBoard.pushTileDown(2, 3)

        println("asd")
        assertThat(movedField.get(Utils.getIndex(2, 3)), equalTo(exampleMove))
    }
}