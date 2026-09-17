package KeyWordDriven;

public class keywordexecutorssauce {

keywordimplemenatationsauce k = new keywordimplemenatationsauce();
	
	
	public void executors(String keyword) {
		if(keyword.equals("LAUNCH_BROWSER"))
		{
			k.launchBrowser();
		}
		else if(keyword.equals("OPEN_URL"))
		{
			k.openurl();
		}
		else if(keyword.equals("USER_NAME"))
		{
			k.username();
		}
		else if(keyword.equals("PASSWORD"))
		{
			k.password();
		}
		else if(keyword.equals("LOGIN"))
		{
			k.login();
		}
		else
		{
			k.closebrowser();
		}
	}
	}


