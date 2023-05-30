package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
        @field:NotEmpty(message = "First Name is required") val firstName: String,
        @field:NotEmpty(message = "Last Name is required") val lastName: String,
        @field:NotEmpty(message = "CPF is required")
        @field:CPF(message = "This invalid CPF") val cpf: String,
        @field:NotNull(message = "Invald income") val income: BigDecimal,
        @field:NotEmpty(message = "E-mail is required")
        @field:Email(message = "This E-mail is invalid\n")
        val email: String,
        @field:NotEmpty(message = "Password is required") val password: String,
        @field:NotEmpty(message = "Zip Code is required") val zipCode: String,
        @field:NotEmpty(message = "Street is required") val street: String
) {

    fun toEntity(): Customer = Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.password,
            address = Address(
                    zipCode = this.zipCode,
                    street = this.street
            )
    )
}
