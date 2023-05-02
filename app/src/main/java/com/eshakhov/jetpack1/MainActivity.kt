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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eshakhov.jetpack1.ui.theme.Grey100
import com.eshakhov.jetpack1.ui.theme.JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Grey100)
                ,
            ) {
                itemsIndexed(
                    listOf(
                        ItemRowModel(R.drawable.image_1, "Миша", "placerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem rectequeplacerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem recteque"),
                        ItemRowModel(R.drawable.image_2, "Вася", "placerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem rectequeplacerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem recteque"),
                        ItemRowModel(R.drawable.image_3, "Толя", "placerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem rectequeplacerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem recteque"),
                        ItemRowModel(R.drawable.image_1, "Дима", "placerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem rectequeplacerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem recteque"),
                        ItemRowModel(R.drawable.image_5, "Женя", "placerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem rectequeplacerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem recteque"),
                        ItemRowModel(R.drawable.image_6, "Костя", "placerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem rectequeplacerat ancillae nihil vero nihil expetenda sem moderatius mus nullam mediocritatem recteque"),
                    )
                ){
                    _, item ->
                    MyRow(item = item)
                }
            }
        }
    }
}

@Composable
private fun CircleItem() {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.Blue)
    }
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                when (++counter.value) {
                    10 -> color.value = Color.Red
                    20 -> color.value = Color.Green
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = counter.value.toString(),
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
private fun ListItem(name: String = "name", prof: String = "prof") {
    val counter = remember {
        mutableStateOf(0)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                counter.value++
            },
        shape = RoundedCornerShape(15.dp),
//        elevation = 5.dp
    ) {
        Box() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
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
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = counter.value.toString())
                    Text(text = prof + counter.value.toString())
                }
            }
        }
    }
}