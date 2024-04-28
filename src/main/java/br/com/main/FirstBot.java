package br.com.main;

import dev.botcity.framework.bot.DesktopBot;
import dev.botcity.maestro_sdk.BotExecutor;
import dev.botcity.maestro_sdk.runner.BotExecution;
import dev.botcity.maestro_sdk.runner.RunnableAgent;

public class FirstBot extends DesktopBot implements RunnableAgent
{
	public FirstBot() {
		try {
			setResourceClassLoader(this.getClass().getClassLoader());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void action(BotExecution botExecution) {

		try {

			// To exec an application (Windows)
			exec("C:\\Program Files (x86)\\Programas RFB\\Sicalc Auto Atendimento\\SicalcAA.exe");
			
			if(!find( "clickContinue", 0.97, 10000)) {
				notFound("clickContinue");
				return;
			}
			click();
			
			if(!find("clickFuncoes", 0.97, 10000)) {	notFound("clickFuncoes");	return;}
			click();

			if(!find("clickPreenchimentoDarf", 0.97, 10000)) {	notFound("clickPreenchimentoDarf");	return;}
			click();			
			
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void load() {
		try {
			
			addImage("clickContinue", "./src/resources/clickContinue.png");
			addImage("clickFuncoes", "./src/resources/clickFuncoes.png");
			addImage("clickPreenchimentoDarf", "./src/resources/clickFuncoes.png");
					

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void notFound(String label) {
		System.out.println("Element not found: "+label);
	}

	public static void main(String[] args) {
		BotExecutor.run(new FirstBot(), args);
	}
}

