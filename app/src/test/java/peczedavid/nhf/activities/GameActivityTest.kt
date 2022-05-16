package peczedavid.nhf.activities

import androidx.room.Room
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import peczedavid.nhf.data.GameRun
import peczedavid.nhf.data.GameRunDao
import peczedavid.nhf.data.LeaderboardDatabase
import java.io.IOException
import kotlin.concurrent.thread

@RunWith(RobolectricTestRunner::class)
class GameActivityTest {
    private lateinit var dbDao: GameRunDao
    private lateinit var db: LeaderboardDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            LeaderboardDatabase::class.java
        ).build()
        dbDao = db.gameRunDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun saveRunToDatabaseTest() {
        val newRun = GameRun(
            points = 10,
            seconds = 20)

        thread {
            dbDao.insert(newRun)
            val testDBlist = dbDao.getAll()
            val index = testDBlist.indexOf(newRun)
            assertThat(testDBlist[index], equalTo(newRun))
        }



    }
}