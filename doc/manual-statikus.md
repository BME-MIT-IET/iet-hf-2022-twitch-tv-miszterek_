# :notebook: Manuális tesztelés

## Tesztek leírása, végrehajtása, eredménye
---
### :page_facing_up: **Teszt esetek:**
- A tesztelés során 2 féle manuális tesztelési fajtát alkalmaztam:
  - BlackBox tesztelés
  - Exploratory tesztelés

| TestCase ID | Leírás|
|:-----------:|:-----:|
|MT01| Futó alkalmazásnál képernyő elforgatása|
|MT02| Két egyező "kocka" egymásba húzása|
|MT03| Két nem egyező kocka egymásnak lökése|
|MT04| Játékból kilépés és visszalépés|
|MT05| Játék vége nyerés/vesztés esetén|
|MT06| StepBack új játék indításkor|
|MT07| StepBack megnyomása játék közben|
|MT08| StepBack megnyomása játék közben többször|

---
### :page_facing_up: **Tesztek végrehajtása:**
Az alábbiakban összefoglalom, hogy az egyes tesztesetek végrehajtásához milyen lépéseket kell végrehajtani.

**MT01:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. A készülék/szimulátor elforgatása

**MT02:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. Ujj mozgatása a játékterületen valamelyik irányba
5. Keletkező kockák (ha azonosak) egymásba húzása

**MT03:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. Ujj mozgatása a játékterületen valamelyik irányba
5. Keletkező kockák (ha nem azonosak) egymásba húzása

**MT04:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. Pár lépés végrehajtása
5. Alkalmazás bezárása
6. első és második pont megismétlése 

**MT05:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. Lépés valamilyen irányba
5. lépések ismétlése, amíg már nem marad opció (nyerés/vesztés)

**MT06:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. StepBack gomb egy/többszöri megnyomása

**MT07:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. Egy/Több lépés a játékban
5. StepBack Gomb egyszeri megnyomása

**MT08:**
1. alkalmazás elindítása
2. Play Game menüpont kiválasztása
3. New Game gomb megnyomása
4. Egy/Több lépés a játékban
5. StepBack Gomb megnyomása egyszer/többször

Tesztadatokra a tesztelés végrehajtásához egyik esetben sem volt szükség.

### :page_facing_up: **Tesztek eredménye:**
|TestCase ID|Expected Result|Actual Result| :+1: / :-1:|
|:---------:|:-------------:|:-----------:|:---:|
|MT01| Fixált képernyőméret :arrow_right: nem omlik össze az alkalmazás| As Expected| :+1: |
|MT02| Értékük összeadódik és összecsúsznak, korábbi kettő eltűnik| As Expected| :+1:|
|MT03|Nem csúsznak össze, csak összeütköznek| As Expected| :+1: |
|MT04| Elmentődik a korábbi állapot, StapBack is működik, számláló korábbi állapotról indul ahogy a pontok is| As Expected| :+1:|
|MT05|StepBack nem működik, timer megáll, csak új játékot tudunk kezdeni|As Expected| :+1: |
|MT06| A korábbi állapotot nem tudjuk betölteni, mert új játék kezdődött|Korábbi állapotot nem tudja betölteni, de nincs disabled állapotban a gomb. Becsapja a játékost.| :-1: |
|MT07| A jelenlegi lépés előtti lépést betölti| Betölti a legutolsó lépést, a gomb nem disabled| :+1: |
|MT08| Betölti a korábbi lépéseket| A jelenlegi lépést megelőző lépést tölti csak be, ezután nem csinál több dolgot a gomb, de nem disabled| :-1:|
|||**Összesen:**| 6/8 |

## :pushpin: Összefoglalás
- A tesztelés során a specifikáció hiányában sajnos pontos lefedettség vizsgálatot nem tudtam végrehajtani.
- A tesztek többségénél az egyes felhasználók által használt/elvárt viselkedésre próbáltam koncentrálni.
- A korábban fentebb említett hibákat érdemes lehet kijavítani a biztonságosabb és irányítottabb felhasználói interkació elvárása érdekében.
- A StepBack gomb disabled állapotának néhány helyen történő helytelen nem beállítása biztonsági hibákat okozhat a rendszerre vonatkozólag, ha az adott részen mondjuk egy adatbázishoz való hozzáférést végzünk, vagy időigényesebb problémát
- Érdemes lehet egy stresszteszt elvégzése az egyes pontokra vonatkozólag.
