package com.company.IdeaProjects.FawryService.Controlers;

import java.util.ArrayList;

abstract class Ihandler {
	ArrayList<String> Data;

	public Ihandler(ArrayList<String> data) {
		Data = data;
	}

	public abstract boolean Handler();
}
