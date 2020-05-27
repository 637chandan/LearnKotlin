import java.util.*

// this is data class
// it automatically override
// hashCode, copy, toString methods


data class LaptopData(val name: String, val price: Int) {
    // Companion object
    // act as static method
    // USed in factory pattern
    companion object {
        // Annotation for linking static nmethod to java files
        @JvmStatic
        fun display() {
            println(" this is data demo class")
        }
    }
}
// Object keywords makes this class singlon
// Now this class will act as Object .. no need for creating object

object LaptopStore{

    var laptops  = arrayListOf<LaptopData>()

    fun showLaptops(){
        for(i in laptops){
            println(i)
        }
    }
}
