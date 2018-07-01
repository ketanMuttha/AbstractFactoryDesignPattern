package com.design.AbstractFactory.factory;

import com.design.AbstractFactory.abtract.Policy;
import com.design.AbstractFactory.auto.OwenrAutoPolicy;
import com.design.AbstractFactory.auto.RentalAutoPolicy;

public class AutoPolicyFactory extends PolicyFactory {

    @Override
    public Policy getPolicy(String policyType) {

        if (policyType.equals("Owner")) return new OwenrAutoPolicy();
        else if (policyType.equals("Rental")) return new RentalAutoPolicy();
        return null;
    }
}
