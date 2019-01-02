package com.github.atsushi130.practice.domain.models

interface Version {
    val version: String
    val splitted: List<Int>
        get() {
            val splitted = this.version
                .split(".")
                .map { it.toIntOrNull() ?: 0 }
            return (0..2)
                .map { splitted.getOrNull(it) ?: 0 }
        }
    val major: Int
        get() = this.splitted.first()
    val minor: Int
        get() = this.splitted[1]
    val patch: Int
        get() = this.splitted.last()
}

data class OSVersion(override val version: String): Version

interface AppVersion: Version {

    val recommended: AppVersion
    val required: AppVersion

    val meetsRecommendedVersion: Boolean
        get() = this.meetsVersion(this.recommended)

    val meetsRequiredVersion: Boolean
        get() = this.meetsVersion(this.required)

    private fun meetsVersion(targetVersion: AppVersion): Boolean {
        this.splitted.zip(targetVersion.splitted)
                .forEach { (version, requiredVersion) ->
                    if (version > requiredVersion) return true
                    if (version < requiredVersion) return false
                }
            // equals
            return true
    }
}

data class iOSAppVersion(override val version: String): AppVersion {
    override val recommended: iOSAppVersion
        get() = iOSAppVersion("0.0.1")
    override val required: iOSAppVersion
        get() = iOSAppVersion("0.0.1")
}

data class AndroidAppVersion(override val version: String): AppVersion {
    override val recommended: AndroidAppVersion
        get() = AndroidAppVersion("1.0.0")
    override val required: AndroidAppVersion
        get() = AndroidAppVersion("1.0.0")
}