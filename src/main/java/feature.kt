
import java.io.OutputStreamWriter
import java.io.PrintWriter

class colors {


    val COLOR_BLACK = "\u001B[30m"
    val COLOR_RED = "\u001B[31m"
    val COLOR_GREEN = "\u001B[32m"
    val COLOR_YELLOW = "\u001B[33m"
    val COLOR_BLUE = "\u001B[34m"
    val COLOR_PURPLE = "\u001B[35m"
    val COLOR_CYAN = "\u001B[36m"
    val COLOR_WHITE = "\u001B[37m"
    //Reset code
    val RESET = "\u001B[0m"


}
   class checkMarck{
       var markok = "\u001B[1m \u2713  \u001B[1m"
       fun marked(){
           val writer = PrintWriter(OutputStreamWriter(System.out, "UTF-8"), true)
           writer.println("\u001B[1m \u2713  \u001B[1m")
       }
   }




fun main(args: Array<String>) {
    var i = checkMarck()

    i.marked()
}