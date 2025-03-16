package com.example.lawdetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lawdetector.ui.theme.LawDetectorTheme

class MemberShip : ComponentActivity() {
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
                                    "会员中心",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        )
                    }
                    ) { innerPadding ->
                    MemberShip(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MemberShip(modifier: Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MemberShipCard(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        MemberShipDetail(
            Modifier.fillMaxWidth().height(600.dp).padding(16.dp)
        )
    }
}

@Composable
fun MemberShipCard(modifier: Modifier){
    Card(modifier) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(40.dp)
                )
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
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
                                .padding(8.dp, 0.dp, 0.dp, 0.dp)
                                .size(20.dp)
                        )
                    }
                    Text(
                        text = "高级会员2025.09.23过期",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            Button(onClick = {}) {
                Text(
                    text = "续费会员"
                )
            }
        }
    }
}

@Composable
fun MemberShipDetail(modifier: Modifier){

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
     val orange = Color(0xffffbf00)

    Card(modifier) {
        Row(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "高级会员",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = orange
                    )
                    Icon(
                        painterResource(R.drawable.vip),
                        contentDescription = null,
                        tint = orange,
                        modifier = Modifier
                            .padding(8.dp, 0.dp, 0.dp, 0.dp)
                            .size(28.dp)
                    )
                }
                Text(
                    text = "不限使用次数"
                )
                Text(
                    text = "高级分析模型"
                )
                Text(
                    text = "定制化风险预警"
                )
                Text(
                    text = "专属律师通道"
                )
            }
            VerticalDivider(
                modifier = Modifier.padding(8.dp).height(560.dp),
                thickness = 2.dp
            )
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "企业会员",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        style = TextStyle(
                            brush = Brush.linearGradient(
                                colors = rainbowColors
                            )
                        )
                    )
                    Icon(
                        painterResource(R.drawable.vip),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp, 0.dp, 0.dp, 0.dp)
                            .size(28.dp),
                        tint = Color( 0xff114bc0)
                    )
                }
                Text(
                    text = "不限使用次数"
                )
                Text(
                    text = "企业级模型"
                )
                Text(
                    text = "定制化分析报告"
                )
                Text(
                    text = "法务团队培训"
                )
            }
        }
    }
}


@Preview
@Composable
fun ViewCard(){
    MemberShipCard(Modifier
        .fillMaxWidth()
        .padding(16.dp))
}