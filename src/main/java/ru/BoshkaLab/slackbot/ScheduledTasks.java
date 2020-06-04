package ru.BoshkaLab.slackbot;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.BoshkaLab.entities.SendingTimetable;
import ru.BoshkaLab.repositories.EmployeeRepository;
import ru.BoshkaLab.repositories.SendingTimetableRepository;
import ru.BoshkaLab.services.EmployeeServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@EnableScheduling
public class ScheduledTasks {
    @Autowired
    SendingTimetableRepository timetableRepo;
    @Autowired
    EmployeeRepository employeeRepo;
    @Autowired
    EmployeeServiceImpl employeeService;

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
//            Request.postMessage(message, slackId);
//            record.setPosted(true);
//            timetableRepo.saveAndFlush(record);
//        }
//    }

    @Scheduled(fixedRate = 30000)
    public void getAnswers() throws IOException {
        System.out.println("It's working");
    }
}
