package com.company.IdeaProjects.FawryService.Controlers;
import java.util.ArrayList;

public interface IservicesProvider {
	public Iform Createform(int type);
    public Ihandler CreateHandler(int type,ArrayList<String> Data);

}
