package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
        @field:NotEmpty(message = "First Name is required") val firstName: String,
        @field:NotEmpty(message = "Last Name is required") val lastName: String,
        @field:NotNull(message = "Invald income") val income: BigDecimal,
        @field:NotEmpty(message = "Zip Code is required") val zipCode: String,
        @field:NotEmpty(message = "Street is required") val street: String
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }

}
