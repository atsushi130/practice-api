package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.models.Reaction
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.ItemRepository
import java.util.*

class ItemRepositoryImpl {
    companion object: ItemRepository {

        override fun findBy(id: Int): Item? {
            return null
            // val registeredUser = User("atsushi130", emptyList())
            // val latestReactionUser = User("tester1", emptyList())
            // val wants = Reaction(true, 5)
            // val haves = Reaction(false, 5)
            // return Item(1, "NOMOS", "NOMOS Metro wristwatch", registeredUser, latestReactionUser, wants, haves)
        }

        override fun findBy(userId: String): List<Item> {
            return emptyList()
            // val registeredUser1 = User("atsushi130", emptyList())
            // val registeredUser2 = User("tester1", emptyList())
            // val registeredUser3 = User("tester2", emptyList())
            // val latestReactionUser = User("tester1", emptyList())
            // val wants = Reaction(true, 5)
            // val haves = Reaction(false, 5)
            // return Arrays
            //     .asList(
            //         Item(1, "NOMOS", "NOMOS Metro wristwatch", registeredUser1, latestReactionUser, wants, haves),
            //         Item(2, "NOMOS", "NOMOS Metro wristwatch", registeredUser2, latestReactionUser, wants, haves),
            //         Item(3, "NOMOS", "NOMOS Metro wristwatch", registeredUser3, latestReactionUser, wants, haves),
            //         Item(4, "NOMOS", "NOMOS Metro wristwatch", registeredUser1, latestReactionUser, wants, haves)
            //     )
            //     .filter {
            //         it.registeredUserId == user.id
            //     }
        }

        override fun getLatestItems(): List<Item> {
            return emptyList()
            // val registeredUser = User("atsushi130", emptyList())
            // val latestReactionUser = User("tester1", emptyList())
            // val wants = Reaction(true, 5)
            // val haves = Reaction(false, 5)
            // return Arrays
            //     .asList(
            //         Item("1", "NOMOS", "NOMOS Metro wristwatch", registeredUser, latestReactionUser, wants, haves),
            //         Item("2", "NOMOS", "NOMOS Metro wristwatch", registeredUser, latestReactionUser, wants, haves),
            //         Item("3", "NOMOS", "NOMOS Metro wristwatch", registeredUser, latestReactionUser, wants, haves),
            //         Item("4", "NOMOS", "NOMOS Metro wristwatch", registeredUser, latestReactionUser, wants, haves)
            //     )
        }
    }
}