package VendorScreens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.gorzo.haba.R
import com.gorzo.haba.ui.theme.HabaOrange
import com.gorzo.haba.ui.theme.manrope

@Composable
fun VendorMainScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                )

                NavigationBar(
                    containerColor = Color.White
                ) {
                    val tabs = listOf("Home", "Orders", "Sales","Profile")

                    tabs.forEach { tab ->
                        val isSelected = selectedTab == tab

                        NavigationBarItem(
                            selected = isSelected,
                            onClick = { selectedTab = tab },
                            icon = {
                                when (tab) {
                                    "Home" -> Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = "Home",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
                                    "Inventory" -> Icon(
                                        painter = painterResource(id = R.drawable.outline_inventory_24),
                                        contentDescription = "Inventory",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )

                                    "Orders" -> Icon(
                                        painter = painterResource(id = R.drawable.outline_order_approve_24),
                                        contentDescription = "Orders",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
                                    "Sales" -> Icon(
                                        painter = painterResource(id = R.drawable.outline_money_bag_24),
                                        contentDescription = "Sales",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
                                    "Profile" -> Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "Profile",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
                                    else -> {}
                                }
                            },
                            label = { Text(text = tab,
                                fontFamily = manrope,
                                fontWeight = FontWeight.Bold) },
                                alwaysShowLabel = true,
                                colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = HabaOrange,
                                selectedTextColor = HabaOrange,
                                unselectedIconColor = Color.Black,
                                unselectedTextColor = Color.Black,
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                "Home" -> VendorHomeScreen(navController, modifier = Modifier.fillMaxSize())
                "Orders" -> OrdersTabPlaceholder(modifier = Modifier.fillMaxSize())
                "Sales" -> SalesTabPlaceholder(modifier = Modifier.fillMaxSize())
                "Profile" -> ProfileTabPlaceholder(modifier = Modifier.fillMaxSize())
                else -> VendorHomeScreen(navController, modifier = Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
fun SalesTabPlaceholder(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text("Sales — Coming soon")
    }
}



@Composable
fun OrdersTabPlaceholder(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text("Orders — Coming soon")
    }
}

@Composable
fun ProfileTabPlaceholder(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text("Profile — Coming soon")
    }
}





