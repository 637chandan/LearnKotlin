@file:JvmName("KotlinMain")

import java.math.BigInteger
import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap


fun main(args: Array<String>) {
    println("Chandan! This is intellij ")
    val student = Student()
    student.name = "Chandan"
    println("Student name is ${student.name}")

    val teacher = Teacher()

    teacher.name = "chutiya"

    println("Teacher name is ${teacher.name}")

    //Addition

    val num1: Int = 10
    val num2: Int = 10
    var result = num1 + num2

    println("the result of addition of $num1 and $num2 is $result")

    if (num1 > num2)
        result = num1
    else
        result = num2

    println("the result of bigger  of $num1 and $num2 is $result")

    // If else as expression

    result = if (num1 > num2)
        num1
    else if (num1 < num2)
        num2
    else
        0

    println(if (result == 0) "they are equal" else "Not equal")

    var str1: String = "Chandan"
    var str2: String = "Chandan"

    println(if (str1 == str2) "they are equal" else "Not equal")


    //NUll pointer handling using ?
    // Kotlin does not support null unless ? is used

    var canbeNUll: String? = null

    var tech: Teacher? = null

    println("$canbeNUll and ${tech?.name}")


    // When  as switch

    val x = 5

    when (x) {
        1 -> print("this is one")
        2 -> println("this is two")
        else -> {
            println("this is something other than 1 and 2")
        }
    }
  // When as expression
    var some = when (x) {
        1 -> "this is one"
        2 -> "this is two"
        else -> "this is something other than 1 and 2"
    }

    println(some)

    // Loops
    // using range variable
    var nums = 1..16 // .. increment

    for(a in nums step 2){ // Step 1 is default if we dont mention
        print(" $a")
    }
    val downward = 16 downTo 1 //down to decrement
    println()
    for(a in downward step 2){ // Step 1 is default if we dont mention
        print(" $a")
    }
   println()
    nums = 1 until 16  // last not included
    for(a in nums){ // Step 1 is default if we dont mention
        print(" $a")
    }
    println()
    println(nums.count())

    // List and collections

    var lst = listOf(1,2,3,4)

    for((i,e) in lst.withIndex()){
        print(" $i : $e,")
    }

    var hashMap = HashMap<String,Int>();
    hashMap["chandan"] = 1;
    hashMap["ananya"] = 2;

    for((name,value) in hashMap){
        println("$name and $value")
    }
    println(hashMap.get("chandan"))

    println(add(10,5))
    println(max(10,5))

    println("Total interest ${calIntrest(100)}")
    println("Total interest ${calIntrest(100,10)}")
   // Try catch
    var str: String = "4a"

    var num: Int = 0;

    try {
     num = str.toInt()
    } catch (e : NumberFormatException){
        println("NOt a proper input")
    } finally {
        num++;
    }

    // try as expression

    var num3: Int = try{
        str.toInt()
    } catch (e : NumberFormatException){
        -1
    }
    println(num3)

    // Use of extension method
    val std = Student()
    std.name ="Srivastava"
    var newStudent = student.addName(std)
    println(newStudent.name)

    // same as infix funtion
    newStudent = student add std
    println(newStudent.name)
    //operator overloading
    newStudent = student + std
    println(newStudent.name)

   // println(fact(BigInteger("70000"), BigInteger.ONE))


    // Data class
    val lap1 = LaptopData("HP",2000)
    val lap2 = LaptopData("HP", 2000)
    val lap3 = lap1.copy(price = 2200)
    println(lap1 == lap2)
    println(lap3)
    LaptopStore.laptops.add(lap1)
    LaptopStore.laptops.add(lap2)
    LaptopStore.laptops.add(lap3)

    LaptopStore.showLaptops()
    LaptopData.display()

    // Making annoymous inner class

    val inner: AnnoyInner = object:  AnnoyInner{
        override fun justPrint() {
            println("Under annoy class ")
        }
    }
    inner.justPrint()
}

// Inline functions

fun add(a: Int, b:Int):Int = a+b

fun max(a:Int, b:Int):Int = if(a>b) a else b

// It will create all overloaded method for Java code
@JvmOverloads
fun calIntrest(prin: Int, interest: Int = 5): Int { // using deafult argument .. no need to send argument..
    return ((prin * interest)/100).toInt()
}


//Extension function..
// can add function in class even from other class

fun Student.addName(s1: Student): Student {
   var std = Student()
    std.name = this.name + " "+ s1.name // this here refer to calling objest
    return std
}
// Extension as Infix method
// Infix takes only one parameter
infix fun Student.add(s1: Student): Student {
    var std = Student()
    std.name = this.name + " "+ s1.name // this here refer to calling objest
    return std
}

// Operator overload
operator fun Student.plus(s1: Student): Student {
    var std = Student()
    std.name = this.name + " "+ s1.name // this here refer to calling objest
    return std
}

//recursion using tailrec

tailrec fun fact(num: BigInteger, result: BigInteger): BigInteger{

    if(num == BigInteger.ZERO)
        return result
    else
        return fact(num - BigInteger.ONE, num * result)
}

interface AnnoyInner {

    fun justPrint()
}
