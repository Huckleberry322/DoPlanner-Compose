object Dependencies {
    const val kotlinVersion = "1.6.10"
    const val composeVersion = "1.1.1"

    object App {

        object Android {
            const val corKtx = "androidx.core:core-ktx:1.7.0"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui:$composeVersion"
            const val material = "androidx.compose.material:material:$composeVersion"
            const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
            const val tooling = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
            const val livedata = "androidx.compose.runtime:runtime-livedata:$composeVersion"

            const val toolingTest = "androidx.compose.ui:ui-tooling:$composeVersion"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$composeVersion"

            const val accompanist = "com.google.accompanist:accompanist-systemuicontroller:0.18.0"
        }

        object Navigation {
            const val composeNavigation = "androidx.navigation:navigation-compose:2.4.2"
        }

        object Lifecycle {
            const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        }

        object Test {
            const val jUnit = "junit:junit:4.13.2"
            const val androidJUnit = "androidx.test.ext:junit:1.1.3"
            const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        }

        object Billing {
            private const val billingVersion = "4.1.0"
            const val billingClient = "com.android.billingclient:billing-ktx:$billingVersion"
        }

        object GooglePlay {
            const val playCore = "com.google.android.play:core:1.10.3"
        }

        object Hilt {
            private const val hiltVersion = "2.40.5"
            const val android = "com.google.dagger:hilt-android:$hiltVersion"
            const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
            const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
        }


        object Security {
            const val crypto = "androidx.security:security-crypto-ktx:1.1.0-alpha03"
        }

        object Json {
            const val gson = "com.google.code.gson:gson:2.8.9"
        }

        object DataStore {
            const val dataStore = "androidx.datastore:datastore-preferences:1.0.0"
        }
    }
}
