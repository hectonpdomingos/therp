import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet


class product{
    var checkmark = checkMarck()
    var color = colors()
    var connect = DBConnection()




    fun addProduct(name: String, model: String, manufactuter: String, country:String, size:String, weight:Double,
                   type:String, barcode:String, cost:Double, normalPrice:Double,lastPrice:Double, totalTax:Double){
        var queryAddProduct = "INSERT INTO `therp`.`products` (`name`, `model`, `manufacturer`, `country`, `size`, `weight`, `type`, `barcode`, `cost`," +
                "`normalPrice`, `lastPrice`, `totalTax`) VALUES ('"+name+"', '"+model+"', '"+manufactuter+"', '"+country+"', '"+size+"', '"+weight+"', '"+type+"'," +
                "'"+barcode+"', '"+cost+"','"+normalPrice+"', '"+lastPrice+"', '"+totalTax+"');\n"
        try{

            Class.forName(connect.mysqlDriver)
            var conn: Connection = DriverManager.getConnection(connect.pathConnection)
            var ps: PreparedStatement = conn.prepareStatement(queryAddProduct)
            ps.execute()
            println()
            println(" Success! The product $name model $model  was added!")
            println()
        }catch (e: Exception){
            println("Error: " + e.message)
        }


    }

    fun updateProduct(productField: String, productFieldValue: Any, productBarcode: String){

      var queryModifyProduct: String = "UPDATE products set " + productField + "='" + productFieldValue + "' WHERE barcode='" + productBarcode + "'"

        try{

            Class.forName(connect.mysqlDriver)
            var conn: Connection = DriverManager.getConnection(connect.pathConnection)
            var ps: PreparedStatement = conn.prepareStatement(queryModifyProduct)
            ps.execute()
            println()
            println("The SQL query thats sets $productField column the $productFieldValue value was executed")

            println()
        }catch (e: Exception){
            println("Error: " + e.message)
        }
    }

    fun updateStock(barcode: String, newQty: Int){

        var queryModifyProduct: String = "UPDATE stock set qty='" + newQty + "' WHERE barcode='" + barcode + "'"

        try{

            Class.forName(connect.mysqlDriver)
            var conn: Connection = DriverManager.getConnection(connect.pathConnection)
            var ps: PreparedStatement = conn.prepareStatement(queryModifyProduct)
            ps.execute()
            println()
            println(checkmark.markok + "The item $barcode on stock database was updated"  + color.RESET )

            println()
        }catch (e: Exception){
            println("Error: " + e.message)
        }
    }

    fun searchBarcodeProduct(barcode:String){


        var querySearchBarcode: String = "Select * from products where barcode='$barcode'"

        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchBarcode)
        var rs: ResultSet = ps.executeQuery()

           var noFound: String? = ""

            while (rs.next()) {
                //check if there is data on name column
                noFound = rs.getString("name")

                println("$barcode Product review info")
                println(color.COLOR_YELLOW + "-> (ID): " + rs.getString("id") + " (Name): " + rs.getString("name") + " (Model): " + rs.getString("model") +
                        " (N Price): " + rs.getString("normalPrice") + " (L Price): " + rs.getString("lastPrice") + color.RESET)

        }
           //if there is no data
           if (noFound.equals("")){
               println(color.COLOR_RED + "Nothing found on database" + color.RESET)
           }

        ps.close()

    }
    fun searchBarcodeStock(barcode:String){


        var querySearchBarcode: String = "Select id, barcode, qty from stock where barcode='$barcode'"

        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(querySearchBarcode)
        var rs: ResultSet = ps.executeQuery()

        var noFound: String? = ""

        while (rs.next()) {
            //check if there is data on name column
            noFound = rs.getString("barcode")

            println("$barcode has Quantity")
            println(color.COLOR_YELLOW + "-> (ID): " + rs.getString("id") + " (Barcode): " + rs.getString("barcode") + " (Quantity): " + rs.getString("qty") +
                     color.RESET)

        }
        //if there is no data
        if (noFound.equals("")){
            println(color.COLOR_RED + "Nothing found on database" + color.RESET)
        }

        ps.close()

    }

    fun  listAllProduct(){
        var listAllTasks = "SELECT * FROM products"
        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(listAllTasks)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (Name): " + rs.getString("name") +
                    " (Model): " + rs.getString("model") + " (Manufacture): " + rs.getString("manufacturer")+
                    " (Country): " + rs.getString("country") + " (Size): " + rs.getString("size") +
                    " (Weight): " + rs.getString("weight") + " \n" + " (Type): " + rs.getString("type") +
                    " (Barcode): " + rs.getString("barcode") + " (Cost) : " + rs.getString("cost") +
                    " (N Price): " + rs.getString("normalPrice") + " (L Price): " + rs.getString("lastPrice") +
                    " (Total Tax) : " + rs.getString("totalTax")
                        )
            println()

        }


        println("")
        println("Press any key to back to menu")

        readLine()

    }


    fun countItemsStock(table: String): Any{
        var queryCountItems = "SELECT count(id) from $table"

        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(queryCountItems)
        var rs: ResultSet = ps.executeQuery()

        var count = rs.toString()
        return count


    }
    fun searchIdProduct(barcode: String): Int? {
        var searchIdProduct = "SELECT id from products where barcode="+barcode+";"

         var productId: Int? =0
        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(searchIdProduct)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()){
            productId = rs.getInt("id")
        }

        return productId

    }
    fun searchIdBarcodeStock(barcode: String): Any? {
        var searchIdProduct = "SELECT id from stock where barcode="+barcode+";"

        var productId: Any? =0

        Class.forName(connect.mysqlDriver)
        var conn: Connection = DriverManager.getConnection(connect.pathConnection)
        var ps: PreparedStatement = conn.prepareStatement(searchIdProduct)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()){
            productId = rs.getInt("id")
        }

        return productId

    }





    fun addProductStock(id: Int, barcode: String,qty: Int){
        var queryAddProductStock = "INSERT INTO `therp`.`stock` (`id`,`barcode`, `qty`) VALUES ('"+id+"', '"+barcode+"', '"+qty+"');"
        try{

            Class.forName(connect.mysqlDriver)
            var conn: Connection = DriverManager.getConnection(connect.pathConnection)
            var ps: PreparedStatement = conn.prepareStatement(queryAddProductStock)
            ps.execute()
            println()
            println(" Success! The barcode $barcode and the quantity $qty  was added on stock!")
            println()
        }catch (e: Exception){
            println("Error: " + e.message)
        }



    }



}
