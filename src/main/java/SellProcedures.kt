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

    fun searchInvoiceByFullName(firstName: String, lastName: String){
        var querySearchInvoiceByFullName = "SELECT customers.id, customers.firstName, customers.lastName, invoice.id, invoice.customerId, invoice.invoiceDate \n" +
                "from customers left join invoice on customers.id=invoice.customerId WHERE 1=1 AND customers.firstName=\"" +firstName+ "\" AND customers.lastName=\""+lastName+"\""
        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchInvoiceByFullName)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(color.COLOR_YELLOW +" -> (Customer ID): " + rs.getString("customers.id") + " (Name ): " + rs.getString("customers.firstName") +
                    " " + rs.getString("customers.lastName") + " (Invoice ID): " + rs.getString("invoice.id") + " (Date): " + rs.getString("invoice.invoiceDate") +

                    color.RESET
            )
            println()
        }
        println("")
        println("Press any key to back to menu")
        readLine()
    }

    fun searchInvoiceAdvanced(firstName: String, lastName: String, invoiceYear: Int, invoiceMonth:Int, invoiceDay: Int){
        var querySearchInvoiceAdvanced = "SELECT customers.id, customers.firstName, customers.lastName, invoice.id AS \"Invoice\" " + ", invoice.invoiceDate AS \"Date\" ,"  +
                " invoice_item.product, invoice_item.qty from customers JOIN invoice ON customers.id = invoice.customerId JOIN invoice_item" +
                " ON invoice_item.invoiceId = invoice.id WHERE 1=1 AND customers.firstName=\"" +firstName+ "\"  AND customers.lastName=\"" +lastName+ "\" " +
                " AND YEAR(invoice.invoiceDate) = \"" +invoiceYear+ "\" AND MONTH(invoice.invoiceDate) = \"" +invoiceMonth+ "\" " +
                " AND DAY(invoice.invoiceDate) = \"" + invoiceDay + "\" ;"

        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchInvoiceAdvanced)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(color.COLOR_YELLOW +" -> (Customer ID): " + rs.getString("customers.id") + " (Name ): " + rs.getString("customers.firstName") +
                    " " + rs.getString("customers.lastName") + " (Invoice ID): " + rs.getString("Invoice") + " (Date): " + rs.getString("Date") +
                    " (Product): " + rs.getString("product") + " (Qty): "+ rs.getString("qty") +

                    color.RESET
            )
            println()

        }
        println("")
        println("Press any key to back to menu")
        readLine()
    }





    fun searchInvoiceByDate(invoiceYear: Int, invoiceMonth: Int, InvoiceDay: Int){
        var querySearchInvoiceByDate = "SELECT customers.id, customers.firstName, customers.lastName, invoice.id, invoice.customerId, invoice.invoiceDate" +
                " from customers left join invoice on customers.id=invoice.customerId WHERE 1=1 AND" +
                " YEAR(invoice.invoiceDate) = \"" +invoiceYear+ "\" AND MONTH(invoice.invoiceDate) = \"" +invoiceMonth+ "\" " +
                " AND DAY(invoice.invoiceDate) = \"" + InvoiceDay + "\" ;"


        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchInvoiceByDate)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(color.COLOR_YELLOW +" -> (Customer ID): " + rs.getString("customers.id") + " (Name ): " + rs.getString("customers.firstName") +
                    " " + rs.getString("customers.lastName") + " (Invoice ID): " + rs.getString("invoice.id") + " (Date): " + rs.getString("invoice.invoiceDate") +

                    color.RESET
            )
            println()

        }
        println("")
        println("Press any key to back to menu")
        readLine()
    }

    fun searchInvoiceById(id: Int){
        var querySearchInvoiceById = "SELECT customers.id, customers.firstName, customers.lastName, invoice.id AS \"Invoice\" " + ", invoice.invoiceDate AS \"Date\" ,"  +
                " invoice_item.product, invoice_item.qty from customers JOIN invoice ON customers.id = invoice.customerId JOIN invoice_item" +
                " ON invoice_item.invoiceId = invoice.id WHERE 1=1 AND invoice.id = \""+id+"\" " +
                " AND invoice_item.invoiceId = \""+id+"\";"



        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchInvoiceById)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(color.COLOR_YELLOW +" -> (Customer ID): " + rs.getString("customers.id") + " (Name ): " + rs.getString("customers.firstName") +
                    " " + rs.getString("customers.lastName") + " (Invoice ID): " + rs.getString("Invoice") + " (Date): " + rs.getString("Date") +

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