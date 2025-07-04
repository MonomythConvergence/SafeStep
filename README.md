# SafeStep
A personal safety app that uses AI-powered anomaly detection to monitor movement patterns during travel. Key features include real-time location encryption, emergency calling, and a dynamic Safety Score that visualizes risk levels. The app operates offline-first with battery-optimized tracking, sending lightweight MQTT alerts to contacts during emergencies while protecting data through SQLCipher encryption.

At least in theory, let's see how far I'll get.

Stack:
```kotlin
// Core Architecture
Kotlin + Jetpack Compose + Hilt + Single-Activity

// Safety Features
WorkManager (Location) · Room + SQLCipher (Storage) · 
Linphone SDK (Emergency Calls) · BroadcastReceiver (Panic Mode)

// Intelligence
TensorFlow Lite (Anomaly Detection) · AlarmManager (Check-ins)

// Infrastructure
Retrofit (Networking) · GitHub Actions (CI/CD)
