package com.mattcmf.cardcatalogue

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.mattcmf.cardcatalogue.data.Card
import com.mattcmf.cardcatalogue.data.response.Attack
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf


class CardListRobot : BaseRobot() {

    fun verifyCardDisplayed(card: Card, position: Int = 0): CardListRobot {
        onView(withId(R.id.cardListRecycleView))
            .check(matches(atPosition(position, hasDescendant(cardNameMatcher(card.name)))))
            .check(matches(atPosition(position, hasDescendant(cardHpMatcher(card.hp)))))
            .check(matches(atPosition(position, hasDescendant(cardRarity(card.rarity)))))
            .check(matches(atPosition(position, hasDescendant(cardAttacks(card.attacks[0].name)))))
        return this
    }

    companion object {
        fun cardNameMatcher(name: String): Matcher<View> =
            allOf(withId(R.id.cardName), withText(name))

        fun cardHpMatcher(hp: String): Matcher<View> = allOf(withId(R.id.cardHp), withText(hp))
        fun cardRarity(rarity: String): Matcher<View> =
            allOf(withId(R.id.cardRarity), withText(rarity))

        fun cardAttacks(attack: String): Matcher<View> =
            allOf(withId(R.id.cardAttacks), withText(attack))

        fun testCard(name: String, hp: String, attackName: String, rarity: String): Card = Card(
            id = "000",
            name = name,
            imageURl = "empty",
            hp = hp,
            attacks = listOf(Attack(name = attackName)),
            rarity = rarity
        )
    }
}
