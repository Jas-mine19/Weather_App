package com.example.weatherapp

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.model.FutureModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            WeatherScreen()

        }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
    }
}


@Preview
@Composable
private fun WeatherScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(
                            android.graphics.Color.parseColor("#59469d")
                        ),
                        Color(android.graphics.Color.parseColor("#643d67"))
                    )
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = "Mostly Cloudy",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 48.dp),
                        textAlign = TextAlign.Center
                    )

                    Image(
                        painter = painterResource(id = R.drawable.cloudy_sunny),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(top = 8.dp)
                    )

                    Text(
                        text = "Mon Jube 17 | 10:00 AM",
                        fontSize = 19.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp),
                        textAlign = TextAlign.Center
                    )

                    //Display temperature details

                    Text(
                        text = "25º",
                        fontSize = 63.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "H:27 L:18",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 5.dp),
                        textAlign = TextAlign.Center
                    )

//
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp)
                            .background(
                                color = colorResource(id = R.color.purple),
                                shape = RoundedCornerShape(25.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .height(100.dp)
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            WeatherDetailItem(
                                icon = R.drawable.rain,
                                value = "22%",
                                label = "Rain"
                            )
                            WeatherDetailItem(
                                icon = R.drawable.wind,
                                value = "12km/h",
                                label = "Wind speed"
                            )
                            WeatherDetailItem(
                                icon = R.drawable.humidity,
                                value = "18%",
                                label = "Humidity"
                            )


                        }
                    }

                    //Displaying today weather
                    Text(
                        text = "Today",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    LazyRow(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp, top = 10.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        item {
                            TodayWeatherDetailItem(
                                time = "7 am",
                                icon = R.drawable.windy,
                                temperature = "25º"
                            )
                            TodayWeatherDetailItem(
                                time = "8 am",
                                icon = R.drawable.sunny,
                                temperature = "26º"
                            )
                            TodayWeatherDetailItem(
                                time = "9 am",
                                icon = R.drawable.cloudy,
                                temperature = "27º"
                            )
                            TodayWeatherDetailItem(
                                time = "10 am",
                                icon = R.drawable.snowy,
                                temperature = "28º"
                            )
                            TodayWeatherDetailItem(
                                time = "11 am",
                                icon = R.drawable.cloudy,
                                temperature = "25º"
                            )

                        }
                    }

                    //Display Future

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Future", fontSize = 18.sp, modifier = Modifier.weight(1f),
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "Next 7 Day >", fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }


                }
                items(listOfFuture){
                    FutureItem(item = it)
                }
            }

        }
    }
}


@Composable
fun WeatherDetailItem(icon: Int, value: String, label: String) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(34.dp)
        )

        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )

        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TodayWeatherDetailItem(time: String, icon: Int, temperature: String) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(100.dp)
            .padding(start = 8.dp)
            .background(
                color = colorResource(id = R.color.purple),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = time, fontSize = 12.sp, color = Color.White)
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = temperature, fontSize = 12.sp, color = Color.White)
        }
    }
}

val listOfFuture = listOf(
    FutureModel("Sat", "storm", "Storm", 21, 7),
    FutureModel("Sun", "cloudy", "Cloudy", 23, 8),
    FutureModel("Mon", "windy", "Windy", 21, 7),
    FutureModel("Tue", "cloudy_sunny", "Cloudy Sunny", 21, 7),
    FutureModel("Wen", "sunny", "Sunny", 21, 7),
    FutureModel("Thu", "rainy", "Rainy", 21, 7)
)

@Composable
fun FutureItem(item: FutureModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = item.day, color = Color.White, fontSize = 14.sp)
        Image(
            painter = painterResource(id = getDrawableResource(picPath = item.picPath)),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 32.dp)
                .size(45.dp)
        )

        Text(text = item.status, color = Color.White, fontSize = 14.sp, modifier = Modifier.weight(1f).padding(16.dp))

        Text(text = "${item.highTemp}º", modifier = Modifier.padding(end = 16.dp), color = Color.White, fontSize = 14.sp)
        Text(text = "${item.lowTemp}º", modifier = Modifier.padding(end = 16.dp), color = Color.White, fontSize = 14.sp)

    }
}

@Composable
fun getDrawableResource(picPath: String): Int {
    return when (picPath) {
        "storm" -> R.drawable.storm
        "cloudy" -> R.drawable.cloudy
        "windy" -> R.drawable.windy
        "cloudy_sunny" -> R.drawable.cloudy_sunny
        "sunny" -> R.drawable.sunny
        "rainy" -> R.drawable.rainy

        else -> R.drawable.sunny

    }
}
