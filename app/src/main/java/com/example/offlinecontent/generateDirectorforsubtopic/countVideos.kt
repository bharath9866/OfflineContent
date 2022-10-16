package com.example.jetpackdemo.generateDirectorforsubtopic

/*
@OptIn(ExperimentalAnimationApi::class) // AnimatedVisibility

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, heightDp = 300)
@Composable
fun MessageList() {
    Box(contentAlignment = Alignment.Center) {
        val listState = rememberLazyListState()

        LazyColumn(state = listState) {
            items(10) {
                Row(
                    modifier = Modifier.size(200.dp).border(width = 3.dp,color = Color.Yellow, shape = RoundedCornerShape(0.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("1")
                }
            }
        }

        val showButton by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }

        AnimatedVisibility(visible = showButton) {
            Text(text = "showButton", textAlign = TextAlign.Center)
        }
    }
}

fun main(){
    var list = arrayListOf(1, 2, 3, 4, 4, 3, 2, 1)
    var hasDuplicateList = if(hasDuplicates(list))  println(list.distinct()) else  false
    println(hasDuplicateList)
}

fun <T> Iterable<T>.distinct(): List<T> {
    return this.toMutableSet().toList()
}
*/