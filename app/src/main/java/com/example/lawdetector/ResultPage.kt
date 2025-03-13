package com.example.lawdetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lawdetector.ui.theme.LawDetectorTheme

class ResultPage : ComponentActivity() {
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
                                    "检测结果",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        )
                    }
                ) { innerPadding ->
                    ResultList(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ResultList(modifier: Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ResultCard(
            icon = painterResource(R.drawable.wechat),
            name = "微信",
            time = "2025/3/6",
            model = "DeepSeek-R1",
            infoA = "账号所有权归腾讯，用户仅有使用权\n" +
                    "用户注册的微信账号所有权属于腾讯，用户仅获得使用权，且不得转让、出租或出售账号，否则腾讯有权采取封号、注销等措施。\n" +
                    "\n" +
                    "用户对账号安全负全责\n" +
                    "若因用户未妥善保管账号密码导致被盗或冒用，相关法律责任由用户自行承担，腾讯仅在用户提供有效身份证明后协助处理，但因此造成的损失仍由用户承担。\n" +
                    "\n" +
                    "客服行为由用户全权负责\n" +
                    "企业用户使用微信客服功能时，需对客服人员的所有行为（包括发布违法信息或侵权内容）承担全部责任，腾讯不参与纠纷处理。\n" +
                    "\n" +
                    "腾讯可单方面终止服务\n" +
                    "若用户违反协议条款（如发布违法内容），腾讯有权随时限制、中止或终止服务，且无需承担赔偿责任",
            infoB = "腾讯可单方面修改软件功能\n" +
                    "腾讯有权不经通知对软件功能进行更新、调整或限制，旧版本可能无法继续使用，用户需自行承担兼容性风险。\n" +
                    "\n" +
                    "数据存储责任转移至用户\n" +
                    "微信客服交互信息仅保存在用户终端，腾讯不负责存储，若因用户操作导致数据丢失，腾讯不承担争议责任。\n" +
                    "\n" +
                    "同一身份信息注册账号数量受限\n" +
                    "为防止滥用，同一身份信息可认证的账号数量受腾讯健康系统限制，超出可能导致账号功能受限或封禁。\n" +
                    "\n" +
                    "用户需接受实名信息核验与共享\n" +
                    "腾讯有权将用户实名信息提交至国家防沉迷系统验证，并可能要求额外敏感信息（如人脸识别）进行比对，拒绝提供将限制服务使用。",
            infoC = "强制接受广告与推广信息\n" +
                    "用户需同意接收腾讯发送的商业广告，且无法主动关闭此类信息推送。\n" +
                    "\n" +
                    "免责条款覆盖广泛情形\n" +
                    "腾讯对因不可抗力（如网络故障、病毒攻击）、用户操作不当或第三方原因导致的服务中断免责，用户需自行承担风险。",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))
    }
}

@Composable
fun ResultCard(icon: Painter, name: String, time: String, model: String, infoA:String, infoB:String, infoC:String, modifier: Modifier){
    ElevatedCard(modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    icon,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(48.dp)
                )
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            HorizontalDivider(thickness = 2.dp)
            Text(
                text = "检测时间：$time"
            )
            Text(
                text = "使用模型：$model"
            )
            HorizontalDivider(thickness = 2.dp)
            Text(
                text = "高风险条款",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xfff65656)
            )
            Text(
                text = infoA
            )
            HorizontalDivider(thickness = 2.dp)
            Text(
                text = "中风险条款",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xfffc9826)
            )
            Text(
                text = infoB
            )
            HorizontalDivider(thickness = 2.dp)
            Text(
                text = "低风险条款",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xff4b73eb)

            )
            Text(
                text = infoC
            )
            HorizontalDivider(thickness = 2.dp)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    MyIcon.Error,
                    contentDescription = null,
                    tint = Color(0xffb12727)
                )
                Text(
                    text = "AI生成，仅供参考"
                )
            }
        }
    }
}
