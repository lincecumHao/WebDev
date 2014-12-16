package tw.cddb.view;

import org.zkoss.zk.ui.util.Clients;

public class ClientsJsFunc {
	
	public static final int POLYGON = 1;

	public static void createSymbol(int whichFactory, String id, String wkt) {
		StringBuilder sb = new StringBuilder();

		switch (whichFactory) {
		case POLYGON:
			sb.append("SYMBOL.push(new Polygon(\"").append(id);
			sb.append("\", \"").append(wkt).append("\"));");
			break;
		default:
			break;
		}
		executeJS(sb.toString());
	}
	
	public static void panTo(String id){
		StringBuilder sb = new StringBuilder();
		sb.append("panTo(\"").append(id).append("\");");
		executeJS(sb.toString());
	}
	
	private static void executeJS (String command){
		Clients.evalJavaScript(command);
	}

}
