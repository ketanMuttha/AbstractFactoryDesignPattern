package com.design.AbstractFactory.factory;

import com.design.AbstractFactory.abtract.Policy;

public abstract class PolicyFactory {

    public abstract Policy getPolicy(String policyType);

    public static PolicyFactory getPolicyFactory(String policyType){

        if(policyType.equals("Home")){
            return new HomePolicyFactory();
        }else if(policyType.equals("Auto")){
            return new AutoPolicyFactory();
        }

        return null;
    }
}
