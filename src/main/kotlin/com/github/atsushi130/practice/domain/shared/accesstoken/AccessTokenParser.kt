package com.github.atsushi130.practice.domain.shared.accesstoken

import com.github.atsushi130.practice.domain.models.AccessToken
import com.github.atsushi130.practice.exception.AuthenticationException
import com.github.atsushi130.practice.extension.isOdd

class AccessTokenParser {

    companion object: Parser<AccessToken> {
        override fun parseFrom(authenticationHeader: String): AccessToken {

            val parsedHeader = authenticationHeader
                .split(" ")
                .asSequence()
                .mapIndexed { index, value ->
                    if (index.isOdd) {
                        mapOf("key" to value)
                    } else {
                        mapOf("value" to value)
                    }
                }
                .reduce { sum, map ->
                    sum + map
                }

            val bearerToken = parsedHeader["Bearer"] ?: throw AuthenticationException.BearTokenNotExists()
            val permission  = PermissionParser.parseFrom(bearerToken)

            return AccessToken(bearerToken, permission)
        }


    }
}