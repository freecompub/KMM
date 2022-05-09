plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.squareup.sqldelight")
    id("kotlinx-serialization")

}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:2.0.1")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.1")
                implementation("io.ktor:ktor-client-content-negotiation:2.0.1")

                //BDD
                implementation("com.squareup.sqldelight:coroutines-extensions:1.5.3")

                // time
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")


            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation ("io.ktor:ktor-client-mock:2.0.1")
                implementation("com.squareup.sqldelight:runtime:1.5.3")

/*                implementation ("io.cucumber:cucumber-java8:6.10.2")
                implementation ("io.cucumber:cucumber-junit:6.10.2")
                implementation ("io.cucumber:cucumber-android:4.8.4")*/
            }
        }
        val androidMain by getting{
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:2.0.0-beta-1")
                implementation("com.squareup.sqldelight:android-driver:1.5.3")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
 /*           dependencies {
                implementation("io.ktor:ktor-client-ios:2.0.0-beta-1")
                implementation("com.squareup.sqldelight:native-driver:1.5.3")
            }*/
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}


sqldelight {
    database("AFSlogsTable") {
        packageName = "fr.acs.kmm.db"
    }
}
