package com.boson.sample.rxjava2

import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * com.boson.sample.rxjava2
 * @author wanqiang.mwq
 * @date 2019/2/12
 */
class Rxjava2Test {

    @Test
    fun testRange() {
        val countDownLatch = CountDownLatch(1)
        Observable.range(1, 5)
                .subscribeWith(object : DisposableObserver<Int>() {

                    override fun onNext(p0: Int) {
                        println("Consuming item[${p0}] on ${Thread.currentThread().name} ")
                    }

                    override fun onError(@NonNull e: Throwable) {}

                    override fun onComplete() {
                        println("Completed item on ${Thread.currentThread().name} ")
                        countDownLatch.countDown()
                    }
                })
        countDownLatch.await(10, TimeUnit.SECONDS)
    }

    @Test
    fun testErrorReturn() {
        val countDownLatch = CountDownLatch(1)
        var e:Exception? = null
        Observable.range(1, 5)
//                .retry(0)
////                .onErrorReturn {
////                    println(it.message)
////                    countDownLatch.countDown()
////                    6
////                }
                .doOnComplete {
                    println("Completed on ${Thread.currentThread().name} ")
                    countDownLatch.countDown()
                }
//                .doOnError {
//                    println(it.message)
//                    countDownLatch.countDown()
//                }
//                .doOnError {  }
                .subscribe({
                    println("Consuming item[${it}] on ${Thread.currentThread().name} ")
                    if (it == 2) {
                        var _e =  RuntimeException("2 is error")
                        countDownLatch.countDown()
                        e = _e
                        throw _e
                    }
                })
        countDownLatch.await(10, TimeUnit.SECONDS)
        if (e != null) {
            throw e!!
        }

    }
}