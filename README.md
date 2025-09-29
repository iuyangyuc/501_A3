## Main Components

**MainActivity**: The entry point that sets up the Compose theme using `_501_A3Theme` and displays the `MainScreen` composable with edge-to-edge support

**MainScreen**: Contains the main UI scaffold with coordinated navigation:
- Material 3 Scaffold layout structure
- State management for navigation and snackbar interactions
- Integration of top bar, bottom navigation, FAB, and content areas

**Navigation System**: Bottom navigation with three tabs (Home, Settings, Profile) using:
- `NavigationBar` and `NavigationBarItem` components
- Dynamic selection state with visual feedback
- `BottomNavItem` data class for consistent structure

**Interactive Components**:
- **TopAppBar**: Material 3 app bar with title and overflow menu
- **FloatingActionButton**: Triggers snackbar messages with coroutine handling
- **SnackbarHost**: Integrated feedback system with action buttons

**Screen Components**:
- **HomeScreen**: Welcome interface with centered icon and descriptive text
- **SettingsScreen**: Configuration placeholder with consistent Material 3 styling
- **ProfileScreen**: User profile section with account icon and information layout

## Key Features Implementation

**State Management**: Uses Compose state hoisting pattern with `remember`, `mutableStateOf`, and `derivedStateOf` for:
- Bottom navigation selection tracking
- Snackbar state coordination
- Coroutine scope management for async operations

**Responsive Layout**: Uses proper Compose layout patterns:
- `Scaffold` for coordinated app structure
- `Column` and `Box` layouts with appropriate alignment
- Consistent spacing using `Spacer` and `Modifier.padding`
- Edge-to-edge display support with proper inset handling
