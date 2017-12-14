/*
Author: Hecton P.Domingos
Description: The Hecton's Enterprise Resource Planning (a.k.a Therp) is a personal project in Kotlin
created by the Author to apply what he learned in the Kotlin programming language. JUST IT.

 */




fun main(args: Array<String>) {
var color = colors()
    var exitProgram = false

    //start a while loop to show the program menu
    do {

        println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
        println()
        println("___Main Menu -> Choose one of the options bellow_____")
        println()
        println("1 - Customers")
        println("2 - Products")
        println("3 - Stock")
        println("4 - Sell")
        println("0 - Exit")
        println()
        println("##################################################################################")
        var mainMenu = readLine()!!.toString().trim()
        if (mainMenu.equals("")) {
            println()
            println("Type the right option...")
        }else{
         var mainMenuOption = mainMenu.toInt()

        when (mainMenuOption) {

        //Option 1
            1 -> {

                var exitOp1 = false
                do {
                    println()
                    println("######### The Hecton's Enterprise Resource Planning Menu ############### ")
                    println()
                    println("___Menu -> Customers _____")
                    println()
                    println("1 - Search - Find a specific costumer")
                    println("2 - Add - Add a new client on the database")
                    println("3 - Modify - Modify the client already in the database")
                    println("4 - List all users from database")
                    println("0 - Exit")
                    println()
                    println("##########################################################################" )
                    var menuCustomer = readLine()!!.toString().trim()
                    if (menuCustomer.equals("")) {
                        println()
                        println("You need to choose one fo the options above.")
                        println()

                    } else {

                        var menuCustomerOption = menuCustomer.toInt()
                        var objCustomer = Customers()
                        when (menuCustomerOption) {


                            1 -> {
                                //Calling a func in CustomersProcedures
                                objCustomer.searchEngine()
                            }

                            2 -> {
                                println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                                println()
                                println("___Menu -> Customers - > Add New Customer_____")
                                println()

                                println()
                                println("Customer's first name: ")
                                var insertFirstName = readLine()!!.toString().trim()
                                println("Customer's last name: ")
                                var insertLastName: String = readLine()!!.toString().trim()
                                println("Which nacionality is the customer?")
                                println("1: Brasilian  | 2: American")
                                var insertNacionality = readLine()!!.toInt()

                                var insertCpf: Int? = 0
                                var insertRegistroGeral = "0"
                                var insertCountry = ""
                                var insertSocialSecurity = ""
                                if (insertNacionality == 1) {
                                    println("Customer's CPF: ")
                                    insertCpf = readLine()!!.toInt()
                                    println("Customer's Registro Geral:")
                                    insertRegistroGeral = readLine()!!.toString().trim()
                                    insertCountry = "Brasil"
                                } else {
                                    insertCountry = "EUA"
                                    insertCpf = 0
                                    println("Insert Social Security number:")
                                    insertSocialSecurity = readLine().toString().trim()
                                }
                                println("Customer's current city: ")
                                var insertCity = readLine()!!.toString().trim()
                                println("Customer's Full Address:")
                                var insertAddress = readLine()!!.toString().trim()
                                println("Customer's Zipcode: ")
                                var insertZipcode = readLine()!!.toInt()
                                println("Customer's phone nunmber: ")
                                var insertPhone: Int = readLine()!!.toInt()
                                println("Customer's Email: ")
                                var insertEmail = readLine()!!.toString().trim()

                                objCustomer.addCustomer(insertFirstName, insertLastName, insertCpf, insertRegistroGeral, insertSocialSecurity, insertCountry, insertCity, insertAddress, insertZipcode, insertPhone, insertEmail)

                            }
                            3 -> {
                                println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                                println()
                                println("___Menu -> Customers -> Modify the Customer Information _____")
                                println()
                                println("Which customer do you want modify the information? ")
                                println("Do you search the user or list all?")
                                println("1 search || 2 list all")
                                var whichCustomer = readLine()!!.toInt()
                                if (whichCustomer == 1) {
                                    println()
                                    println("Search using: 1 name | 2 last name | 3 cpf | 4 social security | 5 phone | 6 email")
                                    var searchBy: Int = readLine()!!.toInt()
                                    if (searchBy == 1) {
                                        println("What is the customer's first name? ")
                                        var searchByName = readLine()!!.toString()
                                        objCustomer.searchCustomerByFirstName(searchByName)
                                        println()
                                    } else if (searchBy == 2) {
                                        println("What is the customer's Last Name? ")
                                        var searchByLName = readLine()!!.toString()
                                        objCustomer.searchCustomerByLastName(searchByLName)
                                        println()

                                    } else if (searchBy == 3) {
                                        println("What is the customer's cpf ")
                                        var searchBycpf = readLine()!!.toInt()
                                        objCustomer.searchCustomerBycpf(searchBycpf)
                                        println()
                                    } else if (searchBy == 4) {
                                        println("What is the customer's Social Security? ")
                                        var searchBySocialSecurity = readLine()!!.toString()
                                        objCustomer.searchCustomerBySocialSecurity(searchBySocialSecurity)
                                        println()

                                    } else if (searchBy == 5) {
                                        println("What is the customer's phone? ")
                                        var searchByphone = readLine()!!.toString().trim().toInt()
                                        objCustomer.searchCustomerByPhone(searchByphone)
                                        println()

                                    } else if (searchBy == 6) {
                                        println("What is the customer's email? ")
                                        var searchByEmail = readLine()!!.toString().trim()
                                        objCustomer.searchCustomerByEmail(searchByEmail)
                                        println()
                                    } else {
                                        println("Wrong option number! Start again!")
                                    }
                                } else if (whichCustomer == 2) {

                                    objCustomer.listCustomers()

                                } else {
                                    println("Wrong option, choose 1 or 2")
                                }

                                println()
                                println("Type the customer's ID to modify the information:  ")
                                var customerID = readLine()!!.toInt()
                                println()
                                println("Which field do you want modify? Type the number ")
                                println()
                                println("1 Name | 2 Last Name | 3 CPF | 4 RG | 5 Social Security | 6 Country | 7 City ")
                                println("8 Address | 9 Zipcode | 10 Phone | 11 Email ")
                                var fieldToModify = readLine()!!.toInt()

                                var field: String = ""

                                if (fieldToModify == 1) {
                                    field = "firstName"
                                } else if (fieldToModify == 2) {
                                    field = "lastName"
                                } else if (fieldToModify == 3) {
                                    field = "cpf"
                                } else if (fieldToModify == 4) {
                                    field = "rg"
                                } else if (fieldToModify == 5) {
                                    field = "socialSecurity"
                                } else if (fieldToModify == 6) {
                                    field = "country"
                                } else if (fieldToModify == 7) {
                                    field = "city"
                                } else if (fieldToModify == 8) {
                                    field = "address"
                                } else if (fieldToModify == 9) {
                                    field = "zipcode"
                                } else if (fieldToModify == 10) {
                                    field = "phone"
                                } else if (fieldToModify == 11) {
                                    field = "email"
                                } else {
                                    println()
                                    println("Wrong field number!")

                                }
                                println()
                                println("Your chose the ${field} field. Which value do you want to put in? ")
                                var fieldValue = readLine()

                                if (field == "cpf" || field == "zipcode" || field == "phone") {

                                    objCustomer.updateCustomerIntFields(field, fieldValue.toString().trim().toInt(), customerID)
                                } else {
                                    objCustomer.updateCustomerStringField(field, fieldValue.toString(), customerID)
                                }


                                println()


                            } //end of 3 ->


                            4 -> {
                                objCustomer.listCustomers()
                            }


                            0 -> {
                                exitOp1 = true

                            }


                        } //End of the when opt1

                    }//else
                } while (!exitOp1)
                //End of the option 1


            } // end of 1 ->

        //Option 2 MAIN Menu Products
            2 -> {
                var productProcedures = product()
                var exitMenuProduct = false
                do {

                    println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                    println()
                    println("___Main Menu -> Products -> Choose one of the options bellow_____")
                    println()
                    println("1 - List all Products")
                    println("2 - Search my Barcode")
                    println("3 - Modify product info")
                    println("4 - Add product")
                    println("0 - Exit")
                    println()
                    println("##################################################################################")
                    println()
                    var menuProduct = readLine()!!.toString().trim()
                    if (menuProduct.equals("")) {
                        println()
                        println("You need to choose one fo the options above.")
                        println()
                    } else {
                        var menuProductOptions = menuProduct.toInt()
                        when (menuProductOptions) {

                            1 -> {
                                println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                                println()
                                println("___Main Menu -> Products -> Listing all products")
                                println()
                                println("List of all products on database: For specific product, choose the option 2.")
                                println()
                                productProcedures.listAllProduct()
                                println()

                            } //end of ->

                            2 -> {
                                println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                                println()
                                println("___Main Menu -> Products -> Search Product By Barcode")

                                println()
                                println("Type the Barcode's product")
                                var searchBarCode = readLine()!!.toString().trim()
                                if (searchBarCode.equals("")) {
                                    println("You need provide the barcode to find the product on database!")
                                    println("Please, go to option 2 and type the barcode!")
                                } else {

                                    productProcedures.searchBarcodeProduct(searchBarCode)
                                }
                                println()

                            } //end of 2 ->

                            3 -> {

                                println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                                println()
                                println("___Main Menu -> Products ->  Modify product info")
                                println()
                                println("Which field do you want modify? Type the number.")
                                println()
                                println("1 - Name | 2 - Model | 3 - Manufacturer | 4 - Country | 5 - Size | 6 Weight | 7 - type")
                                println("8 - barcode | 9 - cost | 10 - Normal Price | 11 - Last Price | 12 - Total Tax")
                                var pField = readLine()!!.toString().trim()
                                if (pField.equals("")) {
                                    println()
                                    println("You need to choose one of the options above")

                                } else {

                                    var productField = pField.toInt()

                                    var fieldProduct: String? = ""
                                    var fieldValueProduct: Any? = ""
                                    println(fieldValueProduct.toString())

                                    if (productField == 1) {
                                        fieldProduct = "name"

                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                        println()
                                        println("Resultado $fieldProduct  e $fieldValueProduct")
                                    } else if (productField == 2) {
                                        fieldProduct = "model"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))

                                    } else if (productField == 3) {
                                        fieldProduct = "manufacturer"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                    } else if (productField == 4) {
                                        fieldProduct = "country"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                    } else if (productField == 5) {
                                        fieldProduct = "size"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))

                                    } else if (productField == 6) {
                                        fieldProduct = "weight"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toInt()

                                        } while (fieldValueProduct!!.equals(""))
                                    } else if (productField == 7) {
                                        fieldProduct = "type"
                                    } else if (productField == 8) {
                                        fieldProduct = "barcode"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                    } else if (productField == 9) {
                                        fieldProduct = "cost"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                    } else if (productField == 10) {
                                        fieldProduct = "normalPrice"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                    } else if (productField == 11) {
                                        fieldProduct = "lastPrice"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                    } else if (productField == 12) {
                                        fieldProduct = "totalTax"
                                        do {
                                            println("Insert the new info about the $fieldProduct")
                                            fieldValueProduct = readLine()!!.toString().trim()

                                        } while (fieldValueProduct!!.equals(""))
                                    }
                                    var productBarcode: String? = ""
                                    do {
                                        println()
                                        println("Type carefully the Barcode of product that you want to change the values")
                                      productBarcode = readLine()!!.toString().trim()
                                    }while (productBarcode.equals(""))

                                productProcedures.modifyProduct(fieldProduct!!.toString(), fieldValueProduct!!, productBarcode!! )
                                } //end of else

                            } //end of 3 ->
                            4 -> {
                                println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                                println()
                                println("___Main Menu -> Products -> Add a new item (product) on database")

                                println()
                                println("Type the name of the new item on database. Ex: ASUS P5148")
                                var addProductName = readLine()!!.toString().trim()
                                println("Type the product's model. Ex: WD0234")
                                var addProductModel = readLine()!!.toString().trim()
                                println("Type the manufacturer. Ex: Samsung")
                                var addProductManufacturer = readLine()!!.toString().trim()
                                println("The country that the product come from. Ex: USA")
                                var addProductCountry = readLine()!!.toString().trim()
                                println("The product's dimensions. Ex: 11x9.5x2.5")
                                var addProductSize = readLine()!!.toString().trim()
                                println("The product's weight")
                                var addProductWeight = readLine()!!.toString().trim().toDouble()
                                println("The product's type")
                                var addProductType = readLine()!!.toString().trim()
                                println("The product's barcode")
                                var addProductBarcode = readLine()!!.toString().trim()
                                println("The product's cost")
                                var addProductCost = readLine()!!.toDouble()
                                println("The product's normal price")
                                var addProductNPrice = readLine()!!.toString().trim().toDouble()
                                println("The product's last price (changed)")
                                var addProductLPrice = readLine()!!.toString().trim().toDouble()
                                println("The product's total tax")
                                var addProductTTax = readLine()!!.toString().trim().toDouble()

                                productProcedures.addProduct(addProductName, addProductModel, addProductManufacturer, addProductCountry, addProductSize, addProductWeight, addProductType,
                                        addProductBarcode, addProductCost, addProductNPrice, addProductLPrice, addProductTTax)


                            }//end of 4 ->

                            0 -> {
                                exitMenuProduct = true

                            }
                        } //end of (menuProductOptions)


                    }
                } while (!exitMenuProduct)



                }//End of PRODUCT Menu


                //Option 3 MAIN Menu  STOCK
                3 -> {
                    var existStockMenu: Boolean = false

                    do{
                        println()
                        println("######### The Hecton's Enterprise Resource Planning Menu ############### ")
                        println()
                        println("___Menu -> Stock_____")
                        println()
                        println("1 - Search barcode and quantity on Stock")
                        println("2 - Update the quantity")
                        println("3 - Add product on Stock")
                        println("0 - Exit")
                        println()
                        println("##########################################################################" )
                        var menuStock = readLine()!!.toString().trim()
                        if (menuStock.equals("")) {
                            println()
                            println("You need to choose one fo the options above.")
                            println()

                        } else {
                            var stockOptions = menuStock.toInt()

                            when(stockOptions){

                                1 -> {
                                   println()
                                   println("Search")
                                   println()
                                }

                                2 -> {
                                    println()
                                    println("Update product on stock")
                                    println()

                                }

                                3 -> {



                                    println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                                    println()
                                    println("___Main Menu -> Stock -> Add a new item (product) on stock")
                                    println()

                                    var addStockBarcode = ""
                                    var stockProcedures = product()
                                    var idProduct: Int?
                                    var productExistsOnStock: Any? = 0
                                    var productExistsOnList: Any? = 0
                                    do {

                                        println("Type the product's code that you want to add at stock")
                                        addStockBarcode = readLine().toString().trim()

                                        //search barcode on product list
                                        productExistsOnList  =  stockProcedures.searchIdProduct(addStockBarcode)

                                        //search the barcode on stock
                                        productExistsOnStock = stockProcedures.searchIdBarcodeStock(addStockBarcode)
                                        if (addStockBarcode == "" || addStockBarcode == null ){
                                            println(color.COLOR_RED + "You need to provide the barcode to add the product on stock" + color.RESET)
                                        }

                                        if (productExistsOnList == 0){
                                            println()
                                            println(color.COLOR_RED + "There is no product on the list of products with this barcode. Backing to main menu and add this product first." + color.RESET)
                                            addStockBarcode = "noFoundonList"
                                        }

                                    }while (addStockBarcode.equals(""))


                                    if (productExistsOnStock != 0 ){
                                        println()
                                        println(color.COLOR_RED + " The product with the barcode that you are trying to add already exists on stock database!" + color.RESET)
                                        println("Try another!")
                                        println()
                                    }else if(addStockBarcode.equals("noFoundonList")){
                                        //back to main menu to add new product
                                        println()
                                    }else{

                                        stockProcedures.searchBarcodeProduct(addStockBarcode)
                                        var qty: String = ""

                                        println("Would you like to stock this product? y(yes) - n(no)")
                                        var addProduct = readLine()!!.toLowerCase().trim()

                                        if (addProduct.equals("y") || addProduct.equals("yes")) {
                                            idProduct = stockProcedures.searchIdProduct(addStockBarcode)!!.toInt()

                                            do {
                                                println("You will add the $addStockBarcode barcode. Type the quantity for this item")
                                                qty = readLine()!!.toString().trim()

                                            } while (qty.equals(""))


                                            var addQty = qty!!.toInt()

                                            println("Quantidade $addQty")

                                            // add barcode and qty on stock
                                            stockProcedures.addProductStock(idProduct, addStockBarcode, addQty)


                                        } else if (addProduct.equals("n") || addProduct.equals("no")) {

                                            //do nothing

                                        } else {
                                            println("Wrong option")
                                        }

                                    }






                                }// enf of Stock option 3

                                0 -> {

                                    existStockMenu = true
                                    println("Bye")
                                }

                            }






                        }






                    }while (!existStockMenu)

                }// end of -> 3



                //Option 4 MAIN Menu
                4 -> {

                }


                //Exit Program
                0 -> {
                    exitProgram = true
                    println("Bye!")
                }
            }


    }


    //End of THERP Program
    }while(!exitProgram)


}