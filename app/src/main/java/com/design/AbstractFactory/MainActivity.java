package com.design.AbstractFactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.design.AbstractFactory.abtract.Policy;
import com.design.AbstractFactory.factory.PolicyFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.userName)
    EditText mUserId;

    @BindView(R.id.PolicyType)
    Spinner mPolicyType;

    @BindView(R.id.subPolicyspinner)
    Spinner mPolicySubType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addItemsOnPolicyTypeSpinner();
        addItemsOnPolicySubTypeSpinner();
    }


    @OnClick(R.id.submit)
    public void policyCreate(View view) {
        Policy policy=null;
        PolicyFactory policyFactory=null;

        policyFactory=PolicyFactory.getPolicyFactory(mPolicyType.getSelectedItem().toString());
        policy=policyFactory.getPolicy(mPolicySubType.getSelectedItem().toString());
        policy.CreatePolicy();

        Toast.makeText(this,mUserId.getText()+", "+" Your "+mPolicyType.getSelectedItem().toString()+" "+mPolicySubType.getSelectedItem().toString()+" policy Created!! We will send the mail about the confirmation soon." +
                "Thanks for the business with us!!.",Toast.LENGTH_LONG).show();

    }


    // add items into policy spinner dynamically
    public void addItemsOnPolicyTypeSpinner() {
        List<String> list = new ArrayList<String>();
        list.add("Auto");
        list.add("Home");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPolicyType.setAdapter(dataAdapter);


    }

    // add items into policy subtype spinner  dynamically
    public void addItemsOnPolicySubTypeSpinner() {
        List<String> list = new ArrayList<String>();
        list.add("Owner");
        list.add("Rental");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPolicySubType.setAdapter(dataAdapter);
    }
}
