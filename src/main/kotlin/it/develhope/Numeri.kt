package it.develhope

fun main(){

    val list = Numeri.Interi(listOf(1,2,3,4,3,412,312),"321")
    println(getType(list))
    val filterList = list.list.filter { it>4 }
    println(filterList)
    val stringList = list.transform(list.list)
    println(stringList)
    stringList.forEach{it -> println(it) }


}


sealed class Numeri {

    data class Interi (val list: List<Int>, val id: String, val message: String = "I'm an int") : Numeri()
    data class Virgola (val list: List<Float>, val id: String, val message: String = "I'm a float") : Numeri()

}
fun Numeri.Interi.transform(list: List<Int>): List<String>{
    return list.map { it.toString() }
}
fun Numeri.Virgola.transform(list: List<Float>): List<String>{
    return list.map { it.toString() }
}

fun getType(n:Numeri): String{
    return when (n) {
        is Numeri.Interi -> "Type: Int"
        is Numeri.Virgola -> "Type: Float"
    }
}






/*1) Creare una sealed class chiamata Numeri che avrà come sottoclassi Interi e Float
  2) Entrambe le sottoclassi avranno come parametri del costruttore una lista basata sul tipo della sottoclasse,
   un id di tipo Stringa, un parametro message di tipo Stringa con un valore predefinito
  3) Crea una o più ext fun che accetta in input una lista e la trasforma in una lista di String.
  4) Crea un metodo dove nella signature hai un oggetto "Numeri" e con un when analizzi che tipo di oggetto è facendo
  stampare a video il tipo trovato.
  5) A partire dal punto precedente filtri la lista degli oggetti di tipo "Numeri" secondo un parametro di tua scelta
  6) Partendo dal punto 4 utilizzi la ext fun corretta per trasformare la lista risultante nella lista di String e
  stampare ogni singolo elemento.*/