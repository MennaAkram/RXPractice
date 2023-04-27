package com.example.myapplication

import io.reactivex.rxjava3.subjects.BehaviorSubject

class RXBus {
    companion object{
        val behaviorSubject = BehaviorSubject.create<Any>()
    }
}