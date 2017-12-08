//All Customers menu operation are here.
// name, fullName, cpf, RG, Social Security, Country, City, Address, ZipCode, email, phone


open class addCustumers(firstName: String, lastName: String, cpf:Int, rg:String, socialSecurity:String, country:String,
                   city:String, address:String, zipcode:Int, phone:Int){


    var firstName:String? = null
    var lastName:String? = null
    var cpf:Int? = null
    var rg:String? = null
    var socialSecurity:String? = null
    var city:String? = null
    var address:String? = null
    var zipcode: Int? = null
    var phone: Int? = null

    init {
        this.firstName = firstName
        this.lastName = lastName
        this.cpf = cpf
        this.rg = rg
        this.socialSecurity = socialSecurity
        this.city = city
        this.address = address
        this.zipcode = zipcode
        this.phone = phone



        println("Custumer added")
        addedCustomers()

    }

    fun addedCustomers(){
        println("Added the customer ${firstName}")
    }

}



