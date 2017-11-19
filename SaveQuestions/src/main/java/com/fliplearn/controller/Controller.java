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
import com.fliplearn.entity.Choices;
import com.fliplearn.entity.Question;
import com.fliplearn.service.QuestionServiceImpl;

@RestController
public class Controller {
	@Autowired
	private QuestionServiceImpl questionServiceImpl;

	@RequestMapping(value = "/save", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public void save() throws Exception {
		// String imagetag="<img";
		// String mathml="$$";
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
							// to get the value of hint
							// JSONObject object = new JSONObject(s.toString());
							// System.out.println("Hint is : " + object.getString("hint"));
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
							List<Choices> optionsList = q.getOptionsList();
							for (Choices c : optionsList) {
								if (q.getQuestionTitle().contains("<img") && c.getOptionText().contains("$$")) {
									q.setQuestion_type("TI");
									c.setChoice_Type("TI");
								} else if (q.getQuestionTitle().contains("$$") && c.getOptionText().contains("$$")) {
									q.setQuestion_type("TM");
									c.setChoice_Type("TM");

								} else if (q.getQuestionTitle().contains("<img") && q.getQuestionTitle().contains("$$")
										&& c.getOptionText().contains("<img") && c.getOptionText().contains("$$")) {
									q.setQuestion_type("TIM");
									c.setChoice_Type("TIM");
								} else {
									q.setQuestion_type("T");
									c.setChoice_Type("T");
								}
							}
							/*
							 * Pattern mathMl = Pattern.compile("$$"); Pattern image =
							 * Pattern.compile("<img"); Matcher matcher =
							 * mathMl.matcher(q.getQuestionTitle()); Matcher matcher1 =
							 * image.matcher(q.getQuestionTitle()); if (matcher.find()) {
							 * q.setQuestion_type("TM"); } else if (matcher1.find()) {
							 * q.setQuestion_type("TI"); } else if (matcher.find() && matcher1.find()) {
							 * q.setQuestion_type("TIM"); } else { q.setQuestion_type("T"); }
							 */
							/*
							 * if(true) { q.setType("TI"); }
							 */
							// questionServiceImpl.saveQuestion(q);
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

					}
				}
			}
		}
	}
}
