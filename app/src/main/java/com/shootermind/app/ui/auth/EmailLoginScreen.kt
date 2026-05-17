package com.shootermind.app.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shootermind.app.R
import com.shootermind.app.ui.components.TargetMark
import com.shootermind.app.ui.theme.ShooterMindTheme

@Composable
fun EmailLoginScreen(
    uiState: AuthFormUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onBackToWelcomeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        TargetMark(modifier = Modifier.padding(top = 24.dp))
        Text(
            text = stringResource(R.string.login_email_title),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(R.string.login_email_subtitle),
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
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = uiState.email,
                    onValueChange = onEmailChange,
                    label = { Text(text = stringResource(R.string.register_email_hint)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                OutlinedTextField(
                    value = uiState.password,
                    onValueChange = onPasswordChange,
                    label = { Text(text = stringResource(R.string.register_password_hint)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation()
                )
            }
        }

        Button(
            onClick = onLoginClick,
            enabled = !uiState.isLoading,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (uiState.isLoading) {
                    stringResource(R.string.login_email_loading)
                } else {
                    stringResource(R.string.login_email_action)
                }
            )
        }
        if (uiState.hasEmptyFieldsError || uiState.errorMessage != null) {
            Text(
                text = if (uiState.hasEmptyFieldsError) {
                    stringResource(R.string.auth_empty_fields_error)
                } else {
                    uiState.errorMessage ?: stringResource(R.string.auth_error)
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error
            )
        }
        OutlinedButton(
            onClick = onBackToWelcomeClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.register_back_to_login))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmailLoginScreenPreview() {
    ShooterMindTheme {
        EmailLoginScreen(
            uiState = AuthFormUiState(),
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onBackToWelcomeClick = {}
        )
    }
}
