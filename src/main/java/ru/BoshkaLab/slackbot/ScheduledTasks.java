package ru.BoshkaLab.slackbot;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.BoshkaLab.entities.*;
import ru.BoshkaLab.repositories.*;
import ru.BoshkaLab.services.EmployeeServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EnableScheduling
public class ScheduledTasks {
    @Autowired
    SendingTimetableRepository timetableRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    AnswerRepository answerRepository;

//    @Scheduled(fixedRate = 10000)
//    public void updateUserList() throws IOException {
//        String usersJsonStr = Request.getUsers();
//
//        JSONObject jsonObject = new JSONObject(usersJsonStr);
//        JSONArray members = jsonObject.getJSONArray("members");
//        for (int i = 0; i < members.length(); i++) {
//            JSONObject user = members.getJSONObject(i);
//            if (user.getString("name").equals("slackbot") || user.getString("name").equals("boshkabot"))
//                continue;
//
//            String slackId = user.getString("id");
//            if (employeeRepo.existsBySlackId(slackId))
//                continue;
//
//            String name = user.getString("real_name");
//
//            JSONObject profile = user.getJSONObject("profile");
//            String email = profile.getString("email");
//
//            employeeService.add(slackId, name);
//        }
//    }
//
//    @Scheduled(fixedRate = 9000)
//    public void postMessage() throws IOException {
//        Date currentTime = new Date(System.currentTimeMillis());
//        List<SendingTimetable> timetable = timetableRepo.findAllByPostedIsFalseAndTimeLessThanEqual(currentTime);
//        for (var record : timetable) {
//            String message = record.getQuestion().getText();
//            String slackId = record.getEmployee().getSlackId();
//
//            String answerStr = Request.postMessage(message, slackId);
//
//            JSONObject answer = new JSONObject(answerStr);
//            String channel = answer.getString("channel");
//            Channel newChannel = new Channel(channel, record.getEmployee());
//            channelRepository.saveAndFlush(newChannel);
//
//            record.setPosted(true);
//            timetableRepo.saveAndFlush(record);
//        }
//    }
//
//    @Scheduled(fixedRate = 30000)
//    public void getAnswers() throws IOException {
//        List<Employee> employeeList = employeeRepository.findAllByTimeOfEnding(null);
//        for (Employee employee : employeeList) {
//            List<SendingTimetable> records = timetableRepository.findAllByPostedIsTrueAndEmployee(employee, Sort.by(Sort.Direction.ASC, "time"));
//            if (records.size() == 0)
//                continue;
//            SendingTimetable record = records.get(records.size() - 1);
//            String channel = channelRepository.findByEmployee(employee).getChannel();
//
//            String answerBody = Request.getAnswer(channel);
//            String answerText = parseAnswer(answerBody, record.getQuestion().getText());
//            Date currentTime = new Date(System.currentTimeMillis());
//
//            Answer answer = new Answer(answerText, currentTime, employee, record.getQuestion());
//            answerRepository.saveAndFlush(answer);
//        }
//        System.out.println("It's working");
//    }

    private String parseAnswer(String answer, String question) {
        JSONObject jsonAnswer = new JSONObject(answer);
        JSONArray messages = new JSONArray(jsonAnswer.getJSONArray("messages"));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < messages.length(); i++) {
            JSONObject message = messages.getJSONObject(i);
            String text = decodeString(message.getString("text"));

            if (text.equals(question))
                break;

            if (result.length() != 0)
                result.append("\n");
            result.append(text);
        }
        return result.toString();
    }

    private String decodeString(String str) {
        String newStr = str;
        Set<String> hexItems = new HashSet<>();

        Matcher m = Pattern.compile("\\\\u[a-fA-f0-9]{4}").matcher(str);
        while (m.find()) {
            hexItems.add(m.group());
        }

        for (String unicodeHex : hexItems) {
            int hexVal = Integer.parseInt(unicodeHex.substring(2), 16);
            newStr = newStr.replace(unicodeHex, "" + ((char) hexVal));
        }

        return newStr;
    }
}
