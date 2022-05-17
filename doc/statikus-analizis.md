# :bookmark_tabs: Statikus analízis

SonarLint/SonarCloud által talált hibák:
- :radioactive: CodeSmell: Túl komplex függvény az input kezelésnél (onFling)
- :radioactive: CodeSmell: Túl komplex függvény a GameBoard::move(direcetion: Direction)

Megoldás mindkettőre: kisebb függvényekre bontás, úgy, hogy esetleg olvashatóbb is legyen a kód.
Kódrészletek az olvashatóbb vátlozatból:
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

# :bookmark_tabs: Code review
A kódbázis mérete miatt az egészt át tudtuk nézni. 2 dolgot találtunk, amit változtattunk.(a statikus analízis után már)

## :label: toPixels()
A GameActivity::toPixels(Int) függvényt áthelyeztük a **Utils** osztályba, mivel ez egy amolyan segédfüggvény, hasonló szerepű, mint az index konvertáló fügvények, amik szintén a Utils-ban vannak. (A Utils osztály segédfüggvények gyűjteménye.) Annyi változott, hogy most paraméterben át kell adni a pixelsűrűséget :arrow_right: Utils::toPixels(Int, Float)

## :label: sum
A **MovementInfo** osztályban volt egy property, ami feleslegesen volt elvárva a konstruktorban, mivel az kiszámolható a meglévő adatokból. Írtunk egy getter-t hozzá. Így a szükséges kostruktorbeli paraméterek számát is csökkentettük. :+1:
```kotlin
data class MovementInfo (
    val start: Point,
    val end: Point,
    val startValue: Int,
    val endValue: Int,
) {
    val sum : Boolean
        get() = startValue != endValue
}
``` 