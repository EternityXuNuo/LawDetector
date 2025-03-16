package com.example.lawdetector

import android.content.Intent
import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CardMembership
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lawdetector.ui.theme.LawDetectorTheme

class UserPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LawDetectorTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomAppBar(
                            content = {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    MyIconButton(checked = false,onCheckedChange = {}, icon = MyIcon.Dashboard, text = "首页")
                                    MyIconButton(
                                        checked = false,
                                        onCheckedChange = {

                                        },
                                        icon = MyIcon.History,
                                        text = "历史"
                                    )
                                    MyIconButton(checked = true,
                                        onCheckedChange = {

                                        },
                                        icon = MyIcon.Person,
                                        text = "我的"
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    UserPage(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UserPage(modifier: Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Avatar(modifier = Modifier)
        AdCard(modifier = Modifier.padding(16.dp))
        UserCard(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp))
    }
}

@Composable
fun Avatar(modifier: Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.avatar),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "用户000001",
                fontWeight = FontWeight.Bold
            )
            Icon(
                painterResource(R.drawable.vip),
                contentDescription = null,
                tint = Color(0xffffbf00),
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp, 0.dp, 8.dp, 0.dp)
            )
        }
    }
}

@Composable
fun AdCard(modifier: Modifier){
    Box(modifier) {
        Card {
            Image(
                painterResource(R.drawable.ad),
                contentDescription = null
            )
        }
        Text(
            text = "广告",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun UserCard(modifier: Modifier){
    val context = LocalContext.current
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            SingleOption(MyIcon.AccountCircle, "个人信息", onClick = {

            })
            SingleOption(
                MyIcon.CardMembership,
                "我的权益",
                onClick = {
                    val intent = Intent(context, MemberShip::class.java)
                    context.startActivity(intent)
                }
            )
            SingleOption(MyIcon.SupportAgent, "在线客服", onClick = {})
            SingleOption(MyIcon.Settings, "设置", onClick = {})
            SingleOption(MyIcon.Logout, "退出登录", onClick = {})
        }
    }
}

@Composable
fun SingleOption(icon: ImageVector, text: String, onClick: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
            )
            Text(
                text = text
            )
        }
        Icon(
            MyIcon.ChevronRight,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun MyView(){
    UserCard(
        Modifier.padding(16.dp)
    )
}