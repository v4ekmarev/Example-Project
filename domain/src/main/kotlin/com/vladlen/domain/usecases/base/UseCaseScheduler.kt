package com.vladlen.domain.usecases.base

import io.reactivex.Scheduler


data class UseCaseScheduler(val run: Scheduler, val post: Scheduler)
