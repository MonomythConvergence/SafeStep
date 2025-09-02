# SafeStep

A personal safety app that uses AI-powered anomaly detection to monitor movement patterns during
travel. Key features include real-time location encryption, emergency calling, and a dynamic Safety
Score that visualizes risk levels. The app operates offline-first with battery-optimized tracking,
sending lightweight MQTT alerts to contacts during emergencies while protecting data through
SQLCipher encryption.

At least in theory, let's see how far I'll get.

Under consideration:
Combine sudden acceleration (accelerometer) + rotation (gyroscope) + altitude change (barometer) for
fall detection + potential battery saving by cutting on GPS calls by tracking deviations from normal
conditions through phone sensors

Stack (doubling as "things I'm learning") list:

```kotlin
// Core Architecture
·Kotlin + MVI + SharedFlow + Single-Activity
·Jetpack Compose (Material 3)
·Hilt

//Minimal module structure (:app, :core, :features, :data) to be KMP-ready: 
·:app and :feature modules contains all Android-specific logic. All interfaces are contained to :core.

//Reactive Patterns : 
·RxJava 3(event streams, exclusive to Android platform)

// Safety Features
·WorkManager(Location) · SQLDelight+SQLCipher (Storage) ·
·Linphone SDK (Emergency Calls) · BroadcastReceiver (Panic Mode) ·
·AlarmManager(Check - ins) · RxJava (sensor fusion)

// Intelligence
·TensorFlow Lite (Anomaly Detection) 
·MQTT (Eclipse Paho for alerts)

// Infrastructure
·Networking: Ktor(okhttp)
·CI/CD : GitHub Actions
·Monitoring: Firebase Crashlytics

// Testing

//Unit tests
·JUnit 5
·MockK
·kotlin-test
·kotlinx-coroutines-test
·Turbine
·qldelight:sqlite-driver

//Optional - UI / Instrumentation
·Espresso
·AndroidJUnitRunner
·androidx.test:core
·Jetpack Compose testing
·sqldelight:android-driver

//Optional - JVM-level UI
·Robolectric
·sqlite-driver (Robolectric compat)

//Optional - Integration / E2E
// Real SQLDelight DB (file-backed/in-memory)
// Test doubles for external services (Linphone, MQTT)


// Linter
·Detekt (only on Android-friendly app/feature modules)

// Future expansion:
·Web-Compose, Flow converters for RxJava

// Screen Structure

Functionality:
·Onboarding: 
Greeting/introduction, use case, permissions requests, use instructions (+illustrations?)

·Main screen: 
tracking status icons (GPS, server response)
anomalies status display, 
other stats to track: acceleration(cadance?), elevation changes, )
other functions: horizontal shake to bring up the app for emergecncy slider availability w/tactile feedback) 

·Profile/Settings/Privacy (manage data, set contacts, other settings)

//UI:
Onboarding: 
·

Main screen: 
Top:
·App icon/shield
·Safety indicator as a gradient graph for readability 
(high risk = red, low risk = green, caution = yellow)

Middle: 
·Last server connection
·GPS signal strength
·Small window for up-to 3 anomalies to be displayed. No anomalies placeholder otherwise. 
Pressable, brings up sub-screen.

Bottom: 
·
·Emergency slider in the center
tactile feedback on use, increasing haptic response?, triple vibe to signal completion



Profile (manage data, set contacts, other settings)
·

Notifications/persistent windows/draw-over elements?
