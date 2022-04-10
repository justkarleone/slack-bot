package ru.BoshkaLab.slackbot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private static final String token = "xoxb-977456197875-1001188814789-eeROO5p84xqRH9LEZlXveRLL";
    private static final String postMessageUrl = "https://slack.com/api/chat.postMessage";
    private static final String getAnswerUrl = "https://slack.com/api/conversations.history";
    private static final String getUsersUrl = "https://slack.com/api/users.list";

    enum RequestType {
        GET,
        POST
    }

    private static String request(RequestType requestType, String urlStr, Map<String, String> params) throws IOException {
        URL url = new URL(urlStr);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestType.toString());
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setDoOutput(true);

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(getParamsString(params));
        out.flush();
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();
        connection.disconnect();

        return content.toString();
    }

    private static String getParamsString(Map<String, String> params) throws IOException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            result.append("&");
        }

        return result.toString();
    }

    public static String getUsers() throws IOException {
        Map<String, String> params = new HashMap<>() {{
            put("token", token);
        }};

        return request(RequestType.GET, getUsersUrl, params);
    }

    public static String postMessage(String message, String userId) throws IOException {
        Map<String, String> params = new HashMap<>() {{
            put("token", token);
            put("channel", userId);
            put("text", message);
        }};

        return request(RequestType.POST, postMessageUrl, params);
    }

    public static String getAnswer(String channel) throws IOException {
        Map<String, String> params = new HashMap<>() {{
            put("token", token);
            put("channel", channel);
        }};

        return request(RequestType.GET, getAnswerUrl, params);
    }
}
