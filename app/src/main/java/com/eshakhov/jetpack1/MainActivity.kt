package com.eshakhov.jetpack1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eshakhov.jetpack1.ui.theme.JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ListItem(name = "Zac Efron1", prof = "Actor")
                ListItem(name = "Zac Efron2", prof = "Actor")
                ListItem(name = "Zac Efron3", prof = "Actor")
                ListItem(name = "Zac Efron4", prof = "Actor")
                ListItem(name = "Zac Efron5", prof = "Actor")
                ListItem(name = "Zac Efron6", prof = "Actor")
                ListItem(name = "Zac Efron7", prof = "Actor")
                ListItem(name = "Zac Efron8", prof = "Actor")
                ListItem(name = "Zac Efron9", prof = "Actor")
                ListItem(name = "Zac Efron0", prof = "Actor")
                ListItem(name = "Zac Efron-", prof = "Actor")
                ListItem(name = "Zac Efron=", prof = "Actor")
                ListItem(name = "Zac Efronq", prof = "Actor")
                ListItem(name = "Zac Efronw", prof = "Actor")
                ListItem(name = "Zac Efrone", prof = "Actor")
                ListItem(name = "Zac Efronr", prof = "Actor")
                ListItem(name = "Zac Efront", prof = "Actor")
                ListItem(name = "Zac Efrony", prof = "Actor")
                ListItem(name = "Zac Efronu", prof = "Actor")
                ListItem(name = "Zac Efroni", prof = "Actor")
                ListItem(name = "Zac Efrono", prof = "Actor")
                ListItem(name = "Zac Efronp", prof = "Actor")
                ListItem(name = "Zac Efron[", prof = "Actor")
            }
        }
    }
}

@Composable
private fun ListItem(name: String, prof: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                Log.d("tag1", "Clicked")
            }
            .pointerInput(Unit) {
//                detectDragGesturesAfterLongPress { change, dragAmount ->
//                    Log.d("tag2", "Long pressed: $dragAmount")
//                    Log.d("tag3", "Long pressed: ${change.isConsumed}")
//                }
//                detectTapGestures {
//                    Log.d("tag4", "detectTapGestures: $it")
//                }
                detectHorizontalDragGestures { change, dragAmount ->
                    Log.d("tag5", "detectHorizontalDragGestures: $dragAmount")
                }
            },
        shape = RoundedCornerShape(15.dp),
//        elevation = 5.dp
    ) {
        Box() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column (
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = name)
                    Text(text = prof)
                }
            }
        }
    }
}