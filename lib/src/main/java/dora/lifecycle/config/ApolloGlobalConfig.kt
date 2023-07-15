package dora.lifecycle.config

import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentManager
import dora.lifecycle.activity.ApolloActivityLifecycle
import dora.lifecycle.application.ApolloAppLifecycle
import dora.lifecycle.application.ApplicationLifecycleCallbacks
import dora.lifecycle.fragment.ApolloFragmentLifecycle

class ApolloGlobalConfig : GlobalConfig {
    override fun injectApplicationLifecycle(
        context: Context?,
        lifecycles: MutableList<ApplicationLifecycleCallbacks>?
    ) {
        lifecycles!!.add(ApolloAppLifecycle())
    }

    override fun injectActivityLifecycle(
        context: Context?,
        lifecycles: MutableList<Application.ActivityLifecycleCallbacks>?
    ) {
        lifecycles!!.add(ApolloActivityLifecycle())
    }

    override fun injectFragmentLifecycle(
        context: Context?,
        lifecycles: MutableList<FragmentManager.FragmentLifecycleCallbacks>?
    ) {
        lifecycles!!.add(ApolloFragmentLifecycle())
    }
}