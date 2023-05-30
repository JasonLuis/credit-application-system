package me.dio.credit.application.system.dto

import jakarta.validation.constraints.*
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
        @field:NotNull(message = "Credit invalid") val creditValue: BigDecimal,
        @field:Future val dayFirstOfInstallment: LocalDate,
        @field:Min(value = 1) @field:Max(value = 48) val numberOfInstallments: Int,
        @field:NotNull(message = "Invalid input") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
            creditValue = this.creditValue,
            dayFirstInstallment = this.dayFirstOfInstallment,
            numberOfInstallments = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
    )
}
