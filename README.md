# StrathmoreEventApp

# 🎉 Strathmore Event App

A modern Android app built with Jetpack Compose, Kotlin, and Firebase to enable Strathmore University students to easily browse, view, and register for campus events.

---

## 📁 Project Structure

```plaintext
com.strathmore.eventapp/
├── model/                 → Data classes (e.g. Event)
│
├── repository/            → Business logic and data sources (e.g. EventRepository)
│
├── ui/
│   ├── navigation/        → AppNavHost.kt, NavRoutes.kt for screen navigation
│   ├── screens/           → Composables for screens (EventListScreen, EventDetailScreen, WelcomeScreen)
│   ├── theme/             → Material3 theming (Color.kt, Theme.kt, Type.kt)
│
├── viewmodel/             → EventViewModel for state handling
│
├── MainActivity.kt        → Entry point and navigation host binding
```


🔑 Key Features
🔐 User Auth — Firebase email/password login and signup

🗓️ Event Feed — Realtime list from Firestore

📖 Event Details — Title, description, date, venue, image, and more

🖱️ One-tap Registration — Simple RSVP-like registration flow

🔔 Push Notifications — (Planned) via Firebase Cloud Messaging

🧭 Modern Navigation — Jetpack Compose + sealed route navigation

🎨 Custom Theming — Material3 compliant UI with modular design

⚙️ Built With
Layer	Stack
Language	Kotlin 2.0.21
UI Toolkit	Jetpack Compose
DI	Hilt
Database	Firebase Firestore
Auth	Firebase Authentication
Messaging	Firebase Cloud Messaging (planned)
Navigation	Compose Navigation
State Mgmt	ViewModel + StateFlow
Theming	Material3 via ui.theme package



