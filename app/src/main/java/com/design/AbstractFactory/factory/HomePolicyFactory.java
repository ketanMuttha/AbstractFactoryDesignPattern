package com.design.AbstractFactory.factory;

import com.design.AbstractFactory.abtract.Policy;
import com.design.AbstractFactory.home.OwnerHomePolicy;
import com.design.AbstractFactory.home.RentalHomePolicy;

public class HomePolicyFactory extends PolicyFactory {


    @Override
    public Policy getPolicy(String policyType) {

        if (policyType.equals("Owner")) return new OwnerHomePolicy();
        else if (policyType.equals("Rental")) return new RentalHomePolicy();

        return null;
    }

}
