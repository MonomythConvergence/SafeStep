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
Kotlin + Jetpack Compose (Material 3)+Hilt+Single-Activity
+Minimal module structure(app, core, features, data) + Reactive Patterns : RxJava 3(event streams)

// Safety Features
WorkManager(Location) · Room+SQLCipher (Storage) ·
Linphone SDK (Emergency Calls) · BroadcastReceiver (Panic Mode) ·
AlarmManager(Check - ins) · RxJava (sensor fusion)

// Intelligence
TensorFlow Lite (Anomaly Detection) · MQTT (Eclipse Paho for alerts)

// Infrastructure
Retrofit(Networking) · GitHub Actions (CI/CD) · Firebase Crashlytics (monitoring)

// Under consideration
Detekt
```

Structure:

```kotlin
// Screens
Onboarding(permissions requests)
Profile (manage data, set contacts, other settings)
Main screen (tracking data status icons, anomalies display, other stats: speed, elevation changes, cadance(look up)) 