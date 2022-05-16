# Unit-tesztek

A unit-teszteket Android Studioban végeztük az IDE beépített tesztelési lehetőségeivel, és könyvtáraival (pl. JUnit).

## Az adatbázissal kapcsolatos teszteset

| Teszt eset neve | Leírás | :heavy_check_mark: / :x: |
|:---------------:|:------:|:-----------:|
| saveRunToDatabaseTest | Egy játék során szerzett pontok és idő mentése az adatbázisba | :heavy_check_mark: |

## A játéklogikával kapcsolatos tesztesetek

| Teszt eset neve | Leírás | :heavy_check_mark: / :x: |
|:---------------:|:------:|:-----------:|
| initBoardTest | leírás | :heavy_check_mark: |
| resetSummedHelperTest | leírás | :heavy_check_mark: | 
| moveTileWith0StartValueTest | leírás | :heavy_check_mark: |
| getValueTest | leírás | :heavy_check_mark: |
| saveGameBoardTest | leírás | :heavy_check_mark: |
| moveTest | leírás | :heavy_check_mark: |

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


