### Project Architecture & Structure

This project is built using **Compose Multiplatform** and follows a modern **MVVM (Model-View-ViewModel)** architecture with a Unidirectional Data Flow. The codebase is structured to strictly separate UI rendering from business logic and data retrieval.

### UI Component Organization

The user interface is built declaratively using Jetpack/JetBrains Compose and is highly modular:

* **Container Screens (`HomeScreen.kt`):** Acts as the top-level observer of the UI state. It handles the overall scaffold, positioning static elements like the `TopBar` and `BottomBar`.
* **State-Driven Content:** The core content area (`HomeContent`) listens to the current state (Loading, Error, or Success) and dynamically swaps out the UI components (e.g., showing a `LoadingState` or the actual `TopicColumn`).
* **Reusable Components:** Smaller elements like individual topic rows or user stat chips are broken down into independent, stateless composables to keep the code clean and maintainable.

### Data Flow: JSON to UI

Data moves through the app in a strict, one-way pipeline:

1. **JSON to Repository (`HomeRepositoryImpl`):** The raw data is stored locally as JSON files within the Compose Multiplatform resources. The repository reads these files as byte arrays (`Res.readBytes()`) and decodes them directly into Kotlin data classes (`TopicZone` and `Topic`) using `kotlinx.serialization`.
2. **Repository to ViewModel (`HomeViewModel`):**
   The ViewModel requests this data asynchronously within a Kotlin Coroutine. It processes the raw data, such as mapping topic IDs to their respective details and packages it into a single, cohesive `HomeUiState` object. This state is then emitted via a `StateFlow`.
3. **ViewModel to UI / Activity (`HomeScreen`):**
   The presentation layer passively observes the ViewModel's `StateFlow`. When the state updates (e.g., transitioning from a loading state to displaying the parsed topics), Compose automatically triggers a recomposition, passing the fresh data down to the child UI components to be rendered on the screen.
