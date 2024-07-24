import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kolaysoft.personsappjetpack.data.model.Person
import com.kolaysoft.personsappjetpack.ui.scene.navigation.AppNavigationEnum
import com.kolaysoft.personsappjetpack.ui.theme.MainColor
import java.util.Locale

@Composable
fun PersonItemWidget(
    person: Person,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Transparent)
            .clickable {
                navController.navigate("${AppNavigationEnum.DETAIL_PAGE.name}/${person.id}")
            },
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(verticalAlignment = Alignment.Top) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MainColor)
                        .width(50.dp)
                        .height(50.dp)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = person.firsName.first().toString().uppercase(Locale.ROOT),
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.White)
                    )

                }
                Spacer(modifier = Modifier.width(30.dp))
                Column {
                    Text(
                        text = "${person.firsName} ${person.lastName}",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = person.phoneNumber)
                }
            }
        }

    }
}
