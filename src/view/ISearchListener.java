package view;

import java.util.EventListener;

public interface ISearchListener extends EventListener {
	public String search(SearchEvent e);//return a string so that there can be an error message
}
