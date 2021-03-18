package com.gyeongmun.base.dagger.di.qualifier

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.TYPE,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION
)
annotation class FragmentScoped
