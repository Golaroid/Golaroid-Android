package com.idea_festival.presentation.ui.capture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.icon.WhiteCircleIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@Composable
fun CaptureRoute() {
    CaptureScreen()
}
@Composable
fun CaptureScreen() {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colors.BLACK)
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(1f))


                Text(
                    text = "남은 사진 " + "n개",
                    style = typography.headlineSmall,
                    color = colors.WHITE,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.weight(1f))

                Box {

                    WhiteCircleIcon(
                        modifier = Modifier
                            .width(49.dp)
                            .height(49.dp)
                            .padding()
                    )

                    Text(
                        text = "10",
                        style = typography.titleSmall,
                        color = colors.WHITE,
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    )

                }


                Spacer(modifier = Modifier.width(16.dp))

            }
        }

    }
}

@Preview
@Composable
fun CaptureScreenPre() {
    CaptureScreen()
}
