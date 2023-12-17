package com.idea_festival.design_system.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idea_festival.design_system.component.icon.SearchIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GolaroidTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    onValueChange: (String) -> Unit,
    value: String? = null,
) {
    var text by remember { mutableStateOf(value ?: "") }

    GolaroidAndroidTheme { colors, typography ->
            TextField(
                value = text,
                onValueChange = {
                    text = value ?: it
                    onValueChange(it)
                },
                modifier = modifier.background(color = Color.Transparent),
                shape = RoundedCornerShape(100.dp),
                trailingIcon = {
                    IconButton(onClick = {  }) {
                        SearchIcon()
                    }

                },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = colors.BLACK,
                    unfocusedTextColor = colors.BLACK,
                    cursorColor = colors.GRAY,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedPlaceholderColor = colors.GRAY,
                    focusedPlaceholderColor = colors.GRAY,
                    containerColor = colors.DARKGRAY
                ),
                placeholder = {
                    Text(
                        text = placeholder,
                        style = typography.labelMedium,
                        color = colors.GRAY,
                        fontSize = 14.sp
                    )
                }
            )
        }
    }


@Preview
@Composable
fun GolaroidTextFieldPre() {
    GolaroidTextField(
        modifier = Modifier.fillMaxWidth(),
        placeholder = "코드를 입력해 주세요",
        onValueChange = {},
    )
}