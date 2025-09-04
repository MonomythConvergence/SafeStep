# SafeStep

A personal safety app that uses AI-powered anomaly detection to monitor movement patterns during
travel. 
Key features include real-time location encryption, emergency and contacts dialing in emergency, 
VoIP recording to sever in emergency state, multi-sensor fusion to monitor the situation and a dynamic 
Safety Score that visualizes risk levels. 
The app operates offline-first with battery-optimized tracking, mapped area safety scores based on 
recent news data, sending lightweight MQTT alerts to contacts during emergencies while protecting 
data through SQLCipher encryption.

At least in theory, let's see how far I'll get.

Current state:
·Drafting main functionality outline and Main screen design: Done
·Testing RxJava/Sensors: In progress

Stack (doubling as "things I'm learning") list:

```kotlin
// Core Architecture
·Kotlin + MVI + SharedFlow + Single-Activity
·Jetpack Compose (Material 3)
·Dagger2

//Minimal module structure (:app, :core, :features, :data) to be KMP-ready: 
·":app" and ":features" modules contains all Android-specific logic. 
All interfaces are contained to ":core".

//Reactive Patterns : 
·RxJava 3(event streams, exclusive to Android platform)

// Safety Features
·WorkManager(Location) 
·SQLDelight+SQLCipher (Storage) 
·Linphone SDK (Emergency real-time recording to server) 
·BroadcastReceiver (Panic Mode)
·AlarmManager(Check - ins) 
·RxJava (sensor fusion)
Combines sudden acceleration (accelerometer) + rotation (gyroscope) + altitude change (barometer) for
fall detection + potential battery saving by cutting on GPS calls by tracking deviations from normal
conditions through phone sensors if following a recorded path. Also makes use of tremor detection.

// Intelligence
·TensorFlow Lite (Anomaly Detection)
Available on consecutive trips - saves on battary drain by cutting on GPS usage. 
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
·Web-Compose, Flow converters for RxJava, Algorithm solution for Areas Safety via geo-matched news.

// Screen Structure

Functionality:
·Onboarding: 
Greeting/introduction, use case, permissions requests, use instructions (+illustrations?)

·Main screen: 
tracking status icons (GPS, server response)
anomalies status display, 
other stats to track: acceleration(cadance?), elevation changes, )
other functions: horizontal shake to bring up the app for emergecncy slider availability w/tactile feedback) 
vertical emergency slider
profile and battery saving buttons

·Profile/Settings/Privacy (manage data, set contacts, other settings)

//UI:
Onboarding: 
·Permissions:
VoIP recording explicit permission
Area setup for SOS calls and optionals area safety assessment


---Main screen: 
Top:
·App icon/shield
·General Safety indicator as a gradient graph for readability 
(blue-green-yellow-red safe-normal-caution-emergency mapped to low/high)

Middle: 
·Last server connection
·GPS signal strength
·Area safety(?) - make inactive until fed data via profile.
·Small window for up-to 3 anomalies to be displayed. "No anomalies" placeholder otherwise. 
Anomalies list: sudden elevation/acceleration changes, deteckting shakes, also can flash low battery.
Pressable, brings up sub-screen of logged alerts.
Turns into interactable area to confirm safety when anomalies peak and gives rythmic vibes signal.
Consider "are you okay" pre-emptive confirmations w/suggestions and/or assurements.
Use user-configured interactable (connect-the-dots, pick a word from letters, spot-a-difference) to 
ensure security. 

Bottom: 
·Profile button. left of center.

·Emergency slider in the center. Cuts into side buttons as it goes up, displays notches to completion.
Tactile feedback on initialization and use (vibe signal + increasing haptic response?),
triple vibe to signal completion.
Activates not only via drag up gesture directly on it, but with a long press on any bottom area part.
Does not send emergency signal unless released at the highest point or held in over halfway for 3 seconds.
If tap is continued - user can drag down to send a follow-up cancel signal.

Battery saving mode button. Slowly changes from greyed text and green outline to blue and white to 
pulsing red as battery level is drained. When on has a stable orange outline and tap to send get GPS
once alternative, tap twice or put on charger to disengage text

---Profile (manage data, set contacts for notifications, get area safety information, other settings)


---Notifications/persistent windows/draw-over elements?
