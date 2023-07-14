package dora.lifecycle.application

import android.app.Application
import android.content.Context
import com.lsxiao.apollo.core.Apollo
import io.reactivex.android.schedulers.AndroidSchedulers

class ApolloAppLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context) {
    }

    override fun onCreate(application: Application) {
        Apollo.init(AndroidSchedulers.mainThread(), application)
    }

    override fun onTerminate(application: Application) {
    }
}