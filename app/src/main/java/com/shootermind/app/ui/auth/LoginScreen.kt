package com.shootermind.app.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shootermind.app.R
import com.shootermind.app.ui.components.TargetMark
import com.shootermind.app.ui.theme.ShooterMindTheme

@Composable
fun LoginScreen(
    onContinueAsGuest: () -> Unit,
    onCreateAccountClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        TargetMark(
            modifier = Modifier.padding(top = 24.dp)
        )
        Text(
            text = stringResource(R.string.login_title),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(R.string.login_subtitle),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                LoginFeature(text = stringResource(R.string.login_feature_track))
                LoginFeature(text = stringResource(R.string.login_feature_analyze))
                LoginFeature(text = stringResource(R.string.login_feature_focus))
            }
        }

        Button(
            onClick = onContinueAsGuest,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.login_guest))
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.login_email))
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.login_google))
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.login_facebook))
        }
        OutlinedButton(
            onClick = onCreateAccountClick,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.login_create_account))
        }
    }
}

@Composable
private fun LoginFeature(
    text: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 7.dp)
                .size(6.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    ShooterMindTheme {
        LoginScreen(
            onContinueAsGuest = {},
            onCreateAccountClick = {}
        )
    }
}
