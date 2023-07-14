plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("maven-publish")
}

android {
    namespace = "dora.lifecycle.apollo"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.github.dora4:dora:1.1.9")

    // Apollo依赖RxAndroid2,请使用最新的版本
    api("io.reactivex.rxjava2:rxandroid:2.0.1")
    // Apollo的核心库
    api("com.github.lsxiao.Apollo:core:1.0.2")
    // Apollo的编译时注解处理器
    kapt("com.github.lsxiao.Apollo:processor:1.0.2")
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["release"])
                groupId = "com.github.dora4"
                artifactId = "dora-apollo-support"
                version = "1.0"
            }
        }
    }
}