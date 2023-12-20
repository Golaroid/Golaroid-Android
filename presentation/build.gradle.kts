plugins {
    id(Dependency.Gradle.LIBRARY)
    id(Dependency.Gradle.KOTLIN)
    id(Dependency.Google.HILT_PLUGIN)
    kotlin(Dependency.Gradle.KAPT)
}

@Suppress("UnstableApiUsage")
android {
    namespace = ProjectProperties.NameSpace.PRESENTATION
    compileSdk = ProjectProperties.Versions.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.Versions.MIN_SDK
        targetSdk = ProjectProperties.Versions.TARGET_SDK

        testInstrumentationRunner = ProjectProperties.Test.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.Files.CONSUMER_PROGUARDFILES)


        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile(ProjectProperties.Files.DEFAULT_PROGUARDFILES),
                    ProjectProperties.Files.PROGUARDFILES
                )
            }
        }
        compileOptions {
            sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
            targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
        }
        kotlinOptions {
            jvmTarget = ProjectProperties.Versions.JVM_TARGET
        }
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.COMPOSE
        }
        packagingOptions {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}

    dependencies {
        implementation(project(":domain"))
        implementation(project(":design-system"))

        implementation(Dependency.AndroidX.CORE_KTX)
        implementation(Dependency.AndroidX.LIFECYCLE)
        implementation(Dependency.Compose.ACTIVITY_COMPOSE)
        implementation(Dependency.Compose.COMPOSE)
        implementation(Dependency.Compose.COMPOSE_TOOLING)
        implementation(Dependency.Compose.COMPOSE_MATERIAL)
        implementation(Dependency.Compose.COMPOSE_MATERIAL3)
        implementation(Dependency.Compose.COMPOSE_PREVIEW)
        testImplementation(Dependency.Test.JUNIT)
        androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
        androidTestImplementation(Dependency.Test.ESPRESSO)
        androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
        debugImplementation(Dependency.Compose.COMPOSE_TOOLING)
        debugImplementation(Dependency.Test.COMPOSE_MANIFEST)
        implementation(Dependency.Compose.COMPOSE_WINDOW_SIZE_CLASS)
        implementation(Dependency.Compose.COMPOSE_NAVIGATION)
        implementation(Dependency.CamPoser.CAMPOSER)
        implementation("androidx.camera:camera-camera2:1.3.0-beta01")
        implementation("androidx.camera:camera-lifecycle:1.3.0-beta01")
        implementation("androidx.camera:camera-view:1.3.0-beta01")
        implementation("androidx.camera:camera-extensions:1.3.0-beta01")
        implementation("com.google.accompanist:accompanist-permissions:0.31.2-alpha")

        implementation(Dependency.Google.HILT)
        kapt(Dependency.Google.HILT_COMPILER)
        implementation(Dependency.Navigation.NAVIGATION)

        implementation(Dependency.Libraries.OKHTTP)

        implementation(Dependency.Libraries.COIL)
        implementation(Dependency.Libraries.COIL_COMPOSE)

        implementation(Dependency.AndroidX.SPLASH)
    }