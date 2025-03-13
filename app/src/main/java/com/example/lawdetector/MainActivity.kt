package com.example.lawdetector

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DynamicForm
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.KeyboardDoubleArrowUp
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.NotificationImportant
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Rocket
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.lawdetector.ui.theme.LawDetectorTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LawDetectorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    "协议条款风险评估",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            content = {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    MyIconButton(onClick = {}, icon = MyIcon.Dashboard, text = "首页")
                                    MyIconButton(onClick = {}, icon = MyIcon.History, text = "历史")
                                    MyIconButton(onClick = {}, icon = MyIcon.Person, text = "我的")
                                }
                            }
                        )
                    }

                ) { innerPadding ->
                    MainPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

}

val MyIcon = Icons.Filled

@Composable
fun MyIconButton(onClick: () -> Unit,
                 icon: ImageVector,
                 text: String
                 ){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center
    ) {
        IconButton(
            onClick = onClick,
            content = {
                Icon(
                    icon,
                    contentDescription = null
                )
            }
        )
        Text(
            text = text
        )
    }

}

@Composable
fun MainPage(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()

    ) {
        MainCard(Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(16.dp))
        SecondCard(Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 16.dp)
        )
        ExtendedFloatingActionButton(
            onClick = {},
            icon = { Icon(MyIcon.PlayArrow, "Extended floating action button.") },
            text = { Text(text = "开始扫描") },
            modifier = Modifier.fillMaxSize().padding(16.dp),
            containerColor = Color(0xff0e3d37),
            contentColor = Color(0xffffffff)
        )
    }
}

@Composable
fun MainCard(modifier: Modifier){
    val context = LocalContext.current
    OutlinedCard(
        onClick = {
            val intent = Intent(context, ResultPage::class.java)
            context.startActivity(intent)
        },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    MyIcon.Policy,
                    contentDescription = null
                )
                Text(
                    text = "距离上次扫描",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "已过去",
                    fontSize = 20.sp
                )
                Text(
                    text = "4天",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row {
                    Icon(
                        MyIcon.NotificationImportant,
                        contentDescription = null
                    )
                    Text(
                        text = "已知风险"
                    )
                }
                Text(
                    text = "23条"
                )
            }
        }
    }
}

@Composable
fun SecondCard(modifier: Modifier){
    Row(modifier) {
        ModelChangeCard(modifier = Modifier
            .padding(0.dp, 0.dp, 16.dp, 0.dp)
        )
        InfoCard(modifier = Modifier
            .fillMaxWidth()
        )
    }
}

@Composable
fun ModelChangeCard(modifier: Modifier){
    OutlinedCard(
        modifier = modifier,
        onClick = {}
        ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    MyIcon.DynamicForm,
                    contentDescription = null
                )
                Text(
                    text = "当前模型",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = true,
                    onClick = {}
                )
                Text(
                    text = "DeepSeek-R1"
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = false,
                    onClick = {}
                )
                Text(
                    text = "通义千问"
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = false,
                    onClick = {}
                )

                val rainbowColors = listOf(
                    Color( 0xffff0000),
                    Color( 0xffe50d15),
                    Color( 0xffca1a2b),
                    Color( 0xffb02740),
                    Color( 0xff953455),
                    Color( 0xff7b406b),
                    Color( 0xff604d80),
                    Color( 0xff465a95),
                    Color( 0xff2b67ab),
                    Color( 0xff1174c0)

                )

                Text(
                    text = "RiskAnalyser(VIP)",
                    style = TextStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                )
            }
        }
    }
}

@Composable
fun InfoCard(modifier: Modifier){
    Column(modifier) {
        OutlinedCard(
            modifier = modifier
                .height(142.dp)
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
            onClick = {}
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        MyIcon.Rocket,
                        contentDescription = null
                    )
                    Text(
                        text = "已守护您"
                    )
                }
                Text(
                    text = "32天"
                )
            }
        }
        OutlinedCard(
            modifier = modifier
                .height(142.dp),
            onClick = {}
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        MyIcon.Memory,
                        contentDescription = null
                    )
                    Text(
                        text = "已扫描到应用"
                    )
                }
                Text(
                    text = "26个"
                )
            }
        }
    }
}