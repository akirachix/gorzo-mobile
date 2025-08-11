package HomeScreens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import com.gorzo.haba.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gorzo.haba.ui.theme.HabaOrange

import com.gorzo.haba.ui.theme.manrope

@Composable
fun SummaryCard(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .border(1.dp, Color.White, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White,
            fontFamily = manrope
        )
        Text(
            text = subtitle,
            fontSize = 14.sp,
            color = Color.White,
            fontFamily = manrope
        )
    }
}

@Composable
fun OneTimeOrderCard(
    orderNumber: String,
    items: List<Pair<String, String>>,
    itemIconResIds: List<Int>,
    amount: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFF8F1), shape = RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Order $orderNumber",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = manrope
            )
            Text(
                "One-time order",
                color = Color(0xFFFF9800),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                fontFamily = manrope
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        items.forEachIndexed { index, (item, quantity) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Image(
                    painter = painterResource(id = itemIconResIds.getOrElse(index) { R.drawable.bananas }),
                    contentDescription = "$item icon",
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "$item: $quantity",
                    fontFamily = manrope,
                    fontSize = 18.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "Total Amount: $amount",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            fontFamily = manrope
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Pending",
            modifier = Modifier.align(Alignment.End),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFF9800),
            fontFamily = manrope
        )
    }
}




@Composable
fun GroupOrderCard(
    orderNumber: String,
    item: String,
    totalQuantity: String,
    minimumRequirement: String,
    participants: Int,
    amount: String,
    itemIconResId: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFF8F1), shape = RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Order $orderNumber",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = manrope
            )
            Text(
                "Group Order",
                color = Color(0xFFFF9800),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                fontFamily = manrope
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = itemIconResId),
                contentDescription = "$item icon",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                item,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = manrope
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            "Total Quantity ordered: $totalQuantity",
            fontFamily = manrope,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            "Minimum Requirement: $minimumRequirement",
            fontFamily = manrope,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            "No. of Participants: $participants",
            fontFamily = manrope,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Total Amount: $amount",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            fontFamily = manrope
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: Navigate to order details */ },
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
        ) {
            Text(
                "View Details",
                color = Color.White,
                fontFamily = manrope,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun VendorHomeScreen(navController: NavController) {
    var currentTab by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            VendorBottomNavBar(selected = currentTab, onSelect = { selectedTab ->
                currentTab = selectedTab
                when (selectedTab) {
                    "Home" -> navController.navigate("vendor_home") {
                        popUpTo("vendor_home") { inclusive = true }
                    }
                    "Orders" -> navController.navigate("vendor_orders") {
                        popUpTo("vendor_orders") { inclusive = true }
                    }
                    "Sales" -> navController.navigate("vendor_sales") {
                        popUpTo("vendor_sales") { inclusive = true }
                    }
                    "Profile" -> navController.navigate("vendor_profile") {
                        popUpTo("vendor_profile") { inclusive = true }
                    }
                }
            })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFF5F5))
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                        .background(
                            color = Color(0xFFFF6F00),
                            shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                            .padding(top = 16.dp),

                        verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.avatar),
                                contentDescription = "Profile Picture",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)

                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                "Karibu Mama Mwangi",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontFamily = manrope,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Profile Icon",
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 70.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            SummaryCard(
                                title = "30",
                                subtitle = "Orders today"
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            SummaryCard(
                                title = "KES 2000",
                                subtitle = "Sales today"
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .offset(y = (-54).dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    OneTimeOrderCard(
                        orderNumber = "#456",
                        items = listOf("Bananas" to "5 pieces", "Oranges" to "3 pieces"),
                        itemIconResIds = listOf(R.drawable.bananas, R.drawable.oranges),
                        amount = "KES. 700"
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    OneTimeOrderCard(
                        orderNumber = "#789",
                        items = listOf("Oranges" to "10 pieces", "Oranges" to "3 pieces"),
                        itemIconResIds = listOf(R.drawable.bananas, R.drawable.oranges),
                        amount = "KES. 1200",
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    GroupOrderCard(
                        orderNumber = "#123",
                        item = "Bananas",
                        totalQuantity = "40 Kgs",
                        minimumRequirement = "20 Kgs",
                        participants = 10,
                        amount = "KES. 7000",
                        itemIconResId = R.drawable.bananas
                    )
                }
            }
        }
    )
}


@Composable
fun VendorBottomNavBar(selected: String, onSelect: (String) -> Unit) {
    val items = listOf("Home", "Inventory", "Orders", "Sales")
    val icons = listOf<BottomNavIcon>(
        BottomNavIcon.VectorIcon(Icons.Filled.Home),
        BottomNavIcon.PainterIcon(painterResource(id = R.drawable.outline_inventory_24)),
        BottomNavIcon.PainterIcon(painterResource(id = R.drawable.outline_order_approve_24)),
        BottomNavIcon.PainterIcon(painterResource(id = R.drawable.outline_money_bag_24))
    )
    NavigationBar(containerColor = Color.White) {
        items.forEachIndexed { index, item ->
            val iconComposable: @Composable () -> Unit = {
                when (val icon = icons[index]) {
                    is BottomNavIcon.VectorIcon -> Icon(imageVector = icon.imageVector, contentDescription = item)
                    is BottomNavIcon.PainterIcon -> Icon(painter = icon.painter, contentDescription = item)
                }
            }
            NavigationBarItem(
                selected = selected == item,
                onClick = { onSelect(item) },
                icon = iconComposable,
                label = { Text(item) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFF6F00),
                    selectedTextColor = Color(0xFFFF6F00),
                    unselectedIconColor = Color.Black,
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color(0xFFFFF3E0)
                )
            )
        }
    }
}







@Preview(showBackground = true)
@Composable
fun PreviewVendorHomeScreen() {
    val navController = rememberNavController()
    VendorHomeScreen(navController = navController)
}


