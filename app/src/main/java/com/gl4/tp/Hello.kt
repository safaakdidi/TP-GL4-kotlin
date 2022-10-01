package com.gl4.tp
import kotlin.math.abs
private val languages =listOf("fr", "ang", "ar")
fun main(argv : Array<String> ){
    print("Hello")
    val listOfRectangle = listOf(Rectangle(),
        Rectangle(q=Point(2,2)), Rectangle
            (p= Point(2,5)),Rectangle(p= Point(4,1),q=Point(2,0))
    )

    for(i in listOfRectangle.indices) {
        println(listOfRectangle[i])
    }
    for(i in listOfRectangle.indices) {
        println(listOfRectangle[i].surface())
    }

    var hello = "Hello"
    hello = "Hello world!"

    println(hello)

    var toto:String = "Toto"

    println(toto)

    var message: String? = "I’m learning Kotlin!"
    message = null
    println(message.toString())
    println("Languages :")
    showList(languages)
    println("Odd Numbers to 10 :")
    oddNumbersTo10()



}
fun sayMyName(name:String) { println(" $name ") }

fun sayHello()="Hello"
fun showList(list: List<String>){
    for(el in list){
        print(el)
    }
}
fun oddNumbersTo10(){
    for (i in 0..10){
        if (i %2==1){
            print(i)
        }
    }
}

fun op(a:Int,b:Int,op:Char){
    when(op){
        '+'-> print(a+b)
        '-'->print(a-b)
    }
}
fun distance(p:Point,q:Point): Int {

    return abs(p.x-q.x) + abs(p.y-q.y)
}


