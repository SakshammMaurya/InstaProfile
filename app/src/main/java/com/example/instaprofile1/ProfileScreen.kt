package com.example.instaprofile1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instaprofile1.R.drawable.threads
import com.example.instaprofile1.ui.theme.ImageWithTexts

@Composable
fun Profile() {
    var selecTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .background(Color(0xFF1A1A1A))
            .fillMaxSize()
    ) {
        topBar()
        mediumBar()
        Description()
        Spacer(modifier = Modifier.height(15.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithTexts(image= painterResource(id =R.drawable.music),
                    text="music"),
                ImageWithTexts(image= painterResource(id =R.drawable.hum),
                    text="Hum"),
                ImageWithTexts(image= painterResource(id =R.drawable.culfest),
                    text="CULFEST '24'"),
                ImageWithTexts(image= painterResource(id =R.drawable.darjeeling),
                    text="darjeeling"),
                ImageWithTexts(image= painterResource(id =R.drawable.sikkim),
                    text="sikkim"),
                ImageWithTexts(image= painterResource(id = R.drawable.add),
                    text="New"),

            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView2(
            imageWithTexts = listOf(
                ImageWithTexts(
                    image= painterResource(id = R.drawable.grid),
                    text="Posts"
                ),
                ImageWithTexts(
                    image=painterResource(id = R.drawable.reel),
                    text="Posts"
                ),
                ImageWithTexts(
                    image= painterResource(id = R.drawable.tag),
                    text="Posts"
                )

            )

        ){
          selecTabIndex =it
        }
        when(selecTabIndex){
            0-> PostSection(posts = listOf(
                painterResource(id = R.drawable.profilepic),
                painterResource(id = R.drawable.darjeeling),
                painterResource(id = R.drawable.culfest),
                painterResource(id = R.drawable.hum),
                painterResource(id = R.drawable.music),
                painterResource(id = R.drawable.profilepic),
                painterResource(id = R.drawable.sikkim),
            )
            ,
                modifier= Modifier.fillMaxWidth())
        }
    }


}


@Composable
fun topBar(
    profileId: String = "_saksham._m",
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Text(
            text = profileId.toString(),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "down Arrow",
            modifier = Modifier
                .padding(8.dp)
                .size(18.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(110.dp))
//
//    Icon(imageVector =MaterialTheme.shapes.medium(CircleShape),
//        contentDescription ="down Arrow",
//        modifier= Modifier
//            .padding(8.dp)
//            .size(30.dp),
//        tint= Color.White
//    )
        Icon(
            painter = painterResource(id = threads),
            contentDescription = "down Arrow",
            modifier = Modifier
                .padding(8.dp)
                .size(30.dp),
            tint = Color.White
        )


        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Create",
            modifier = Modifier

                .size(30.dp),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "activity",
            modifier = Modifier
                .width(50.dp)
                .height(34.dp),
            tint = Color.White
        )
    }

}


@Composable
fun mediumBar(
    modifier: Modifier = Modifier,
    posts: Int = 43,
    followers: Int = 370,
    folllowing: Int = 416

) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        RoundImage(image = painterResource(id = R.drawable.profilepic),
            modifier= Modifier.size(80.dp))

        Spacer(modifier = Modifier.width(20.dp))

        Column(

            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = posts.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(start = 5.dp)


            )
            Text(
                text = "posts",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,

                )
        }

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = followers.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(start = 11.dp)

            )
            Text(
                text = "followers",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,

                )
        }

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = folllowing.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(start = 11.dp)

            )
            Text(
                text = "following",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,

                )
        }
    }
}


@Composable
fun Description(
    modifier: Modifier = Modifier,
    name: String = " SAKSHAM MAURYA",
    location: String = "Jamshedpur",
    profileId: String = "_saksham._m"
) {
    Box(
        modifier = modifier
            .padding(start = 13.dp, end = 13.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = name.toString(),
                color = Color.White,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
//                modifier = modifier.padding(start = 11.dp)

            )

            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(25.dp)
                    .padding(start = 20.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFF2E2E2E)),

                ) {
                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 4.dp, start = 6.dp)
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = threads),
                        contentDescription = "down Arrow",
                        modifier = Modifier.size(14.dp),
                        tint = Color.White,
                    )
                    Text(
                        text = profileId.toString(),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontSize = 11.sp,

                        )
                }
            }

            Text(
                text = "Musician/band",
                color = Color(0xFFFFFFFF),
                modifier = Modifier.padding(start = 5.dp)
            )
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "location",
                    modifier = Modifier.size(15.dp),

                    )
                Text(
                    text = location.toString(),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
            Text(
                text = "Musician, Photographer 📷| Guitarist 🎸",
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "NIT JSR EE'26",
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(top = 5.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(Color(0xFF2E2E2E)),

                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(top = 4.dp, start = 6.dp)
                        .fillMaxWidth()
                ) {

                    Text(
                        text = "Professional dashboard",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 3.dp, top = 3.dp)
                    )

                    Text(
                        text = "612 accounts reached in the last 30 days",
                        color = Color(0xFF8B8B8B),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(start = 3.dp)

                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 9.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(35.dp)
                        .clip(RoundedCornerShape(7.dp))
                        .background(Color(0xFF2E2E2E)),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(
                        text = "Edit Profile",
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                    )
                }
                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(35.dp)
                        .clip(RoundedCornerShape(7.dp))
                        .background(Color(0xFF2E2E2E)),
                    contentAlignment = androidx.compose.ui.Alignment.Center

                ) {
                    Text(
                        text = "Share Profile",
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                    )
                }
            }


        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithTexts>
) {
    LazyRow(modifier = modifier.padding(start=15.dp)) {
        items(highlights.size) {
            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment =  androidx.compose.ui.Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 20.dp)
            ) {
                RoundImage(image = highlights[it].image,
                    modifier= Modifier.size(70.dp))
                Text(text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier=Modifier.padding(start=0.dp))

            }

        }

    }

}


@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    androidx.compose.foundation.Image(
        painter =image,
        contentDescription =null,
        contentScale = ContentScale.Crop,
        modifier= modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .clip(CircleShape)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(0.dp)

    )

}


@Composable
fun PostTabView(
    modifier:Modifier=Modifier,
    isSelected:Boolean,
){
    var isSelected by remember {
        mutableStateOf(false)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        modifier=modifier.fillMaxWidth()
    ){
      Box(contentAlignment = androidx.compose.ui.Alignment.Center,
          modifier= Modifier
              .height(50.dp)
              .width(130.dp)
              .clickable {
                  isSelected = true
              }){
          Column(
              horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center,
              modifier= Modifier.fillMaxSize()
          ) {
            Icon(painter = painterResource(id = R.drawable.threads),
                contentDescription =null,
                tint= Color.White,
                modifier= Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    )
              Box(modifier= Modifier
                  .background(if (isSelected) Color.White else Color.DarkGray)
                  .height(2.dp))
          }
      }
        Box(contentAlignment = androidx.compose.ui.Alignment.Center,
            modifier= Modifier
                .height(50.dp)
                .width(130.dp)
                .clickable {
                    isSelected = true
                }){
            Column(
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier= Modifier.fillMaxSize()
            ) {
                Icon(painter = painterResource(id = R.drawable.threads),
                    contentDescription =null,
                    tint= Color.White,
                    modifier= Modifier
                        .fillMaxSize()
                        .padding(10.dp))
                Box(modifier= Modifier
                    .background(Color.White)
                    .height(5.dp)){

                }
            }
        }

        Box(contentAlignment = androidx.compose.ui.Alignment.Center,
            modifier= Modifier
                .height(50.dp)
                .width(130.dp)
                .clickable {
                    isSelected = true
                }){
            Column(
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier= Modifier.fillMaxSize()
            ) {
               Icon(painter = painterResource(id = R.drawable.threads),
                    contentDescription =null,
                   tint= Color.White,
                    modifier= Modifier
                        .fillMaxSize()
                        .padding(10.dp))
                Box(modifier= Modifier
                    .background(if (isSelected) Color.White else Color.DarkGray)
                    .height(2.dp))
            }
        }
    }

}

@Composable
fun PostTabView2(
    modifier: Modifier= Modifier,
    imageWithTexts:List<ImageWithTexts>,
    onTabSelected:(selectedTabIndex: Int)->Unit

){
    var selectedTabIndex by remember{
        mutableStateOf(0)
    }
    val inactiveColor= Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor= Color.White,
        modifier= modifier) {
        imageWithTexts.forEachIndexed { index, item ->

            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.White,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex=index
                    onTabSelected(index)
                }) {
                Icon(painter = item.image ,
                    contentDescription = null,
                    tint = if(selectedTabIndex==index) Color.White else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(25.dp))

            }
        }
    }
}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier=Modifier
){

    LazyVerticalGrid(
        columns =GridCells.Fixed(3),
        modifier= modifier.scale(1.01f)){
        items(posts.size){
            Image(painter = posts[it], contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier= Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    ))
        }
    }
}