import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet


class Invoice{
    var list = ArrayList<Int>()
       class InvoiceItens(item: Int){

        var item: Int?
        init {
            this.item = item
            Invoice().list.add(item)
        }

        fun showItens(){
            for (i in 0..Invoice().list.size){
                println(i)
            }
        }


    }


}



fun selectItens(){
    var InvoiceItens = Invoice().list
    var exitSelectItens = false
    var Product = product()
    var barcode: String?

   do {

       println("Type the product's barcode or done to exit")
       barcode = readLine().toString().trim()

       if (barcode.equals("")) {
           println("To add the item on Invoice you need type the product's barcode")

       } else if(barcode.equals("done")){
        exitSelectItens = true
       }else {
           //Searching and getting barcode id
           var productId = Product.searchBarcodeProduct(barcode)
           if (productId == 0) {

           } else {

               var exitAddItem = false
               do {
                   println("Would you like to add to the invoice this product ID? ${productId}")
                   println("y(yes) | n(no)  | hit enter or type done to exit and advance")
                   println()
                   var addItem = readLine().toString().trim().toLowerCase()
                   if (addItem.equals("y") || addItem.equals("yes")) {
                       //adding the id to array

                       exitAddItem = true
                   } else if (addItem.equals("n") || addItem.equals("no")) {

                   } else if (addItem.equals("") || addItem.equals("done")) {
                       exitAddItem = true
                   }
               } while (!exitAddItem)

           }
       }


       println("Itens added on invoice")

   }while (!exitSelectItens)
} //end of selectItens




fun invoiceCustomer(){
    var color = colors()
    var Customers = Customers()



    var exitCreateInvoice = false

    do {
        println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
        println()
        println("___Main Menu -> Sell -> Create Invoices.")
        println("")
        println("Search the customer by: 1 - ID | 2 - Full Name | 3 - SS or CPF | 4 - Email | 5 - Phone  | 0 - exit")
        println()
        var customerInvoice = readLine().toString().trim()

        if (customerInvoice.equals("")){
            println(color.COLOR_RED +"You need to input a valid Option" + color.RESET)
        }else{

            when(customerInvoice.toInt()) {

                1 -> { //Search by ID

                    println("What is the customer's ID:")
                    var customerId = readLine().toString().trim()

                    if (customerId.equals("")) {
                        println(color.COLOR_RED + "You need to input a valid ID" + color.RESET)
                    } else {

                        Customers.searchCustomerById(customerId.toInt())

                    }

                }

                2 -> { // search by Full name
                    var exitSearchCustomerFullName = false
                    do {

                        println("Provide the first customer's name")
                        var customerFName = readLine().toString().trim()


                        if (customerFName.equals("")) {
                            println("You need to provide the first customer's name")
                        } else {
                            println("Provide the last customer's name")
                            var customerLName = readLine().toString().trim()
                            if (customerLName.equals("")) {
                                println("Provide the last customer's name")
                            } else {
                                Customers.searchCustomerByFullName(customerFName, customerLName)
                            }

                        }
                        println("Provide the customer's information or type exit ")
                        var exit = readLine().toString().trim()
                        if (exit.equals("")){

                        }else{
                            exitSearchCustomerFullName = true
                        }
                    }while (!exitSearchCustomerFullName)

                }

                3 -> { //search by SS or CPF
                    var exitSearchCustomersBySSCPF = false
                    var custumerSSorCPF: String?
                    do {
                        println("Type 1 to USA Customers | 2 for Brazilians | 0 to Exit")
                        var customerCountry = readLine().toString().trim()
                        if (customerCountry.equals("")){
                            println(color.COLOR_RED +"You need to provide one the options above" + color.RESET)

                        }else{
                            if (customerCountry.toInt() == 1){
                                println("Provide the customer's Security number ")
                                custumerSSorCPF = readLine().toString().trim()
                                if(custumerSSorCPF.equals("")){
                                    println("Provide the customer's Security number ")

                                }else{
                                    Customers.searchCustomerBySocialSecurity(custumerSSorCPF)
                                }
                            }else if (customerCountry.toInt() == 2){
                                println("Provide the customer's CPF ")
                                custumerSSorCPF = readLine().toString().trim()
                                if(custumerSSorCPF.equals("")){
                                    println(color.COLOR_RED + "Provide the customer's CPF " + color.RESET)

                                }else{
                                    Customers.searchCustomerBycpf(custumerSSorCPF.toInt())
                                }


                            }else if (customerCountry.toInt() == 0){

                                exitSearchCustomersBySSCPF = true


                            }else{
                                println(color.COLOR_RED + "You need to provide one the options above" + color.RESET)
                            }
                        }





                    }while (!exitSearchCustomersBySSCPF)


                }

                4 -> { // search by Email
                    var exitSearchCustumerByEmail = false
                    var email: String?

                    do{
                        println("Provide the customer's email")
                        email = readLine().toString().trim().toLowerCase()
                        if (email.equals("")){
                            println(color.COLOR_RED + "You need to provide the customer's email" + color.RESET)
                        }else{
                            Customers.searchCustomerByEmail(email)
                        }


                        println("Type the custumer's ID or done (or just hit enter) to exit")
                        var customerId = readLine().toString().trim().toLowerCase()
                        if(customerId.equals("") || customerId.equals("done")){
                            exitSearchCustumerByEmail = true
                        }else{
                            /*

                            Save the id in one var
                             */
                        }
                    }while (!exitSearchCustumerByEmail)




                }

                5 -> { //search by phone
                    var exitSearchCustumerByPhone = false
                    do {
                        println("Provide the customer's phone number.")
                        var phoneNumber = readLine().toString().trim()
                        if (phoneNumber.equals("")){
                            println( color.COLOR_RED + "You need to provide the customer's phone number." + color.RESET)
                        }else{
                            Customers.searchCustomerByPhone(phoneNumber.toInt())
                        }

                        println("Type the custumer's ID or done (or just hit enter) to exit")
                        var customerId = readLine().toString().trim().toLowerCase()
                        if(customerId.equals("") || customerId.equals("done")){
                            exitSearchCustumerByPhone = true
                        }else{
                            /*

                            Save the id in one var
                             */
                        }
                    }while (!exitSearchCustumerByPhone)

                }

                0 ->{
                    exitCreateInvoice = true
                }

            }
        }


    }while (!exitCreateInvoice)





}

fun main(args: Array<String>){
   
}