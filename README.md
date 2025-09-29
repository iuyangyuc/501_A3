### Overview

This Android application displays a scrollable contact list with alphabetical grouping, sticky headers, and smooth scrolling features.

## Main Components

**MainActivity**: The entry point that sets up the Compose theme and displays the ContactListScreen
**ContactListScreen**: Contains the main UI layout with LazyColumn for efficient scrolling and grouped contact display
**ContactItem**: Reusable composable that renders:
- Circular avatar with person icon
- Contact details (name, phone, email)
- Material 3 card styling with proper elevation
**LetterHeader**: Sticky section headers for alphabetical grouping

## Key Features Implementation

**Alphabetical Grouping**: Contacts are sorted by last name and grouped by first letter with sticky headers
**Scroll-to-Top FAB**: Animated floating action button that appears after scrolling past 10 items
**State Management**: Uses remember, derivedStateOf, and coroutines for smooth scrolling animations
**Material Design 3**: Implements dynamic color theming, proper spacing, and modern component styling

