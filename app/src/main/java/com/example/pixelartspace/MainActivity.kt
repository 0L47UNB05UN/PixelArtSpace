package com.example.pixelartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pixelartspace.ui.theme.PixelArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PixelArtSpaceTheme {
                Surface{
                    PixelArtSpaceApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun PixelArtSpaceApp(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .background(colorResource(R.color.purple_200))
            .verticalScroll(rememberScrollState())
    ){
        var page by remember{mutableIntStateOf(1)}
        val img = when(page){
            1 -> R.drawable.artwork_by_genuine_human_art
            2 -> R.drawable.distorted_by_waneella
            3 -> R.drawable.skesis_castle_by_rachels_ham__
            4 -> R.drawable.this_one_still_works_by_waneella
            5 -> R.drawable.undertone_by_waneella
            else -> R.drawable.yeti_house_by_genuine_human_art
        }
        val artist = when(page){
            1 -> R.string.genuine
            2 -> R.string.waneella
            3 -> R.string.rachels
            4 -> R.string.waneella
            5 -> R.string.waneella
            else -> R.string.genuine
        }
        val artName = when(page){
            1 -> R.string.love
            2 -> R.string.distorted
            3 -> R.string.skesis
            4 -> R.string.still
            5 -> R.string.tone
            else -> R.string.yeti
        }
        PixelArtSpace(
            img, artist, artName
        )
        NavigationButtons(
            pBonClick = {page--
                        if (page < 1){
                            page = 1
                        }
                        },
            nBonClick = {page++
                        if (page > 6){
                            page = 6
                        }
                        },
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PixelArtSpace(
    @DrawableRes img: Int, @StringRes artist: Int,
    @StringRes artName: Int, modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(img),
            contentDescription = stringResource(artName),
            modifier = modifier.padding(25.dp)
        )
        Text(
            text = stringResource(artName)
        )
        Text(
            text = stringResource(artist)
        )
    }
}

@Composable
fun NavigationButtons(
    pBonClick: () -> Unit, nBonClick: () -> Unit,
    modifier : Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ){
        Button(pBonClick){
            Text(
                text = stringResource(R.string.prev)
            )
        }
        Button(nBonClick){
            Text(
                text = stringResource(R.string.next),
            )
        }
    }
}











