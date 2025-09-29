### Main Components

1. **MainActivity**: The entry point that sets up the Compose theme and displays the ProfileScreen
2. **ProfileScreen**: Contains the main UI layout with centered profile picture and toggle button
3. **ProfilePictureWithBadge**: Reusable composable that renders:
   - Circular profile container with border
   - Profile image (if available) or initials
   - Optional red notification badge with count

### Key Features Implementation

- **Profile Picture**: Uses a `Box` with `CircleShape` clipping and Material 3 color scheme
- **Badge System**: Conditionally rendered red circle positioned at bottom-end of profile picture
- **State Management**: Uses `remember` and `mutableStateOf` for badge visibility toggle
- **Responsive Design**: Adapts to different screen sizes with proper spacing and alignment