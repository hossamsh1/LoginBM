package com.example.bmloginpg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmloginpg.ui.theme.BmLoginPgTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmLoginPgTheme {
                BmLogin()
            }
        }
    }
}

@Composable
fun BmLogin() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bm_icon),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 10.dp)
                )

                Text(
                    text = "العربية",
                    fontSize = 30.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 125.dp)
                )
            }

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 100.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = userName,
                onValueChange = { userName = it },
                label = { Text(text = "user name") }
            )

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "password") },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.password),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(30.dp)
                    )
                }
            )

            Text(
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline,
                text = "forgot username/password ?",
                modifier = Modifier
                    .padding(top = 10.dp, end = 150.dp)
                    .alpha(0.9f)
            )

            FilledTonalButton(
                onClick = { },
                 shape = RoundedCornerShape(10.dp)
                ,enabled = userName.isNotEmpty() && password.isNotEmpty()
                ,colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = colorResource(id = R.color.line))
                ,modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(20.dp)
                    .padding(start = 20.dp, end = 20.dp, top = 70.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(bottom = 10.dp, top = 10.dp)
                        .align(alignment=Alignment.CenterVertically)
                )
            }

            Row (modifier = Modifier
                .padding(end = 180.dp , top = 10.dp)){
            Text(text = "Need help ?")
            Text(text ="Contact Us" ,
                 color = Color.Red,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    )
            }

Row (modifier=Modifier
    .padding(all = 20.dp)
    .fillMaxWidth()){
    Box(modifier= Modifier
        .fillMaxWidth()
        .background(Color(0xFFDB808A))
        .width(1.dp)
        .height(1.dp))
}
            Row (horizontalArrangement = Arrangement.SpaceEvenly
                ,modifier=Modifier.padding(top=50.dp)){
                ImageWithText(modifier = Modifier, text = "Out products", imgIcon = R.drawable.our_products)
                ImageWithText(modifier = Modifier, text = "Exchange\nrate", imgIcon = R.drawable.exchange_rate)
                ImageWithText(modifier = Modifier, text = "Security tips", imgIcon = R.drawable.security_tips)
                ImageWithText(modifier = Modifier ,text = "Nearest\nbranch of\nATM", imgIcon =R.drawable.nearest_branch_or_atm )
            }

        }
    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun BmLoginPgPreview() {
    BmLoginPgTheme {
        BmLogin()
    }
}

@Composable
private fun ImageWithText(modifier: Modifier, text: String, imgIcon: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 24.dp, start = 4.dp, end = 4.dp)
    ) {
        Image(
            painter = painterResource(id = imgIcon),
            contentDescription = "",
            modifier = modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}
