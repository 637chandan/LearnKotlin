

//Constructor keyword cab be user
// class Teacher constructor(var n:String)
//without keyword  Teacher(var n: String)
// to support inheritance, kotlin function and method are final
open class Teacher constructor( n: String?= null){
    var name: String? = n
   // for initialization
    // same as constructor
    init{
        println("Teacher is here...")
    }
    // Secondary constructor
    constructor(name: String, age: Int): this(name){

    }
}

// : extend, implements class and interface compulsory necessary to call primary constructor
class Principal : Teacher(){

}