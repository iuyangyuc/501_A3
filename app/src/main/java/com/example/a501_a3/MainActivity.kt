package com.example.a501_a3

import java.util.Locale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a501_a3.ui.theme._501_A3Theme
import kotlinx.coroutines.launch

// Data class for Contact
data class Contact(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String
) {
    val fullName: String get() = "$firstName $lastName"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _501_A3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactListScreen(modifier: Modifier = Modifier) {
    val contacts = remember { generateSampleContacts() }
    val groupedContacts = remember {
        contacts.sortedBy { it.lastName }.groupBy { it.lastName.first().uppercaseChar() }
    }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Determine if FAB should be visible (after scrolling past item 10)
    val showScrollToTop by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 10
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            groupedContacts.forEach { (letter, contactsForLetter) ->
                // Sticky Header for each letter group
                stickyHeader {
                    LetterHeader(letter = letter)
                }

                // Contact items for this letter
                items(
                    items = contactsForLetter,
                    key = { contact -> contact.id }
                ) { contact ->
                    ContactItem(contact = contact)
                }
            }
        }

        // Scroll to Top FAB
        AnimatedVisibility(
            visible = showScrollToTop,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                    }
                },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Scroll to Top",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun LetterHeader(letter: Char) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        color = MaterialTheme.colorScheme.primaryContainer,
        shadowElevation = 2.dp
    ) {
        Text(
            text = letter.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Avatar",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Contact Details
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = contact.fullName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = contact.phone,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = contact.email,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// Generate sample contacts (50+ contacts)
fun generateSampleContacts(): List<Contact> {
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

    val contacts = mutableListOf<Contact>()
    var id = 1

    // Generate at least 50 contacts
    for (i in 0 until 55) {
        val firstName = firstNames[i % firstNames.size]
        val lastName = lastNames[i % lastNames.size]
        val phoneNumber = String.format(
            Locale.US,
            "(%03d) %03d-%04d",
            (200..999).random(),
            (200..999).random(),
            (1000..9999).random()
        )
        val email = "${firstName.lowercase()}.${lastName.lowercase()}@example.com"

        contacts.add(
            Contact(
                id = id++,
                firstName = firstName,
                lastName = lastName,
                phone = phoneNumber,
                email = email
            )
        )
    }

    return contacts
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    _501_A3Theme {
        ContactListScreen()
    }
}