package com.livrokotlin.tdcportoalegre

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Model
data class AppModel(var score:Int)

@Composable
fun App(){

    MaterialTheme {

        Column {

            val model = AppModel(0)
            ScoreText(model)

            val buttonArray = arrayOf(1, 3, 6, 9, 12)

            buttonArray.forEach {

                ButtonScore(value = it, onAction = {
                    model.score += it
                })

            }

        }

    }

}


@Composable
fun ScoreText(model: AppModel){
    Text("${model.score}")
}

@Composable
fun ButtonScore(value: Int, onAction: ()->Unit) {
    Button(text = "$value", onClick = onAction)
}


@Preview
@Composable
fun DefaultPreview() {
    App()
}
