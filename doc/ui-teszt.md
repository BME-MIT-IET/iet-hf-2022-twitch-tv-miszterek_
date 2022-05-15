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
| appLoadsProperly | Alkalmazás indítása | Középen megjelenik a **2048** felirat. Megjelennek alatta a **PLAY GAME** és **LEADERBOARD** gombok| :+1: |
| navigationToLeaderboard | Átlépés a ranglista képernyőre | Megnyílik a **LeaderboardActivity** | :+1: | 
| navigationToGame | Átlépés a játékba | Megnyílik a **GameActivity** és elindul a játék | :+1: |
| navigationToLeaderboardThenBack | Átlép a rangilsta képernyőre, majd vissza | Megnyílik a **LeaderboardActivity**, majd bezárja és visszalép az eredeti Activity-be | :+1: |
| navigationToGameThenBack | Átlép a játék képernyőre, majd vissza | Megnyílik a **GameActivity** és elindul a játék, majd bezárja és visszalép az eredeti Activity-be | :+1: |

## :video_game: Játéklogikával kapcsolatos teszt esetek:

| Teszt eset neve | Leírás | Várt eredmény | :+1: / :-1: |
|:---------------:|:------:|:-------------:|:-----------:|
