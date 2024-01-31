package com.example.weatherapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.ui.theme.LightGreen

@Composable
fun ListItem(item:WeatherModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        shape = RoundedCornerShape(5.dp),
        backgroundColor =  LightGreen,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    )
            ) {
                Text(text = item.time,
                    color = Color.White)
                Text(text = item.condition,
                    color = Color.White)
            }
            Text(text = item.currentTemp.ifEmpty { "${item.maxTemp}/${item.minTemp}" } + "°C",
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )
            AsyncImage(
                "https:${item.icon}",
                contentDescription = "icon",
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
            )
        }
    }
}