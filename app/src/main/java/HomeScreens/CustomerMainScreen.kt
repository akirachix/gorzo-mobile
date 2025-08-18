package HomeScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gorzo.haba.R
import com.gorzo.haba.ui.theme.HabaOrange
import com.gorzo.haba.ui.theme.manrope

@Composable
fun CustomerMainScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                )

                NavigationBar(containerColor = Color.White) {
                    val tabs = listOf("Home", "Cart", "Group", "Orders", "Profile")

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
                                    "Cart" -> Icon(
                                        imageVector = Icons.Default.ShoppingCart,
                                        contentDescription = "Cart",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
                                    "Group" -> Icon(
                                        painter = painterResource(id = R.drawable.outline_groups_24),
                                        contentDescription = "Group",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
                                    "Orders" -> Icon(
                                        painter = painterResource(id = R.drawable.outline_order_approve_24),
                                        contentDescription = "Orders",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
                                    "Profile" -> Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "Profile",
                                        tint = if (isSelected) HabaOrange else Color.Black
                                    )
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
                "Home" -> HomeTab(
                    navController,
                    modifier = Modifier.fillMaxSize(),
                    onTabSelected = { tab -> selectedTab = tab }
                )
                "Cart" -> CartTabPlaceholder(modifier = Modifier.fillMaxSize())
                "Group" -> GroupTabPlaceholder(modifier = Modifier.fillMaxSize())
                "Orders" -> OrdersTabPlaceholder(modifier = Modifier.fillMaxSize())
                "Profile" -> ProfileTabPlaceholder(modifier = Modifier.fillMaxSize())
                else -> HomeTab(
                    navController,
                    modifier = Modifier.fillMaxSize(),
                    onTabSelected = { tab -> selectedTab = tab }
                )
            }
        }
    }
}

@Composable
fun CartTabPlaceholder(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text("Cart — Coming soon")
    }
}

@Composable
fun GroupTabPlaceholder(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text("Group — Coming soon")
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
