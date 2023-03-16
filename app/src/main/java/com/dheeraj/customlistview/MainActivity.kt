package com.dheeraj.customlistview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dheeraj.customlistview.ui.theme.CustomListViewTheme


data class Profile(
    val name: String,
    val address: String,
    val emaill: String,
    val imageResource: Int
)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomListViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val profiles = listOf(
                        Profile("Adom Doe", "123 Main St", "adom@hotmail.com", R.drawable.profile),
                        Profile("Chrish Smith", "456 Elm St", "chris@rediffmail.com", R.drawable.profile),
                        Profile("Celeb Johnson", "789 Oak St","caleb@gmail.com", R.drawable.profile),
                        Profile("Johnson", "9 Oak St","johnson@gmail.com", R.drawable.profile),
                        Profile("Martina", "477 Pack Tc","martina@gmail.com", R.drawable.profile),
                        Profile("Roan", "49 Un Tt","ron@gmail.com", R.drawable.profile),
                        Profile("R.B Smith", "78 Yuc Et","smith@gmail.com", R.drawable.profile),

                     )
                    CustomListView(names = profiles)

                }
            }
        }
    }
}

@Composable
fun CustomListView(names: List<Profile>) {
    LazyColumn {
        items(names
        ) { item ->
            CustomListItem(item)
        }
    }
}

@Composable
fun CustomListItem(profile: Profile) {
    // your custom list item UI goes here
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = profile.imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = profile.name)
            Text(text = profile.address)
            Text(text = profile.emaill)
        }

    }
}
