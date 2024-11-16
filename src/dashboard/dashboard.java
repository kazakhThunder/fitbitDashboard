package dashboard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class dashboard {
	public static void main(String args[]) {
		String sleepData = "https://api.fitbit.com/1.2/user/C6SLTK/sleep/date/2024-11-11/2024-10-10.json";
		try {
			URL url = new URL(sleepData);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("authorization", "application/json");
			con.setRequestProperty("accept", "application/json");
			con.setRequestProperty("accept-language", "en_US");
			con.setRequestProperty("accept-locale", "en_US");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
