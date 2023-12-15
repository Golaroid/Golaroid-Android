package com.idea_festival.design_system.component.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@Composable
fun GolaroidButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    GolaroidAndroidTheme { colors, typography ->
        val interactionSource = remember { MutableInteractionSource() }

        Button(
            modifier = modifier,
            interactionSource = interactionSource,
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.MAIN,
                contentColor = colors.BLACK,
            ),
            contentPadding = PaddingValues(vertical = 20.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = text,
                style = typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
fun GolaroidButtonPre() {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        GolaroidButton(
            text = "사진찍기",
            modifier = Modifier
                .width(328.dp)
                .height(61.dp),
        ) {
        }
    }
}