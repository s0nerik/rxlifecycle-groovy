package com.github.s0nerik.rxlifecycle.groovy

import android.view.View
import com.trello.rxlifecycle.*
import groovy.transform.CompileStatic
import rx.Observable

@CompileStatic
class RxLifecycleExtensions {
    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, ActivityLifecycleProvider activity) {
        observable.compose({ activity.bindToLifecycle() } as Observable.Transformer)
    }

    static <T> Observable<T> bindUntilEvent(final Observable<T> observable, ActivityLifecycleProvider activity, ActivityEvent event) {
        observable.compose({ activity.bindUntilEvent(event) } as Observable.Transformer)
    }

    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, FragmentLifecycleProvider fragment) {
        observable.compose({ fragment.bindToLifecycle() } as Observable.Transformer)
    }

    static <T> Observable<T> bindUntilEvent(final Observable<T> observable, FragmentLifecycleProvider fragment, FragmentEvent event) {
        observable.compose({ fragment.bindUntilEvent(event) } as Observable.Transformer)
    }

    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, View view) {
        observable.compose({ RxLifecycle.bindView(view) } as Observable.Transformer)
    }
}
