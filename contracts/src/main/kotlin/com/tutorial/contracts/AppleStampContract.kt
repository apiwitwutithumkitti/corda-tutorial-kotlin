package com.tutorial.contracts

import com.tutorial.states.AppleStamp
import com.tutorial.states.BasketOfApples
import net.corda.core.contracts.CommandData
import net.corda.core.contracts.Contract
import net.corda.core.contracts.requireThat
import net.corda.core.transactions.LedgerTransaction

class AppleStampContract : Contract {

    @Throws(IllegalArgumentException::class)
    override fun verify(tx: LedgerTransaction) {

        // Extract the command from transaction.
        val commandData = tx.commands[0].value

        // Verify the transaction according to the intention of the transaction
        when(commandData) {
            is Commands.Issue -> requireThat {
                var output = tx.outputsOfType(AppleStamp::class.java)[0]
                "This transaction should only have one AppleStamp as output".using(tx.outputs.size == 1)
                "The output AppleStamp state should have clear description of the type of redeemable goods"
                    .using(output.stampDesc != "")
                null
            }
            is BasketOfApplesContract.Commands.Redeem -> requireThat {
                // Transaction verification will happen in BasketOfApples Contract
            }
        }
    }

    interface Commands : CommandData {
        class Issue : Commands
    }

    companion object {
        const val ID = "com.tutorial.contracts.AppleStampContract"
    }

}