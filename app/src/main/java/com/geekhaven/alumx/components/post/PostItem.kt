package com.geekhaven.alumx.components.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekhaven.alumx.R

@Composable
fun PostItem(
    authorName: String,
    authorDescription: String,
    postText: String,
    likes: Int,
    comments: Int,
    reposts: Int,
    placeName: String,
    imageRes: Int,
    profileRes: Int = R.drawable.ic_launcher_foreground
) {
    val cardBg = Color(0xFF141C2F)
    val textColor = Color.White
    val subTextColor = Color.Gray

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardBg),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Author Info Row
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = profileRes),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = authorName,
                        style = MaterialTheme.typography.titleMedium,
                        color = textColor,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = authorDescription,
                        style = MaterialTheme.typography.bodySmall,
                        color = subTextColor
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "2h ago",
                    style = MaterialTheme.typography.bodySmall,
                    color = subTextColor
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Post Text
            Text(
                text = postText,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Post Image
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = placeName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Likes, Comments, Reposts Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Like", tint = subTextColor)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("$likes", color = subTextColor)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Email, contentDescription = "Comment", tint = subTextColor)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("$comments", color = subTextColor)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Refresh, contentDescription = "Repost", tint = subTextColor)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("$reposts", color = subTextColor)
                }
            }

            Divider(
                modifier = Modifier.padding(vertical = 12.dp),
                color = Color(0xFF2B3240)
            )

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Like", tint = subTextColor)
                Icon(Icons.Default.Email, contentDescription = "Comment", tint = subTextColor)
                Icon(Icons.Default.Refresh, contentDescription = "Repost", tint = subTextColor)
                Icon(Icons.Default.Share, contentDescription = "Share", tint = subTextColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    PostItem(
        authorName = "Harsh",
        authorDescription = "Travel Blogger",
        postText = "Exploring Hội An, Quảng Nam, Vietnam. Beautiful streets, lanterns, and riverside views!",
        likes = 120,
        comments = 32,
        reposts = 14,
        placeName = "Hội An, Vietnam",
        imageRes = R.drawable.hoi_an,
        profileRes = R.drawable.sk_ic
    )
}
