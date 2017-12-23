import com.mysql.cj.core.log.NullLogger
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class Invoice{
    var checkmark = checkMarck()
    var color = colors()
    var connect = DBConnection()
    var customerId: Int? = null
    var product: String? = ""
    var qty: Int? = null
    var invoiceItems= ArrayList<String>()
    var invoiceItemsQty= ArrayList<Int>()

    fun addItemOninvoice(item: String, qty: Int){



    }

    fun listItem(barcode: String){

        var querySearchBarcode: String = "Select id, barcode, qty from stock where barcode='$barcode'"

        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchBarcode)
        var rs: ResultSet = ps.executeQuery()

        while (rs.next()) {
            //check if there is data on name column
            product = rs.getString("name")
            qty = rs.getString("qty").toInt()


            println(color.COLOR_YELLOW + "-> (ID): " + rs.getString("id") + " (Name): " + rs.getString("name") + " (Quantity): " + rs.getString("qty") +
                    color.RESET)

        }
        //if there is no data
        if (product.equals("")){
            println(color.COLOR_RED + "Nothing found on database" + color.RESET)
        }

        ps.close()


    }


    fun searchCustomerByFullName(firstName: String, lastName: String){
        var querySearchCustomerByFullName = "SELECT * FROM customers WHERE firstName='"+firstName+"' AND lastName='"+lastName+"'"
        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchCustomerByFullName)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode") +
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
            )
            println()
        }
        println("")
        println("Press any key to back to menu")
        println("")
        readLine()



    }

    fun logic(){
        if(!product.equals("")){
            println("Would you like to add $product in the current invoice?")
            var addItem = readLine().toString().trim().toLowerCase()
            if (addItem.equals("")){
                println("You need to choose y(Yes)  or n(No)")
            }else if (addItem.equals("n") || addItem.equals("no")){

            }else if (addItem.equals("y") || addItem.equals("yes")){
                invoiceItems.add(product.toString())
                println("Type the quantity ")
                var qtyItem = readLine()!!.toInt()
                if (qtyItem > qty!!){
                    println("There are fewer items on stock than you want to buy.")

                }else{
                    invoiceItemsQty.add(qtyItem)
                }

            }
        }
    }
}