# The Syntax - Programming Language Reference App

A simple, intuitive Android application that serves as a syntax reference guide for multiple programming languages. Built with modern Android development practices using Kotlin, Jetpack Compose, and Room database.

## Features

- **Multi-Language Support**: Reference syntax for HTML, CSS, JavaScript, Python, Java, Kotlin, C, and C++
- **Categorized Content**: Browse syntax by categories like variables, loops, conditionals, functions, classes, and more
- **Search Functionality**: Find specific syntax using keywords and search terms
- **Favorites System**: Mark frequently used syntax entries as favorites for quick access
- **Offline Access**: All syntax data is stored locally, no internet connection required
- **Modern UI**: Clean, minimalist interface built with Material Design 3 and Jetpack Compose
- **Dark Mode Support**: Automatic dark/light theme switching

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern with the following components:

### Data Layer
- **Room Database**: Local SQLite database for storing syntax data
- **Entities**: ProgrammingLanguage, SyntaxCategory, SyntaxEntry
- **DAOs**: Data Access Objects for database operations
- **Repository**: Central data access point with business logic

### UI Layer
- **Jetpack Compose**: Modern declarative UI toolkit
- **Material Design 3**: Latest Material Design components
- **Navigation**: Bottom navigation with three main screens

### Dependency Injection
- **Hilt**: Google's dependency injection library for Android

## Screens

1. **Home Screen**: Display programming languages in a grid layout
2. **Search Screen**: Search across all syntax entries
3. **Favorites Screen**: View and manage favorite syntax entries

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Database**: Room (SQLite)
- **Dependency Injection**: Hilt
- **Architecture**: MVVM
- **Navigation**: Navigation Compose
- **State Management**: StateFlow
- **Coroutines**: Asynchronous programming

## Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 28 or higher
- Kotlin 2.0.21 or higher

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/the-syntax-app.git
```

2. Open the project in Android Studio

3. Sync the project with Gradle files

4. Run the app on an emulator or physical device

### Building the App

```bash
./gradlew assembleDebug
```

## Project Structure

```
app/src/main/java/com/example/thesyntaxapplication/
├── data/
│   ├── dao/                    # Data Access Objects
│   ├── database/               # Room database setup
│   ├── model/                  # Database entities
│   ├── repository/             # Repository layer
│   └── DataInitializer.kt      # Sample data initialization
├── di/                         # Dependency injection modules
├── ui/
│   ├── screens/                # Compose UI screens
│   ├── state/                  # UI state classes
│   ├── theme/                  # Material Design theme
│   ├── viewmodel/              # ViewModels
│   └── SyntaxApp.kt           # Main app composable
├── MainActivity.kt             # Main activity
└── SyntaxApplication.kt        # Hilt application class
```

## Data Model

### ProgrammingLanguage
- `id`: Unique identifier (e.g., "html", "python")
- `name`: Language name
- `displayName`: User-friendly display name
- `color`: Theme color for the language
- `icon`: Icon identifier

### SyntaxCategory
- `id`: Unique identifier (e.g., "variables", "functions")
- `name`: Category name
- `displayName`: User-friendly display name
- `description`: Category description
- `icon`: Icon identifier
- `order`: Display order

### SyntaxEntry
- `id`: Unique identifier
- `languageId`: Reference to programming language
- `categoryId`: Reference to syntax category
- `title`: Entry title
- `description`: Detailed description
- `codeSnippet`: Code example
- `example`: Usage example
- `keywords`: Search keywords
- `isFavorite`: Favorite status
- `order`: Display order

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Future Enhancements

- **Interactive Code Playground**: Run and test code snippets
- **Voice Search**: Search using voice commands
- **Syntax Sharing**: Share syntax entries with other developers
- **Custom Languages**: Support for adding custom programming languages
- **Cloud Sync**: Sync favorites and custom entries across devices
- **Code Highlighting**: Syntax highlighting for code snippets
- **Export/Import**: Export favorites and custom entries

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Material Design 3 for the beautiful UI components
- Jetpack Compose team for the modern UI toolkit
- Room database team for the excellent local database solution
- Hilt team for dependency injection

## Support

If you have any questions or need help, please open an issue on GitHub or contact the development team.

---

**The Syntax** - Making programming syntax accessible to everyone! 🚀
