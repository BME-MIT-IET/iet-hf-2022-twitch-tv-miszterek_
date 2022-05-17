# Statikus analízis

SonarLint/SonarCloud által talált hibák:
- CodeSmell: Túl komplex függvény az input kezelésnél (onFling)
- CodeSmell: Túl komplex függvény a GameBoard::move(direcetion: Direction)

Megoldás mindkettőre: kisebb függvényekre bontás, úgy, hogy esetleg olvashatóbb is legyen a kód.

```kotlin
when(direction) {
    Direction.RIGHT -> moveBoardRight()

    Direction.LEFT -> moveBoardLeft()

    Direction.UP -> moveBoardUp()

    Direction.DOWN ->  moveBoardDown()
}
```

```kotlin
return handleFling(downEvent, moveEvent, velocityX, velocityY, diffX, diffY)

private fun handleFling(downEvent: MotionEvent?, moveEvent: MotionEvent?, velocityX: Float, velocityY: Float, diffX: Float, diffY: Float) : Boolean {
    return if (abs(diffX) > abs(diffY)) {
        handleHorizontalFling(downEvent, moveEvent, velocityX, velocityY, diffX)
    } else {
        handleVerticalFling(downEvent, moveEvent, velocityX, velocityY, diffY)
    }
}
```

Így mind a kettő függvény komplexitása 15 alatt van. A kód pedig kicsit hosszabb, de olvashatóbb lett.