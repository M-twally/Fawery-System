package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class QuarterLandlineForm extends Iform
{
    @Override
    public ArrayList<String> createForm() {
        String Phone="Enter your Home Number:";
        String Amount="Enter your Amount from 500 to 1000:";
        data.add(Phone);
        data.add(Amount);
        return data;
    }
}
