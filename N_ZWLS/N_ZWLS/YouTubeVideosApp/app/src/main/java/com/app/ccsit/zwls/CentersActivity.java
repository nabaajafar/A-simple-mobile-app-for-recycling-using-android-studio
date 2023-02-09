package com.app.ccsit.zwls;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CentersActivity extends AppCompatActivity {

    ListView simpleList;
    String[] countryList= {"Techno Plastic Factory", "Al-Ghadeer Paper Products Factory", "Arab Recycling Company Ltd", "Saudi Investment Recycling Company",  "Waste Collection & Recycling Company Ltd"};
    String[] desc={"  Phone:050 693 3163                       Email:techno.plast.info@aljawadgroup.net","Phone: 013-5866691 Email:web@alghadeergroup.com"," Our motto: Partners in an environment we want growth and purity              Phone: 00966-13-8573270              Email: info @ arab-recycling.com ","Vision “To be the National Waste Management champion driving circular economy for a sustainable society              Email:Info@sirc.sa”","WASCO is a market leading integrated recycling and waste management company                          Phone:+966 2 - 2897029              Email : info@wasco-sa.com"};
    int [] flags = {R.drawable.plastic_recycling, R.drawable.algadeer, R.drawable.arc, R.drawable.sirc, R.drawable.wasco};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_centers);
        simpleList =(ListView) findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter(this, countryList, desc,flags);
        simpleList.setAdapter(customAdapter);
    }
}