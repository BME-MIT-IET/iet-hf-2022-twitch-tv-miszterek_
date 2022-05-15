# :sparkler: UI Tesztek

Androidon a teszteket két nagy kategóriára tudjuk bontani:
- **Local tests**: Ezek, olyan tesztek, melyekhez nem szükséges Android eszköz, mert a fejlesztő eszközén vagy CI rendszeren is tudnak futni. Általában az egységtesztek tartoznak ebbe a kategóriába.
- **Instrumented tests**: Ezek olyan tesztek, melyekhez szükség van fizikai vagy virtuális Android eszközre. A tesztek az Android eszközön futnak. A UI tesztek ide tartoznak.

Ebben a feladatban a UI teszteket készítettem el és dokumentáltam le. A tesztek futtatása előtt néhány beállításra szükség van az eszközön. 

## :exclamation: Előkövetelmények:

0. :iphone: Fizikai Android eszköz vagy Emulátor
1. :computer: Developer mód bekapcsolása
2. :boom: Animációk kikapcsolása:
    - Window animation scale :arrow_right: **Animation off**
    - Transition animation scale :arrow_right: **Animation off**
    - Animator duration scale :arrow_right: **Animation off**

## :point_down: Tesztek végrehajtása:
```bash
./gradlew connectedAndroidTest
```

## :round_pushpin: Navigációval kapcsolatos teszt esetek:

| Teszt eset neve | Leírás | Várt eredmény | :+1: / :-1: |
|:---------------:|:------:|:-------------:|:-----------:|
| appLoadsProperly | Alkalmazás indítása | Középen megjelenik a **2048** felirat. Megjelennek alatta a **PLAY GAME** és **LEADERBOARD** gombok. | :+1: |
| navigationToLeaderboard | Átlépés a ranglista képernyőre | Megnyílik a **LeaderboardActivity**. | :+1: | 
| navigationToGame | Átlépés a játékba | Megnyílik a **GameActivity** és elindul a játék. | :+1: |
| navigationToLeaderboardThenBack | Átlép a rangilsta képernyőre, majd vissza | Megnyílik a **LeaderboardActivity**, majd bezárja és visszalép az eredeti Activity-be. | :+1: |
| navigationToGameThenBack | Átlép a játék képernyőre, majd vissza | Megnyílik a **GameActivity** és elindul a játék, majd bezárja és visszalép az eredeti Activity-be. | :+1: |

## :video_game: Játéklogikával kapcsolatos teszt esetek:

| Teszt eset neve | Leírás | Várt eredmény | :+1: / :-1: |
|:---------------:|:------:|:-------------:|:-----------:|
| loadTest | Játék betöltődés, és indítás | Közvetlenül a **GameActivity** indítása. Megjelennek a gombok, a játéktér és a feliratok a megfelelő helyen. | :+1: |
| tileWithValue2SpawnsInTheFirstPosition | Tile megjelenik a bal felső sarokban | Egy darab csempe jelenik meg a bal felső helyen (0. index) **2*-es felirattal. | :+1: |
| swipeDown | Lefelé suhintás | A 0. indexen lévő **2**-es feliratú Tile lemegy a 12. pozícióra, majd megjelenik egy új Tile a 0. indexen. | :+1: |
| swipeRight | Jobbra suhintás | A 0. indexen lévő **2**-es feliratú Tile átmegy a 3. pozícióra, majd megjelenik egy új Tile a 0. indexen. | :+1: |
| swipeLeft | Balra suhintás | A 0. indexen lévő **2**-es feliratú Tile marad a helyén és nem jelenik meg egy új Tile sem. | :+1: |
| swipeUp | Felfelé suhintás | A 0. indexen lévő **2**-es feliratú Tile marad a helyén és nem jelenik meg egy új Tile sem. | :+1: |
| swipeRightTwice | Jobbra 2 suhintás | A 0. indexen lévő Tile a jobb felső sarokba kerül, megjelenik bal felül egy **2**-es értékű Tile. Majd a két Tile összeadódik a jobb felső sarokban, az új értékük **4** lesz és megjelenik a bal felső sarokban az új Tile. A sorrend a következő lesz: :two: :zero: :zero: :four: | :+1: |
| swipeDifferentDirections | Két különböző irányba suhintás | A 0. indexen lévő Tile jobbra kerül és megjelenik egy új Tile az eredeti helyén, majd a második suhintáskor a megjelent és az eredeti Tile az utolsó sorban kerülnek. | :+1: |
| swipeRightTwicePoints | Jobbra 2 suhintás pontszám vizsgálat | Eredetileg 0 a játékos pontszáma, majd dupla suhintáskor összeadódik 2 db **2**-es értékű Tile. Ekkor a játékonak **4** lesz az új pontszáma | :+1: |
| swipeRightThreeTimes | Jobbra 3 suhintás | Első suhintáskor jobbra kerül egy Tile, megjelenik egy új **2**-es értékkel. Másdoik suhintáskor összeadódik a 2 db **2**-es értékű Tile és megjelenik egy új. Harmadik suhintáskor Kialakul a következő sorrend: :two: :zero: :two: :four: | :+1: |
| swipeRightThreeTimesPoints | Jobbra 3 suhintás pontszám vizsgálat | Első suhintás után a sorrend: :two: :zero: :zero: :two:. Második után: :two: :zero: :zero: :four:. Harmadik után pedig: :two: :zero: :two: :four:. Egy összeadás történik: **2 + 2 = 4**, tehát a játék pontszáma 4 lesz. | :+1: |
| newGameAfterTwoSwipes | Kettő suhintás egy irányba, újrakezdés | Kettő suhintáskor összeadódik 2 Tile és megjelenik egy űj, majd **NEW GAME** hatására, visszaál minden az eredeti pozícióba, így a sorrend a következő lesz: :two: :zero: :zero: :zero: | :+1: |
| stepBackAfterTwoSwipes | Kettő egyirányú suhintás után visszalépés | Első suhintás után a sorrend: :two: :zero: :zero: :two:. Második után: :two: :zero: :zero: :four:. Visszalépés hatására eltűnik a **4** értékű Tile és visszakerül 2 db **2** értékű a következő sorrendben: :two: :zero: :zero: :two: | :+1: |
| swipeThenSwipeBack | Jobbra, majd balra suhintás | Első sunhintás után a sorrend: :two: :zero: :zero: :two:. Második után pedig: 
:four: :two: :zero: :zero:. Négyes után 2 jön, mivel most az 1. index a legkisebb nem foglalt pozíció. | :+1: |

## :information_source: Előkészületek, változtatások

:pencil2: A tesztek elkészítése előtt publikussá kellett tennem, több függvényt, mert anélkül nem vagy csak nagyon nehezen tudtam volna létrehozni több fontos speciális esetet. 

:game_die: Szükség volt a program determinisztikussá tételére is. Ezt úgy értem el, hogy felvettem a **GameBoard** osztályba egy flag-et, melyet a UI tesztelés során állítok be. A flag értékét random számítások esetén veszem figyelembe. UI tesztelés módban a játék mindig a legkisebb szabad indexű helyre próbálja létrehozni az új csempét. 

![Game board Tile indexek](images/gameboard_indices.png)

:two: A csempe értéke eredeti játék során **2** vagy **4** lehet véletlenszerűen, tesztelés módban ezt fix **2**-re állítottam. Ez a kényszer nem csökkenti a tesztek hasznosságát, épp ellenkezőleg egyszerűbben lehet elkészíteni és kipróbálni speciális eseteket.



