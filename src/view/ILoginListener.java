package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;

public interface ILoginListener extends EventListener{
	public void getLoginDetails(LoginEvent e);

}
