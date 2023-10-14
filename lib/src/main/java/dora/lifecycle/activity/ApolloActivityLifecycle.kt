package dora.lifecycle.activity

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.lsxiao.apollo.core.Apollo
import com.lsxiao.apollo.core.contract.ApolloBinder

class ApolloActivityLifecycle : Application.ActivityLifecycleCallbacks {

    private var binder: ApolloBinder? = null

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        binder = Apollo.bind(this)
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        if (binder?.isUnbind() == true) {
            binder?.unbind()
        }
    }
}