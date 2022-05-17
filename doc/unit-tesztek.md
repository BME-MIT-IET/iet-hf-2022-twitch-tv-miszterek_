# Unit-tesztek

A unit-teszteket Android Studioban végeztük az IDE beépített tesztelési lehetőségeivel, és könyvtáraival (pl. JUnit).

## Az adatbázissal kapcsolatos teszteset

| Teszt eset neve | Leírás | :x: / :heavy_check_mark: |
|:---------------:|:------:|:-----------:|
| saveRunToDatabaseTest | Egy játék során szerzett pontok és idő mentése az adatbázisba | :heavy_check_mark: |

Ez a teszt az adatbázis funckiünalitását teszteli. Először létrehozunk egy példa objektumot, amit beleírunk az adatbázisba.
Ezután az adatbázisból lekértük az összes (ami most csak egy darab) objektumot listába rendezve. Majd a lista első elemét összehasonlítjuk az eredetileg létrehozott objektummal.
 - A lefedettség vizsgálatnál ez a teszt 0%-os eredményt adott, mert az IntelliJ IDEA ellenőrző helyett a JaCoCo-t kellett használjuk, mert csak ezzel fordult le a teszt. Viszont ez nem tudta leellenőrizni rendesen, hogy mekkora részt teszteli a függvény a kódból.

## A játéklogikával kapcsolatos tesztesetek

| Teszt eset neve | Leírás | :x: / :heavy_check_mark: |
|:---------------:|:------:|:-----------:|
| initBoardTest | A `GameBoard` objektum `gameBoard` listájának inicializálását teszteli | :heavy_check_mark: |
| resetSummedHelperTest | A `GameBoard` objektum `summedHelper` listájának visszaállítását teszteli | :heavy_check_mark: | 
| moveTileWith0StartValueTest | A `moveTile()` függvényt teszteli abban az esetben, ha a kapott `startValue` 0 | :heavy_check_mark: |
| getValueTest | A `GameBoard` `getValue` függvényét teszteli  | :heavy_check_mark: |
| saveGameBoardTest | A `GameBoard` pontszámának mentését ellenőrző teszteset | :heavy_check_mark: |
| moveTest | Egy mezőn lévő érték lefelé történő mozgatását ellenőrző teszteset | :heavy_check_mark: |

## Az Android Studio által generált Gradle test report

![](images/teszt_osszesites.png)

## Az Android Studio által generált Coverage Summary

Az `nhf` package szintjén:

![](images/teszt_coverage_1.png)

Az `nhf.model` package szintjén:

![](images/teszt_coverage_2.png)

## Az Android Studio által generált Overall Coverage Summary

Az `nhf` package szintjén:

![](images/coverage_summary_1.png)

Az `nhf.model` package szintjén:

![](images/coverage_summary_2.png)

Ezek a lefedettségi adatok mind csak a játéklogikát tesztelő függvényekre vonatkoznak, a már korábban említett JaCoCo-s probléma miatt az adatbázis teszt nem tudott belekerülni a statisztikába.

