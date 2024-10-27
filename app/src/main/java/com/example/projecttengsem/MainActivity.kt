package com.example.projecttengsem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecttengsem.ui.theme.DashboardAppTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashboardAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "dashboard") {
                    composable("dashboard") { DashboardScreen(navController) }
                    composable("stok_barang") { StokBarangScreen() }
                    composable("perhitungan") { PerhitunganScreen() }
                    composable("belanja_stok") { BelanjaStokScreen() }
                    composable("distributor") { DistributorScreen() }
                }
            }
        }
    }
}

@Composable
fun StokBarangScreen() {
    /*TODO Daftar afirmasi sederhana yang langsung di-hardcode di sini*/
    val affirmationList = listOf(
        "bengbeng" to R.drawable.beng_beng,
        "pilus" to R.drawable.pilus,
        "momogi" to R.drawable.momogi,
        "chocolatos" to R.drawable.chocolatos
    )

    /*TODO Menampilkan daftar afirmasi dengan LazyColumn*/
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(affirmationList.size) { index ->
            val (text, imageRes) = affirmationList[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = text,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}



@Composable
fun PerhitunganScreen() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Kalkulator kalkulasi barang",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        /* TODO Input pertama */
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Angka Pertama") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        /* TODO Input kedua */
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Angka Kedua") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        /* TODO Tombol operasi */
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { result = calculate(number1, number2, "+") }) {
                Text("+")
            }
            Button(onClick = { result = calculate(number1, number2, "-") }) {
                Text("-")
            }
            Button(onClick = { result = calculate(number1, number2, "*") }) {
                Text("×")
            }
            Button(onClick = { result = calculate(number1, number2, "/") }) {
                Text("÷")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        /* TODO Menampilkan hasil */
        Text(
            text = "Hasil: ${result ?: ""}",
            fontSize = 20.sp
        )
    }
}

/* TODO Fungsi untuk menghitung operasi */
fun calculate(number1: String, number2: String, operator: String): Double? {
    val num1 = number1.toDoubleOrNull()
    val num2 = number2.toDoubleOrNull()
    if (num1 == null || num2 == null) return null

    return when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if (num2 != 0.0) num1 / num2 else null
        else -> null
    }
}


@Composable
fun BelanjaStokScreen() {
    /* TODO Daftar afirmasi sederhana yang langsung di-hardcode di sini */
    val affirmationList = listOf(
        "hilo" to R.drawable.hilo,
        "milo" to R.drawable.milo,
        "mie_sukses" to R.drawable.mie_sukses,
        "chocolatos" to R.drawable.chocolatos
    )

    /* TODO Menampilkan daftar afirmasi dengan LazyColumn */
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(affirmationList.size) { index ->
            val (text, imageRes) = affirmationList[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = text,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}


@Composable
fun DistributorScreen() {
    /* TODO Daftar afirmasi sederhana yang langsung di-hardcode di sini */
    val affirmationList = listOf(
        "sales_1_08854187651" to R.drawable.distributor,
        "sales_2_08854998765" to R.drawable.distributor,
        "sales_3_08854109876" to R.drawable.distributor,
        "sales_4_08854443216" to R.drawable.distributor
    )

    /* TODO Menampilkan daftar afirmasi dengan LazyColumn */
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(affirmationList.size) { index ->
            val (text, imageRes) = affirmationList[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = text,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}


@Composable
fun DashboardScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray) /* TODO Ganti dengan warna latar belakang yang diinginkan */
                .padding(8.dp) /* TODO Padding untuk memberi jarak antara teks dan tepi background */
        ) {
            Text(
                text = "WARUNKU",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterStart) /* TODO Posisikan teks sesuai kebutuhan */
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "home dashboard ketersediaan barang diwarunku.",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            content = {
                items(4) { index ->
                    GridItem(
                        title = when (index) {
                            0 -> "Stok barang"
                            1 -> "Perhitungan"
                            2 -> "Belanja Stok"
                            else -> "Distributor"
                        },
                        imageRes = when (index) {
                            0 -> R.drawable.barang
                            1 -> R.drawable.kakulator
                            2 -> R.drawable.belanja
                            else -> R.drawable.distributor
                        },
                        navController = navController,
                        index = index
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        /* TODO Text berada di dalam Column sehingga align(Alignment.CenterHorizontally) dapat digunakan */
        Text(
            text = "Apk v.0.1",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally) /* TODO Pastikan ini berada di dalam Column */
        )
    }
}



@Composable
fun GridItem(title: String, imageRes: Int, navController: NavHostController, index: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                // Mengganti Log.d dengan println untuk debugging
                println("Item $title diklik")
                when (index) {
                    0 -> navController.navigate("stok_barang")
                    1 -> navController.navigate("perhitungan")
                    2 -> navController.navigate("belanja_stok")
                    else -> navController.navigate("distributor")
                }
            },
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(48.dp)
                    .padding(bottom = 8.dp)
            )
            Text(text = title, fontSize = 14.sp, color = Color.Black)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview() {
    DashboardAppTheme {
        DashboardScreen(navController = rememberNavController())
    }
}

