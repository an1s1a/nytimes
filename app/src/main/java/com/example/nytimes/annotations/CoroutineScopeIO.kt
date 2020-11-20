package com.example.nytimes.annotations

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoroutineScopeIO