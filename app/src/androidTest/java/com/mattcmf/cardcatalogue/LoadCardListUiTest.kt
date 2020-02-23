package com.mattcmf.cardcatalogue


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import okhttp3.OkHttpClient
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoadCardListUiTest : KoinTest {

    private val okHttpClient: OkHttpClient by inject()

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(CardListActivity::class.java)

    @get:Rule
    var rule = OkHttpIdlingResourceRule(okHttpClient)

    private val robot = CardListRobot()

    /**
     * Test can be extended by using network mocking library or mocking out the network repo
     * to remove network dependency and use consistent data.
     * https://github.com/andrzejchm/RESTMock
     */
    @Test
    fun loadCardListUiTest() {
        robot.verifyCardDisplayed(CardListRobot.testCard(
            "Turtonator", "130", "Tackle", "Rare"
        ))
    }
}
