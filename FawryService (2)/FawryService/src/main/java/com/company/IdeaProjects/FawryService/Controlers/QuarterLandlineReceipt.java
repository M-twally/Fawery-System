package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

public class QuarterLandlineReceipt implements IservicesProvider
{
    @Override
    public Iform Createform(int type) {
        if(type==1) {
            return new QuarterLandlineForm();
        }
        return null;
    }
    @Override
    public Ihandler CreateHandler(int type, ArrayList<String> Data) {
        if(type==1) {
            return new QuarterLandlineHandler();
        }
        return null;
    }
}
