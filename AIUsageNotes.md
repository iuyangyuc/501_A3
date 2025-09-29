1. Which tool you used   
   Github Copilot and Gemini

2. What prompt or query you gave.
#### Question 1
"Give me some example colors in ARGB format for Android Jetpack Compose."

#### Question 2
"How to insert a drawable resource in Jetpack Compose?"

#### Question 3
"Give me some example contacts and code to generate random contacts."

#### Question 4
"Show me the property need to add a snackbar to a floating action button click in Jetpack Compose."

#### Question 5
Copilot for inline code suggestions


3. What you kept or discarded from the output.

#### Question 1
```agsl
.background(Color(0xFF2196F3))
.background(Color(0xFF4CAF50)),
.background(Color(0xFFFF9800)),
.background(Color(0xFF9C27B0)),

```

#### Question 2
```agsl
Image(
    painter = painterResource(id = R.drawable.user),
    contentDescription = "Profile Picture",
    modifier = Modifier.fillMaxSize(),
    contentScale = ContentScale.Crop
)
```

#### Question 3
```agsl
val firstNames = listOf(
        "James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda",
        "William", "Elizabeth", "David", "Barbara", "Richard", "Susan", "Joseph", "Jessica",
        "Thomas", "Sarah", "Charles", "Karen", "Christopher", "Nancy", "Daniel", "Lisa",
        "Matthew", "Betty", "Anthony", "Helen", "Mark", "Sandra", "Donald", "Donna",
        "Steven", "Carol", "Paul", "Ruth", "Andrew", "Sharon", "Joshua", "Michelle",
        "Kenneth", "Laura", "Kevin", "Emily", "Brian", "Kimberly", "George", "Deborah",
        "Edward", "Dorothy", "Ronald", "Amy", "Timothy", "Angela", "Jason", "Ashley"
    )

    val lastNames = listOf(
        "Anderson", "Brown", "Clark", "Davis", "Edwards", "Foster", "Garcia", "Hall",
        "Johnson", "King", "Lewis", "Martinez", "Nelson", "O'Brien", "Parker", "Quinn",
        "Robinson", "Smith", "Taylor", "Underwood", "Vasquez", "Williams", "Xavier", "Young",
        "Zhang", "Adams", "Baker", "Campbell", "Dixon", "Evans", "Franklin", "Green",
        "Harris", "Irving", "Jones", "Klein", "Lopez", "Miller", "Newton", "Owen",
        "Peterson", "Quincy", "Roberts", "Scott", "Thompson", "Urban", "Vincent", "White",
        "Xander", "Yates", "Zimmerman", "Bailey", "Cooper", "Davidson"
    )
    
    val phoneNumber = String.format(
        Locale.US,
        "(%03d) %03d-%04d",
        (200..999).random(),
        (200..999).random(),
        (1000..9999).random()
    )
```

#### Question 4
```agsl
onClick = {
    coroutineScope.launch {
        snackbarHostState.showSnackbar(
            message = "FAB clicked! 🎉",
            actionLabel = "OK",
            duration = SnackbarDuration.Short
        )
    }
},
```


#### Question 5
```agsl
color = MaterialTheme.colorScheme.error,
style = MaterialTheme.typography.bodySmall
focusedBorderColor = MaterialTheme.colorScheme.primary,
unfocusedBorderColor = MaterialTheme.colorScheme.outline,
errorBorderColor = MaterialTheme.colorScheme.error

```