/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        ComposeNavigation()
    }
}

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "puppy_list"
    ) {
        composable("puppy_list") {
            PuppyList(
                puppies = puppyList,
                navController = navController
            )
        }
        composable(
            "puppy_detail/{puppyId}",
            arguments = listOf(navArgument("puppyId") {type = NavType.IntType})
        ) { backStackEntry ->
            PuppyDetail(
                puppyId = backStackEntry.arguments?.getInt("puppyId")
            )
        }
    }
}

@Composable
fun PuppyList(
    puppies: List<Puppy>,
    navController: NavController
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(puppies) { index, puppy ->
            Column(
                modifier = Modifier
                    .clickable {
                        navController.navigate("puppy_detail/$index")
                    }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Image(painter = painterResource(id = puppy.image),
                    contentDescription = R.string.image_content_description.toString(), 
                    contentScale = ContentScale.Crop, 
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp)))
                
                Text(text = puppy.name,
                    style = typography.h6)
                Text(text = puppy.breed,
                    style = typography.body2)
                Text(text = puppy.location,
                    style = typography.body2)
            }
        }
    }
}

@Composable
fun PuppyDetail(
    puppyId: Int?
) {
    val puppy = puppyList[puppyId ?: 0]

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(id = puppy.image),
            contentDescription = R.string.image_content_description.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = puppy.name,
            style = typography.h6,
            fontWeight = FontWeight.Bold)
        
        Row {
            Column {
                Text(text = "Breed",
                    style = typography.body2,
                    fontWeight = FontWeight.Bold)
                Text(text = "Location",
                    style = typography.body2,
                    fontWeight = FontWeight.Bold)
                Text(text = "Sex",
                    style = typography.body2,
                    fontWeight = FontWeight.Bold)
            }
            
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = puppy.breed,
                    style = typography.body2)
                Text(text = puppy.location,
                    style = typography.body2)
                Text(text = puppy.sex,
                    style = typography.body2)
            }
        }

        Text(text = "Description",
            style = typography.body2,
            fontWeight = FontWeight.Bold)

        Text(text = puppy.description,
            style = typography.body2)
    }
}
