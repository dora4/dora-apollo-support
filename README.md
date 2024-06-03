dora-apollo-support
![Release](https://jitpack.io/v/dora4/dora-apollo-support.svg)
--------------------------------

#### gradle依赖配置

```groovy
// 添加以下代码到项目根目录下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
// 添加以下代码到app模块的build.gradle.kts
dependencies {
    // 扩展包必须在有主框架dora的情况下使用
    implementation("com.github.dora4:dora:1.2.6")
    implementation("com.github.dora4:dora-apollo-support:1.4")
    // Apollo的编译时注解处理器
    kapt("com.github.lsxiao.Apollo:processor:1.0.2")
}
```

#### 使用方式

在AndroidManifest中加入配置。
```xml
<application>
        <meta-data
            android:name="dora.lifecycle.config.ApolloGlobalConfig"
            android:value="GlobalConfig"/>
</application>
```
你可以使用Apollo.emit()发送事件，并在Activity和Fragment中可以直接接收事件，在其他类需要在初始化的时候手动调用Apollo.bind(this)才能接收到事件。
```kotlin
@Receive(ApolloEvent.YOUR_CUSTOM_EVENT)
fun onReceiveEvent()
    // 你的事件处理逻辑
}
```
