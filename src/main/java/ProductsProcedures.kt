import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class product{
    var theClassName = DBConnection()



    fun addProduct(name: String, model: String, manufactuter: String, country:String, size:Double, weight:Double,
                   type:String, barcode:String, cost:Double, normalPrice:Double,lastPrice:Double, totalTax:Double){
        var queryAddProduct = "INSERT INTO `therp`.`products` (`name`, `model`, `manufacturer`, `country`, `size`, `weight`, `type`, `barcode`, `cost`," +
                "`normalPrice`, `lastPrice`) VALUES ('"+name+"', '"+model+"', '"+manufactuter+"', '"+country+"', '"+size+"', '"+weight+"', '"+type+"'," +
                "'"+barcode+"', '"+cost+"', '"+lastPrice+"', '"+totalTax+"')"
        try{

            Class.forName(theClassName.theClassName)
            var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
            var ps: PreparedStatement = conn.prepareStatement(queryAddProduct)
            ps.execute()
            println()
            println(" Success! The product $name model $model  was added!")
            println()
        }catch (e: Exception){
            println("Error: " + e.message)
        }


    }

    fun modifyProduct(){

    }

    fun searchBarcodeProduct(barcode:String){
        var querySearchBarcode: String = "Select * from products where barcode='$barcode'"

        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(querySearchBarcode)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {
          println("-> (ID): " + rs.getString("id") + " (Name): " + rs.getString("name") + " (Model): " + rs.getString("model")+
                  " (N Price): " + rs.getString("normalPrice") + " (L Price): " + rs.getString("lastPrice"))
        }


    }

    fun  listAllProduct(){
        var listAllTasks = "SELECT * FROM products"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
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



}

fun main(args: Array<String>) {

}