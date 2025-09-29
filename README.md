## Main Components

### 1. **MainActivity.kt**
- Extends `ComponentActivity`
- Enables edge-to-edge display
- Sets up Compose UI with `AppTheme` and `Scaffold`
- Hosts the `LoginScreen` composable

### 2. **LoginScreen Composable**
The main UI component implementing the login interface

### 3. **AppTheme**
- Custom Material Design 3 theme
- Color schemes and typography definitions
- Applied throughout the app for consistent styling

## Key Features Implementation

### State Management
Uses Compose's reactive state system with `remember` and `mutableStateOf`:
- `username`: Stores username input
- `password`: Stores password input
- `passwordVisible`: Toggles password visibility
- `showUsernameError`: Controls username error display
- `showPasswordError`: Controls password error display
- `loginAttempted`: Tracks if login button was clicked

### UI Components

#### Username Field
- `OutlinedTextField` with single-line input
- Error state handling with visual feedback
- Supporting text for error messages
- Material 3 color theming

#### Password Field
- `OutlinedTextField` with password-specific features:
  - Password masking/unmasking toggle
  - Visibility icon button (eye icon)
  - Keyboard type set to password
  - Visual transformation for security
- Error state handling with supporting text

#### Login Button
- Full-width Material 3 button
- Triggers form validation on click
- Handles successful validation scenario
- Styled with primary color scheme

### Form Validation Logic
- **Trigger**: Validation activates when "Sign In" button is clicked
- **Real-time Updates**: After first attempt, errors update as user types
- **Rules**: Username and password fields cannot be empty
- **Visual Feedback**:
  - Red border around error fields
  - Error messages below invalid fields
  - Error text styled with Material 3 error colors