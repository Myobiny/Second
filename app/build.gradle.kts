plugins {
    id("com.android.application")

    //모듈(앱 수준) build.gradle.kts 파일에서 google-services 플러그인설치
    id("com.google.gms.google-services")
}

android {
    namespace = "ko.co.second"
    compileSdk = 34


    defaultConfig {
        applicationId = "ko.co.second"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}



dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //네이버 api sdk 의존성 추가
    implementation("com.naver.maps:map-sdk:3.18.0")

    //firebase sdk 의존성 추가
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-auth")


    //하단바 navigation라이브러리 설차
    implementation ("androidx.navigation:navigation-fragment:2.5.3")
    implementation ("androidx.navigation:navigation-ui:2.5.3")
    implementation ("com.google.android.material:material:1.4.0.")
    //네이버 지도 위치 표시 FusedLocationSource 의존성 추가
    implementation ("com.google.android.gms:play-services-location:20.0.0")


}