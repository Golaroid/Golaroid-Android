import org.gradle.api.JavaVersion

object ProjectProperties {
    object Test {
        const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Id {
        const val APPLICATION_ID = "com.idea_festival.golaroid-android"
    }

    object Files {
        const val CONSUMER_PROGUARDFILES = "consumer-rules.pro"
        const val DEFAULT_PROGUARDFILES = "proguard-android-optimize.txt"
        const val PROGUARDFILES = "proguard-rules.pro"
    }

    object Versions {
        const val COMPILE_SDK = 34
        const val MIN_SDK = 24
        const val TARGET_SDK = 33
        const val JVM_TARGET = "1.8"
        const val VERSION_CODE = 11
        const val VERSION_NAME = "1.1.5"
        val JAVA_VERSION = JavaVersion.VERSION_1_8
    }

    object NameSpace {
        const val PRESENTATION = "com.golaroid-android.presentation"
        const val DOMAIN = "com.golaroid-android.domain"
        const val DATA = "com.golaroid-android.data"
        const val APP = "com.idea_festival.golaroid-android"
        const val DESIGN_SYSTEM = "com.golaroid-android.design-system"
    }
}