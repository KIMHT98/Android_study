package com.example.ch_13_wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
){
    Scaffold(
        topBar = { AppBarView(title = 
        if(id != 0L) stringResource(id = R.string.update_wish) 
        else stringResource(id = R.string.add_wish)
        ){navController.navigateUp()}}) {
        Column(modifier = Modifier
            .padding(it)
            .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(label= "Title",
                value = viewModel.wishTitleState,
                onValueChanged = {viewModel.onWishTitleChanged(it)})
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(label= "Description",
                value = viewModel.wishDescriptionState,
                onValueChanged = {viewModel.onWishDescriptionState(it)})
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if(viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()){
                    //updat wish
                }else{
                    //add wish
                }
            }) {
                Text(text = if(id != 0L) stringResource(id = R.string.update_wish)
                else stringResource(id = R.string.add_wish),
                    style = TextStyle(fontSize = 18.sp)
                )
            }

        }
    }
}

@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
){
    OutlinedTextField(
        value = value, 
        onValueChange = onValueChanged,
        label={ Text(text = label, color = Color.Black)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Cyan,
            focusedLabelColor = colorResource(id = R.color.green),
            unfocusedLabelColor = colorResource(id = R.color.purple_500),
            cursorColor = colorResource(id = R.color.teal_200),
            focusedBorderColor = colorResource(id = R.color.green),
            unfocusedBorderColor = colorResource(id = R.color.purple_500)
        ))
}

@Composable
@Preview
fun AddEditPreview(){
    WishTextField("text","text",{})
}