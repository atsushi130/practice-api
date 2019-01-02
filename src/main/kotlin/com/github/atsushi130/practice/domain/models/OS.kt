package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.extension.EnumFindable

enum class OS {

    iOS,
    Android;

    companion object: EnumFindable<OS>
}