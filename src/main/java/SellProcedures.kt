import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class Sell{
    var checkmark = checkMarck()
    var color = colors()
    var connect = DBConnection()

    var invoiceItems= ArrayList<String>()

    fun createInvoice(invoiceId: Int, customerId: Int){


    }

    fun invoiceItem(invoiceId: Int, product: String, price: Double, cost: Double, qty: Int){

    }

    fun listAllInvoices(){

        var queryListAllInvoices = "select * from invoice left join invoice_item ON invoice_item.invoiceId=invoice.id;"

        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(queryListAllInvoices)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(color.COLOR_YELLOW +" -> (ID): " + rs.getString("id") + " (CustomerId): " + rs.getString("customerId") +
                    " (Date): " + rs.getString("invoiceDate") +
                    " (Item): " + rs.getString("product") + " (Price): " + rs.getString("price") +
                    " (Cost): " + rs.getString("cost") + " (Qty): " + rs.getString("qty") +
                    color.RESET
            )
            println()

        }


        println("")
        println("Press any key to back to menu")

        readLine()

    }
}
//
//fun main(args: Array<String>) {
//    var i = Sell()
//    var exit = false
//    do{
//        println("Add lists")
//        var item = readLine()!!.toString().trim()
//        i.invoiceItems.add(item)
//        println("yes to add more and no to exit  and  list to list items")
//        var more = readLine().toString().trim()
//        if(more.equals("yes")){
//
//        }else if (more.equals("no")){
//            exit = true
//        }else if (more.equals("list")){
//            for (list in i.invoiceItems){
//                println(list)
//            }
//        }
//
//    }while(!exit)
//}