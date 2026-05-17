package com.shootermind.app.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shootermind.app.R
import com.shootermind.app.ui.theme.ShooterMindTheme

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onContinueAsGuest: () -> Unit,
    onEmailLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.onboarding_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 28.dp, vertical = 28.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = stringResource(R.string.login_title),
                modifier = Modifier.padding(top = 16.dp),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D235C)
            )
            Text(
                text = stringResource(R.string.login_subtitle),
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF4F4867)
            )

            Column(
                modifier = Modifier.padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LoginFeature(text = stringResource(R.string.login_feature_track))
                LoginFeature(text = stringResource(R.string.login_feature_analyze))
                LoginFeature(text = stringResource(R.string.login_feature_focus))
            }

            Spacer(modifier = Modifier.height(250.dp))

            Button(
                onClick = onContinueAsGuest,
                enabled = !uiState.isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7C55E7)
                )
            ) {
                Text(
                    text = if (uiState.isLoading) {
                        stringResource(R.string.login_guest_loading)
                    } else {
                        stringResource(R.string.login_get_started)
                    },
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            if (uiState.errorMessage != null) {
                Text(
                    text = stringResource(R.string.login_guest_error),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFB3261E)
                )
            }
            OutlinedButton(
                onClick = onEmailLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White.copy(alpha = 0.78f),
                    contentColor = Color(0xFF4F35A3)
                )
            ) {
                Text(
                    text = stringResource(R.string.login_log_in),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 12.dp),
                    color = Color(0xFFD8CFF4)
                )
                Text(
                    text = stringResource(R.string.login_or),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF756E86)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 12.dp),
                    color = Color(0xFFD8CFF4)
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White.copy(alpha = 0.78f),
                        contentColor = Color(0xFF4F35A3)
                    )
                ) {
                    Text(text = stringResource(R.string.login_google_short))
                }
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White.copy(alpha = 0.78f),
                        contentColor = Color(0xFF4F35A3)
                    )
                ) {
                    Text(text = stringResource(R.string.login_facebook_short))
                }
            }

            OutlinedButton(
                onClick = onCreateAccountClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White.copy(alpha = 0.62f),
                    contentColor = Color(0xFF4F35A3)
                )
            ) {
                Text(text = stringResource(R.string.login_create_account))
            }
        }
    }
}

@Composable
private fun LoginFeature(
    text: String
) {
    AssistChip(
        onClick = { },
        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF30294D)
            )
        },
        shape = RoundedCornerShape(16.dp),
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color.White.copy(alpha = 0.68f),
            labelColor = Color(0xFF30294D)
        ),
        border = null,
        leadingIcon = {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .background(
                        color = Color(0xFFE7DAFF),
                        shape = RoundedCornerShape(9.dp)
                    )
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    ShooterMindTheme {
        LoginScreen(
            uiState = LoginUiState(),
            onContinueAsGuest = {},
            onEmailLoginClick = {},
            onCreateAccountClick = {}
        )
    }
}
