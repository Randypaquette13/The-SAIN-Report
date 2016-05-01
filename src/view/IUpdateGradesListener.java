package view;

import java.util.EventListener;

public interface IUpdateGradesListener extends EventListener{
	public String getGrades(UpdateGradesEvent uge);
}
