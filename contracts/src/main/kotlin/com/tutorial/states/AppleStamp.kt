package com.tutorial.states

import com.tutorial.contracts.AppleStampContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party
import net.corda.core.serialization.ConstructorForDeserialization

@BelongsToContract(AppleStampContract::class)
class AppleStamp @ConstructorForDeserialization constructor(
    val stampDesc : String, // For example: "One stamp can exchange for a basket of HoneyCrispy Apple"
    val issuer : Party, // The person who issued the stamp
    val holder : Party, // The person who currently owns the stamp
    override val linearId : UniqueIdentifier, // LinearState required variable
    override val participants : List<AbstractParty> = listOf<AbstractParty>(issuer, holder)
) : LinearState


//package com.tutorial.states;
//
//import com.tutorial.contracts.AppleStampContract;
//import net.corda.core.contracts.BelongsToContract;
//import net.corda.core.contracts.LinearState;
//import net.corda.core.contracts.UniqueIdentifier;
//import net.corda.core.identity.AbstractParty;
//import net.corda.core.identity.Party;
//import net.corda.core.serialization.ConstructorForDeserialization;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@BelongsToContract(AppleStampContract.class)
//        public class AppleStamp implements LinearState {
//    // Private Variables
//    private String stampDesc;
//    private Party issuer;
//    private Party holder;
//
//    //LinearState required variable.
//    private UniqueIdentifier linerID;
//
//    //Parameter required by all Corda states to indicate storing parties
//    private List<AbstractParty> participants;
//
//    @ConstructorForDeserialization
//    public AppleStamp(String stampDesc, Party issuer, Party holder, UniqueIdentifier linerID) {
//    this.stampDesc = stampDesc;
//    this.issuer = issuer;
//    this.holder = holder;
//    this.linerID = linerID;
//    this.participants = new ArrayList<AbstractParty>();
//    this.participants.add(issuer);
//    this.participants.add(holder);
//}
//
//    public String getStampDesc() {
//        return stampDesc;
//    }
//
//    public Party getIssuer() {
//        return issuer;
//    }
//
//    public Party getHolder() {
//        return holder;
//    }
//
//    @NotNull
//    public UniqueIdentifier getLinerID() {
//        return linerID;
//    }
//
//    @NotNull
//    @Override
//    public List<AbstractParty> getParticipants() {
//        return participants;
//    }
//
//}
