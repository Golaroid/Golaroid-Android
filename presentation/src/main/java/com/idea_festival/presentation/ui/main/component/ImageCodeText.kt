package com.idea_festival.presentation.ui.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@Composable
fun ImageCodeText(modifier: Modifier = Modifier) {
    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .background(
                    color = colors.GRAY2.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(horizontal = 4.dp, vertical = 5.dp),
        ) {
            Row(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(
                    text = "이동욱 ",
                    style = typography.labelSmall,
                    color = colors.WHITE,
                )

                Text(
                    text = "F239AS",
                    style = typography.labelSmall,
                    color = colors.WHITE
                )
            }
        }
    }
}

@Preview
@Composable
fun ImageCodeTextPre() {
    ImageCodeText()
}
