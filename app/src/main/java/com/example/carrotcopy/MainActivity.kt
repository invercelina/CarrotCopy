package com.example.carrotcopy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrotcopy.ui.theme.CarrotCopyTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarrotCopyTheme {
                MainScreen()
            }
        }
    }

    data class CarrotItems(
        val photoId: Int,
        val title: String,
        val itemLocation: String,
        val price: Int,
    )

    val itemList = listOf(
        CarrotItems(
            photoId = R.drawable.ic_launcher_background,
            title = "산지 한달 된 선풍기 팝니다",
            itemLocation = "서울 서대문구 창천동",
            price = 1000
        ),
        CarrotItems(
            photoId = R.drawable.ic_launcher_background,
            title = "산지 한달 된 선풍기 팝니다",
            itemLocation = "서울 서대문구 창천동",
            price = 1000
        ),
        CarrotItems(
            photoId = R.drawable.ic_launcher_background,
            title = "산지 한달 된 선풍기 팝니다",
            itemLocation = "서울 서대문구 창천동",
            price = 1000
        )
    )


    @Composable
    fun MainScreen() {
        Column(modifier = Modifier.fillMaxHeight()) {
            LocalList()
            itemList.forEach { item ->
                CarrotMain(carrotItems = item)
            }
        }
    }

    @Composable
    fun CarrotMain(carrotItems: CarrotItems) {
        Column {
            Row(modifier = Modifier.fillMaxWidth(1f)) {
                Image(
                    painter = painterResource(id = carrotItems.photoId),
                    contentDescription = "물품",
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = carrotItems.title,
                        modifier = Modifier.padding(3.dp),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = carrotItems.itemLocation,
                        color = Color.Gray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding((3.dp)),
                    )
                    Text(
                        text = String.format(Locale.KOREA, "%,d원", carrotItems.price),
                        modifier = Modifier.padding(3.dp),
                        fontWeight = FontWeight.Bold,
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_add_call_24),
                            contentDescription = "addCall",
                            modifier = Modifier.size(20.dp),
                        )
                        Text(text = "13")
                        Image(
                            painter = painterResource(id = R.drawable.baseline_bookmarks_24),
                            contentDescription = "bookmark",
                            modifier = Modifier
                                .padding(start = 5.dp, end = 2.dp)
                                .size(20.dp)
                        )
                        Text(text = "9")

                    }
                }
            }
            Divider(thickness = 1.dp, modifier = Modifier.padding(4.dp))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        CarrotCopyTheme {
            MainScreen()
        }
    }

    @Composable
    fun LocalList() {
        var showList by remember { mutableStateOf(false) }
        val localPlaces = listOf("Place 1", "Place 2", "Place 3", "Place 4")
        Box(
            modifier = Modifier
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .border(1.dp, Color.Gray)
                    .padding(5.dp)
                    .background(Color.White)
            ) {
                Column{
                    Button(onClick = { showList = !showList }) {
                        Text(text = if (showList) "Hide Places" else "Show Places")
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    if (showList) {
                        localPlaces.forEach { place ->
                            Text(text = place, modifier = Modifier
                                .padding(5.dp)
                                .clickable { /*ToDo*/ })
                        }
                    }
                    Divider(color = Color.Gray)
                }
            }

        }
    }
}
