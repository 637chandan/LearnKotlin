@file:JvmName("KotlinMain")

import java.math.BigInteger
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
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

    for (a in nums step 2) { // Step 1 is default if we dont mention
        print(" $a")
    }
    val downward = 16 downTo 1 //down to decrement
    println()
    for (a in downward step 2) { // Step 1 is default if we dont mention
        print(" $a")
    }
    println()
    nums = 1 until 16  // last not included
    for (a in nums) { // Step 1 is default if we dont mention
        print(" $a")
    }
    println()
    println(nums.count())

    // List and collections

    var lst = listOf(1, 2, 3, 4)

    for ((i, e) in lst.withIndex()) {
        print(" $i : $e,")
    }

    var hashMap = HashMap<String, Int>();
    hashMap["chandan"] = 1;
    hashMap["ananya"] = 2;

    for ((name, value) in hashMap) {
        println("$name and $value")
    }
    println(hashMap.get("chandan"))

    println(add(10, 5))
    println(max(10, 5))

    println("Total interest ${calIntrest(100)}")
    println("Total interest ${calIntrest(100, 10)}")
    // Try catch
    var str: String = "4a"

    var num: Int = 0;

    try {
        num = str.toInt()
    } catch (e: NumberFormatException) {
        println("NOt a proper input")
    } finally {
        num++;
    }

    // try as expression

    var num3: Int = try {
        str.toInt()
    } catch (e: NumberFormatException) {
        -1
    }
    println(num3)

    // Use of extension method
    val std = Student()
    std.name = "Srivastava"
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
    val lap1 = LaptopData("HP", 2000)
    val lap2 = LaptopData("DELL", 3000)
    val lap3 = lap1.copy(price = 2200)
    println(lap1 == lap2)
    println(lap3)
    LaptopStore.laptops.add(lap1)
    LaptopStore.laptops.add(lap2)
    LaptopStore.laptops.add(lap3)

    LaptopStore.showLaptops()
    LaptopData.display()

    // Making annoymous inner class

    val inner: AnnoyInner = object : AnnoyInner {
        override fun justPrint() {
            println("Under annoy class ")
        }
    }
    inner.justPrint()
//Run Higher Order functions RUN, return object of underlying expressions
    //simlar like with 
    println(run {
        if (lap1.price > lap2.price) lap1 else lap2
    }.name)

}

// Inline functions

fun add(a: Int, b: Int): Int = a + b

fun max(a: Int, b: Int): Int = if (a > b) a else b

// It will create all overloaded method for Java code
@JvmOverloads
fun calIntrest(prin: Int, interest: Int = 5): Int { // using deafult argument .. no need to send argument..
    return ((prin * interest) / 100).toInt()
}


//Extension function..
// can add function in class even from other class

fun Student.addName(s1: Student): Student {
    var std = Student()
    std.name = this.name + " " + s1.name // this here refer to calling objest
    return std
}

// Extension as Infix method
// Infix takes only one parameter
infix fun Student.add(s1: Student): Student {
    var std = Student()
    std.name = this.name + " " + s1.name // this here refer to calling objest
    return std
}

// Operator overload
operator fun Student.plus(s1: Student): Student {
    var std = Student()
    std.name = this.name + " " + s1.name // this here refer to calling objest
    return std
}

//recursion using tailrec

tailrec fun fact(num: BigInteger, result: BigInteger): BigInteger {

    if (num == BigInteger.ZERO)
        return result
    else
        return fact(num - BigInteger.ONE, num * result)
}

interface AnnoyInner {

    fun justPrint()
}

//knap sack 0 -1
class Solution {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val len = strs.size
        var d3 = Array<Array<Array<Int>>>(len + 1) {
            Array<Array<Int>>(m + 1) {
                Array<Int>(n + 1) { 0 }
            }
        }
        for (i in 1..len) {
            var count = Array<Int>(2) { 0 }
            for (x in strs[i - 1]) {
                if (x == '0') count[0]++;
                else count[1]++
            }
            for (j in 0..m) {
                for (k in 0..n) {
                    d3[i][j][k] = if (j >= count[0] && k >= count[1]) {
                        Math.max(d3[i - 1][j][k], d3[i - 1][j - count[0]][k - count[1]] + 1)
                    } else {
                        d3[i - 1][j][k]
                    }
                }
                //  println()
            }
            // println()
        }
        return d3[len][m][n];
    }

    // https://leetcode.com/problems/friends-of-appropriate-ages/
    fun numFriendRequests(ages: IntArray): Int {
        var ageMap = Array<Int>(121) { 0 }
        var sumMap = Array<Int>(121) { 0 }
        var res = 0
        for (i in ages) ageMap[i]++

        for (i in 1..120) sumMap[i] = ageMap[i] + sumMap[i - 1]
        for (i in 15..120) {
            if (ageMap[i] == 0) continue
            val count = sumMap[i] - sumMap[i / 2 + 7]
            res = res + count * ageMap[i] - ageMap[i]
        }
        return res
    }
//https://leetcode.com/problems/course-schedule/

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (numCourses == 1 || prerequisites.size == 0) true
        var mat = Array<ArrayList<Int>>(numCourses) { ArrayList<Int>() }


        for (i in 0..prerequisites.size - 1) {
            val course = prerequisites[i][0]
            val pre_course = prerequisites[i][1]
            mat.get(pre_course).add(course)
        }

        var visited = Array<Int>(numCourses) { 0 }

        for (i in 0..mat.size - 1) {
            val res = if (dfs(visited, mat, i)) true else false
            if (res == false) return false
        }
        return true;
    }

    fun dfs(visited: Array<Int>, mat: Array<ArrayList<Int>>, start: Int): Boolean {

        visited[start] = 1
        for (i in 0..mat.get(start).size - 1) {
            val index = mat.get(start).get(i)
            if (visited[index] == 1) return false;
            val rt = dfs(visited, mat, index)
            if (rt == false) return false;
        }
        visited[start] = 0
        return true;
    }

    //https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        if (head == null) return null

        var sum_map = HashMap<Int, ListNode>()

        var sum = 0
        val addhead = ListNode(0)
        var crawl: ListNode? = addhead
        addhead.next = head
        while (crawl != null) {
            sum = sum + crawl.`val`
            sum_map.put(sum,crawl)
            crawl = crawl.next
        }
        sum = 0
        crawl = addhead
        while (crawl != null) {
            sum = sum + crawl.`val`
            crawl.next = sum_map.get(sum)?.next
            crawl = crawl.next
        }
        return addhead.next
    }

    //https://leetcode.com/problems/partition-list/
    fun partition(head: ListNode?, x: Int): ListNode? {
        if(head ==  null) return null
        var que = ArrayDeque<ListNode>()
        var crawl = head;
        var addhead = ListNode(0)
        addhead.next = head
        var last = addhead
        while(crawl != null){
            if(crawl.`val` >= x){
                 last.next = crawl.next
                 crawl.next = null
                 que.add(crawl)
                 crawl = last.next
            } else {
                 last = crawl
                 crawl = crawl.next
            }
        }
        while(!que.isEmpty()){
            val node = que.poll()
            last.next = node
            last = node
        }
        return addhead.next
    }
}


