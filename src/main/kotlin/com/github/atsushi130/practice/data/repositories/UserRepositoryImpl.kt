package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.dataAccessObjects.UserDao
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl: UserRepository {

    @Autowired
    private lateinit var dao: UserDao

    override fun findBy(id: String): User? {
        return this.dao.findBy(id)?.let {
            it.toModel()
        }
    }

    override fun findFunsBy(itemId: Int): List<User> {
        return this.dao.findFunsBy(itemId)
            .map { it.toModel() }
    }

}