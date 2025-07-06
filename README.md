# 🎓 Strathmore Event App

An Android application for Strathmore University students to view and register for upcoming campus events. The app uses Firebase Authentication and Firestore for real-time event listings and secure access control.

---

## 📱 Features

- 🔐 **Strathmore-only Login** using Firebase Authentication (only `@strathmore.edu` emails allowed)
- 📆 **Event Listing** with images, date, location, and description
- 🔍 **Event Details** page with full event information and Google Forms registration link
- 🌐 **Cloud Firestore Integration** for dynamic event content
- 🎨 **Jetpack Compose UI** for modern, reactive UI
- 🔗 Deep links and argument passing between composable screens
- 💉 **Hilt DI**, **Material3**, and clean architecture principles

---

## 📁 Project Structure

```plaintext
com.strathmore.eventapp
│
├── model/
│   └── Event.kt                  # Data class for event model
│
├── repository/
│   ├── EventRepository.kt        # Loads events from Firestore
│   └── AuthRepository.kt         # FirebaseAuth login logic
│
├── ui/
│   ├── navigation/
│   │   ├── AppNavHost.kt         # Composable navigation graph
│   │   └── NavRoutes.kt          # All route constants and builder
│   │
│   ├── screens/
│   │   ├── LoginScreen.kt        # Email-only login with Firebase
│   │   ├── EventListScreen.kt    # LazyColumn of all events
│   │   ├── EventDetailScreen.kt  # Full event info + form link
│   │   └── WelcomeScreen.kt      # Optional welcome UI
│   │
│   ├── theme/
│   │   ├── Theme.kt
│   │   ├── Color.kt
│   │   └── Type.kt
│   │
│   └── EventAdapter.kt           # RecyclerView adapter (unused in Compose)
│
├── viewmodel/
│   ├── EventViewModel.kt         # Observes Firestore event list
│   └── AuthViewModel.kt          # Handles user login state
│
└── MainActivity.kt               # Entry point, sets up Compose and navigation

🔧 Technologies Used
Tool/Library	Purpose
Jetpack Compose	Declarative UI Toolkit
Firebase Auth	User authentication (email only)
Firebase Firestore	Realtime database for event data
Hilt	Dependency injection
Material3	UI styling
Coil	Image loading
Kotlin DSL	Gradle configuration style

🧪 Running the App
Prerequisites
Android Studio Hedgehog or later

Android Emulator or physical device

Firebase project with:

Email/Password sign-in enabled

Firestore set up with a events collection

google-services.json in /app/

Run Instructions
Clone the repo:

bash
Copy
Edit
git clone https://github.com/AKrutto26/StrathmoreEventApp.git
Open in Android Studio

Run the app:

Log in with a valid @strathmore.edu email.

Browse events and view event details.

📦 Firestore Data Structure
Collection: events

json
Copy
Edit
{
  "title": "Culture Fest 2025",
  "description": "Celebrate diversity the Strathmore way...",
  "date": "11th July 2025 - 3:00pm",
  "location": "Graduation Grounds",
  "imageUrl": "https://example.com/culturefest.jpg",
  "formLink": "https://forms.gle/eventformlink"
}
🔐 Firebase Auth Logic
Only emails ending with @strathmore.edu can log in. This is enforced on the client before attempting Firebase authentication.

👥 Contributors
Adrian Rutto – Main developer
Joseph Wakahu
Mary


🔍 File-by-File Descriptions
📁 model/
File	Description
Event.kt	A Kotlin data class representing an event. It holds properties like title, description, date, location, imageUrl, and formLink. This acts as the model for displaying events from Firestore.

📁 repository/
File	Description
EventRepository.kt	Responsible for fetching and streaming the list of events from Firebase Firestore. Uses Kotlin coroutines and Flow for reactive updates.
AuthRepository.kt	Handles Firebase Authentication logic. Ensures only @strathmore.edu emails are allowed, performs login with email/password, and exposes current user info.

📁 ui/navigation/
File	Description
NavRoutes.kt	Defines route constants (login, event_list, event_detail) and a helper function eventDetailRoute(...) to build the full navigation path with arguments encoded.
AppNavHost.kt	Sets up all navigation routes using NavHost and composable(...) screens. Extracts and decodes arguments passed to the EventDetailScreen.

📁 ui/screens/
File	Description
LoginScreen.kt	UI for user login using Firebase Auth. Accepts only emails ending in @strathmore.edu. On success, navigates to EventListScreen.
EventListScreen.kt	Fetches events from the EventViewModel, displays them in a LazyColumn, and navigates to the detail screen on click.
EventDetailScreen.kt	Receives full event data via navigation arguments and displays all details: title, description, date, image, and a "Register" button that links to a Google Form.
WelcomeScreen.kt	Optional screen to welcome users after login or during onboarding. Currently unused but may be used later for branding or instructions.

📁 ui/theme/
File	Description
Theme.kt	Contains your app's MaterialTheme setup. Defines the use of custom colors, typography, and shapes using Material3.
Color.kt	Defines custom color palette used across the app (primary, secondary, etc.).
Type.kt	Sets up custom text styles (Typography) used throughout the UI (title, body, labels, etc.).

📁 ui/
File	Description
EventAdapter.kt	A RecyclerView.Adapter for events (used in classic Android UI). Currently unused because the app uses Jetpack Compose, but kept for fallback or reference.
EventListFragment.kt	Possibly an older XML-based Fragment class before moving to Compose. Likely deprecated in favor of EventListScreen.kt. You can remove it if you're using only Compose.

📁 viewmodel/
File	Description
EventViewModel.kt	Connects EventRepository to the UI. Exposes the list of events as a StateFlow, allowing Compose to observe and update in real-time.
AuthViewModel.kt	Exposes login state and functions to the UI layer. Handles calling AuthRepository for login and keeps track of the current authenticated user.

📁 (root package)
File	Description
MainActivity.kt	The app's main entry point. Sets the ComposeView, applies the app theme, and initializes AppNavHost for navigation.

🔧 Other Important Files
File	Description
AndroidManifest.xml	Declares the app's components (like MainActivity) and necessary permissions. Also links the Firebase config via metadata.
google-services.json	Required for Firebase integration. Contains your Firebase project info (DO NOT commit this to public repos).
build.gradle.kts (both project and app-level)	Configures your dependencies: Jetpack Compose, Firebase, Material3, Kotlin, Hilt, etc.
settings.gradle.kts	Declares modules in your project and sets the root name.
proguard-rules.pro	Rules for code obfuscation and shrinking (used in production builds).
themes.xml and colors.xml	Define base app theme and color definitions used by Material3 (though mostly overridden by Theme.kt now).




