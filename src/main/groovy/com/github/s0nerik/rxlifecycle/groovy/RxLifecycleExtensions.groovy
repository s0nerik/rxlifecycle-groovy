package com.github.s0nerik.rxlifecycle.groovy

import android.view.View
import com.trello.rxlifecycle.*
import groovy.transform.CompileStatic
import rx.Observable

@CompileStatic
class RxLifecycleExtensions {
    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, ActivityLifecycleProvider activity) {
        observable.compose((Observable.Transformer<T, T>) { activity.bindToLifecycle() })
    }

    static <T> Observable<T> bindUntilEvent(final Observable<T> observable, ActivityLifecycleProvider activity, ActivityEvent event) {
        observable.compose((Observable.Transformer<T, T>) { activity.bindUntilEvent(event) })
    }

    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, FragmentLifecycleProvider fragment) {
        observable.compose((Observable.Transformer<T, T>) { fragment.bindToLifecycle() })
    }

    static <T> Observable<T> bindUntilEvent(final Observable<T> observable, FragmentLifecycleProvider fragment, FragmentEvent event) {
        observable.compose((Observable.Transformer<T, T>) { fragment.bindUntilEvent(event) })
    }

    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, View view) {
        observable.compose((Observable.Transformer<T, T>) { RxLifecycle.bindView(view) })
    }
}
