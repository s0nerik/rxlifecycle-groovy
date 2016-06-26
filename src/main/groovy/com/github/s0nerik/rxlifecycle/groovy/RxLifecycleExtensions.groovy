package com.github.s0nerik.rxlifecycle.groovy

import android.view.View
import com.trello.rxlifecycle.*
import groovy.transform.CompileStatic
import rx.Observable

@CompileStatic
class RxLifecycleExtensions {
    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, ActivityLifecycleProvider activity) {
        return observable.compose(activity.bindToLifecycle())
    }

    static <T> Observable<T> bindUntilEvent(final Observable<T> observable, ActivityLifecycleProvider activity, ActivityEvent event) {
        return observable.compose(activity.bindUntilEvent(event))
    }

    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, FragmentLifecycleProvider fragment) {
        return observable.compose(fragment.bindToLifecycle())
    }

    static <T> Observable<T> bindUntilEvent(final Observable<T> observable, FragmentLifecycleProvider fragment, FragmentEvent event) {
        return observable.compose(fragment.bindUntilEvent(event))
    }

    static <T> Observable<T> bindToLifecycle(final Observable<T> observable, View view) {
        return observable.compose(RxLifecycle.bindView(view))
    }
}
