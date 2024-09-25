package com.nkee.roomplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BasicAlertDialog(onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        },
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.background(color = Color.White)

        ) {
            Text(text = "Add contact")
            TextField(
                value = state.firstName,
                onValueChange = { onEvent(ContactEvent.SetFirstName(it)) },
                label = { Text("First name") }
            )
            TextField(
                value = state.lastName,
                onValueChange = { onEvent(ContactEvent.SetLastName(it)) },
                label = { Text("Last name") }
            )
            TextField(
                value = state.phoneNumber,
                onValueChange = { onEvent(ContactEvent.SetPhoneNumber(it)) },
                label = { Text("Phone number") }
            )
            Box(
                modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {onEvent(ContactEvent.SaveContact)}) { }
            }
        }
    }
}