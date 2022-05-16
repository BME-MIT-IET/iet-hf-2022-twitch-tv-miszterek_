package peczedavid.nhf.activities

import androidx.room.Room
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import peczedavid.nhf.data.GameRun
import peczedavid.nhf.data.GameRunDao
import peczedavid.nhf.data.LeaderboardDatabase
import java.io.IOException
import kotlin.concurrent.thread

@RunWith(AndroidJUnit4::class)
class GameActivityTest {
    private lateinit var dbDao: GameRunDao
    private lateinit var db: LeaderboardDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            LeaderboardDatabase::class.java
        ).allowMainThreadQueries().build()
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
            id = 1,
            points = 10,
            seconds = 20)

        dbDao.insert(newRun)

        val testDbList = dbDao.getAll()
        assertThat(testDbList.get(0), equalTo(newRun))
    }
}