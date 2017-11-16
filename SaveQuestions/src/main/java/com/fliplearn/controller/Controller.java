package com.fliplearn.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fliplearn.entity.Question;
import com.fliplearn.service.QuestionServiceImpl;

@RestController
public class Controller {
	@Autowired
	private QuestionServiceImpl questionServiceImpl;

	@RequestMapping(value = "/save", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public void save() throws Exception {
		// byte[] arr = Files.readAllBytes(Paths.get("C:\\Users\\lakhdeep
		// kaur\\Desktop\\Comparison of Adjectives.json"));
		// String text = new String(Files.readAllBytes(Paths.get("C:\Users\lakhdeep
		// kaur\Desktop")),
		// Path files=Paths.get("C:\\Users\\lakhdeep kaur\\Desktop\\quest\\");
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("C:\\Users\\lakhdeep kaur\\Desktop\\quest");
		for (File file1 : file.listFiles()) {
			for (File file2 : file1.listFiles()) {
				for (File file3 : file2.listFiles()) {
					for (File file4 : file3.listFiles()) {
						String path = file4.getAbsolutePath();
						System.out.println(path);
						byte[] byteArray = Files.readAllBytes(Paths.get(path));
						String string = new String(byteArray);
						JSONArray array = new JSONArray(string);
						List<Question> listOfquestions = new ArrayList<Question>();
						for (int i = 0; i < array.length(); i++) {
							Object s = array.get(i);
//                           to get the value of hint
//							JSONObject object = new JSONObject(s.toString());
//							System.out.println("Hint is : " + object.getString("hint"));
							Question q = mapper.readValue(s.toString(), Question.class);
							String[] pathString = path.split("\\\\");
							String className = pathString[5];
							q.setClassName(className);
							String subjectName = pathString[6];
							q.setSubjectName(subjectName);
							String chapterName = pathString[7];
							q.setChapterName(chapterName);
							String topicName = pathString[8];
							q.setTopicName(topicName);
							q.setMarks(3);
							//questionServiceImpl.saveQuestion(q);
							listOfquestions.add(q);
						}
						System.out.println(listOfquestions);
						 questionServiceImpl.saveQuestion(listOfquestions);

						/*
						 * ArrayList< JSONObject> json=new ArrayList<JSONObject>(); JSONObject obj;
						 * String line=null; String
						 * filename="C:\\Users\\lakhdeep kaur\\Desktop\\quest\\class-5\\english\\adjective"
						 * ; FileReader filereader =new FileReader(filename); BufferedReader
						 * bufferedReader = new BufferedReader(filereader); while((line =
						 * bufferedReader.readLine()) != null) { obj = (JSONObject) new
						 * JSONParser().parse(line); json.add(obj);
						 */
						/*
						 * public static void main(String[] args) throws JsonProcessingException,
						 * Exception {
						 * 
						 * 
						 * ObjectMapper mapper = new ObjectMapper(); JsonNode localeTemp =
						 * mapper.readTree(new
						 * File("C:\\Users\\lakhdeep kaur\\Desktop\\quest\\class-5\\english\\adjective")
						 * ); System.out.println(localeTemp); }
						 */
					}
				}
			}
		}
	}
}
