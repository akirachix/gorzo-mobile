package HomeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.gorzo.haba.R
import com.gorzo.haba.ui.theme.HabaOrange
import com.gorzo.haba.ui.theme.manrope
import androidx.navigation.NavController



@Composable
fun TopBar(){
    Row  (
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically


    ){
        Image(
            painter = painterResource(id = R.drawable.logohaba),
            "Haba Logo",
            modifier = Modifier.height(40.dp)
        )


        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notification Bell",
            tint = Color.Black
        )
    }


}


@Composable
fun PromoBanner(onGroupClick:()-> Unit){


    Card (
        colors = CardDefaults.cardColors(
            containerColor = HabaOrange
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    )
    {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Want Lower Prices?",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = manrope,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
        Text(
            text = "Discover Live Group Happening Now. \n Save More When You Buy Together",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = manrope,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()




        )
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            onClick = onGroupClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .padding(end = 10.dp, bottom = 8.dp, top = 8.dp)
        ) {
            Text(
                text = "Join Group Buy",
                color = HabaOrange,
                fontWeight = FontWeight.Bold
            )
        }




    }
}


@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }
    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        placeholder = {
            Text(
                text = "Search...",
                fontSize = 14.sp,
                color = Color.Gray
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color(0xFFFF9800),
                modifier = Modifier.size(20.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFFF9800),
            unfocusedBorderColor = Color(0xFFFF9800),
            cursorColor = Color(0xFFFF9800),
            focusedLeadingIconColor = Color(0xFFFF9800),
            unfocusedLeadingIconColor = Color(0xFFFF9800),
            focusedContainerColor = Color(0xFFFFF3E0),
            unfocusedContainerColor = Color(0xFFFFF3E0)
        )
    )
}


data class Product(
    val name: String,
    val price: String,
    val imageRes: Int,
    val vendors: List <Int>
)





data class VendorInfo(
    val id: String,
    val name: String,
    val distance: String,
    val imageRes: Int
)

@Composable
fun ProductCard(
    productName: String,
    productPrice: String,
    productImageRes: Int,
    vendors: List<VendorInfo>,
    onVendorClick: (VendorInfo) -> Unit = {}
) {
    var selectedVendor by remember { mutableStateOf<VendorInfo?>(null) }

    Column(
        modifier = Modifier.width(130.dp),

        verticalArrangement = spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = productImageRes),
                    contentDescription = productName,
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = productName,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color(0xFFFF9800),
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .background(Color(0xFFF5F5F5), CircleShape)
                            .padding(4.dp)
                            .size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = productPrice,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }

        Row(modifier = Modifier.padding(top = 4.dp)) {
            val displayed = vendors.take(4)
            displayed.forEachIndexed { index, vendor ->
                Box(
                    modifier = Modifier
                        .offset(x = (-(index * 12).dp))
                        .size(28.dp)
                        .clickable { selectedVendor = vendor }
                        .zIndex((4 - index).toFloat())
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(2.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = vendor.imageRes),
                            contentDescription = vendor.name,
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            if (vendors.size > 4) {
                val remaining = vendors.size - 4
                Box(
                    modifier = Modifier
                        .offset(x = (-(4 * 12).dp))
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "+$remaining",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(((displayed.size + if (vendors.size > 4) 1 else 0) * 12).dp)
            )
        }
    }

    if (selectedVendor != null) {
        val vendor = selectedVendor!!
        AlertDialog(
            onDismissRequest = { selectedVendor = null },
            title = { Text(text = vendor.name, fontWeight = FontWeight.Bold) },
            text = { Text(text = vendor.distance) },
            confirmButton = {
                Button(
                    onClick = {
                        onVendorClick(vendor)
                        selectedVendor = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = HabaOrange)
                ) {
                    Text("View Vendor")
                }
            },
            dismissButton = {
                Button(
                    onClick = { selectedVendor = null },
                    colors = ButtonDefaults.buttonColors(containerColor = HabaOrange.copy(alpha = 0.5f))
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}





data class DisplayProduct(
    val name: String,
    val price: String,
    val imageRes: Int,
    val vendors: List<VendorInfo>
)

@Composable
fun ProductSection(title: String, products: List<DisplayProduct>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = manrope)
        Spacer(modifier = Modifier.height(2.dp))
        LazyRow(
            contentPadding = PaddingValues(2.dp),
            horizontalArrangement = spacedBy(12.dp)
        ) {
            items(products) { product ->
                ProductCard(
                    productName = product.name,
                    productPrice = product.price,
                    productImageRes = product.imageRes,
                    vendors = product.vendors,
                    onVendorClick = { vendor ->
                        // handle vendor click
                    }
                )
            }
        }
    }
}






@Composable
fun HomeTab(navController: NavController, modifier: Modifier = Modifier,onTabSelected:(String)-> Unit) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        TopBar()
        PromoBanner({onTabSelected("Group")})
        SearchBar()

        val vendorsSpinach = listOf(
            VendorInfo("v1", "Mama John", "100 meters away", R.drawable.avatar),
            VendorInfo("v2", "Patricia Ann", "150 meters away", R.drawable.mamajimmy),
            VendorInfo("v3", "Patricia Ann", "150 meters away", R.drawable.mamajimmy),
            VendorInfo("v4", "Mama John", "100 meters away", R.drawable.avatar),
        )
        val vendorsParsley = listOf(
            VendorInfo("v5", "Auntie Rose", "120 meters away", R.drawable.avatar),
            VendorInfo("v6", "Baba Sam", "350 m away", R.drawable.avatar),
            VendorInfo("v7", "Auntie Rose", "120 meters away", R.drawable.avatar),
            VendorInfo("v8", "Auntie Rose", "120 meters away", R.drawable.avatar),
        )

        ProductSection(
            "Vegetables",
            listOf(
                DisplayProduct("Spinach", "KES 20/ Piece", R.drawable.spinach, vendorsSpinach),
                DisplayProduct("Parsley", "KES 10 / Piece", R.drawable.parsley, vendorsParsley),
                DisplayProduct("Kales", "KES 10 / bunch", R.drawable.kales, vendorsParsley),
                DisplayProduct("Cabbages", "KES 50 / bunch", R.drawable.cabbages, vendorsParsley)
            )
        )

        ProductSection(
            "Fruits",
            listOf(
                DisplayProduct("Kiwi", "KES 70/ Piece", R.drawable.kiwi, vendorsSpinach),
                DisplayProduct("Oranges", "KES 10 / Piece", R.drawable.oranges, vendorsSpinach),
                DisplayProduct("Bananas", "KES 10 / Piece", R.drawable.bananas, vendorsSpinach),
                DisplayProduct("Sugarcane", "KES 15 / bunch", R.drawable.sugarcane, vendorsSpinach)
            )
        )

        ProductSection(
            "Grains",
            listOf(
                DisplayProduct("Groundnuts", "KES 70/ Kg", R.drawable.groundnuts, vendorsSpinach),
                DisplayProduct("Ndengu", "KES 80 / Kg", R.drawable.ndengu, vendorsSpinach),
                DisplayProduct("Cinnamon Sticks", "KES 10 / Piece", R.drawable.cinammon, vendorsSpinach),
                DisplayProduct("Sugarcane", "KES 15 / bunch", R.drawable.sugarcane, vendorsSpinach)
            )
        )

        Spacer(modifier = Modifier.height(14.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeTab() {
}
