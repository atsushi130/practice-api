package com.github.atsushi130.practice.common

class NonLoginRequestUri {

    companion object {

        private val uriList: List<String>
            get() {
                return listOf(
                    "/sign_up",
                    "/sign_in"
                )
            }

        fun contains(uri: String): Boolean {
            return this.uriList.contains(uri)
        }
    }
}