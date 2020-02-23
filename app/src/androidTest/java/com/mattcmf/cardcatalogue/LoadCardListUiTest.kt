package com.mattcmf.cardcatalogue


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoadCardListUiTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(CardListActivity::class.java)

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
