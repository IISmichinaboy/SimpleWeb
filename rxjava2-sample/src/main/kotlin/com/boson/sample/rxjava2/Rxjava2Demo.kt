package com.boson.sample.rxjava2

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.lang.Thread.currentThread
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


/**
 * com.boson.sample.rxjava2
 * @author wanqiang.mwq
 * @date 2019/2/12
 */
fun main() {
    val countDownLatch = CountDownLatch(1)
    Observable.just(1, 2, 3, 4, 5)
            .doOnNext( { println("Emitting item[$it] on: ${currentThread().name}" ) })
            .subscribeOn(Schedulers.computation())
//            .observeOn(Schedulers.computation())
            .map({
                    println("Processing item on: " + currentThread().name)
                it * 2
            })
//            .subscribe({
//                println("Consuming item{$it} on: " + currentThread().name)
//            })
            .subscribeWith(object : DisposableObserver<Int>() {

                override fun onNext(p0: Int) {
                    println("Consuming item on: " + currentThread().name)
                }

                override fun onError(@NonNull e: Throwable) {}

                override fun onComplete() {
                    countDownLatch.countDown()
                    println("Completed item on: " + currentThread().name)
                }
            })
    countDownLatch.await(10, TimeUnit.SECONDS)
//    Thread.sleep(10000)
//    d.isDisposed
}