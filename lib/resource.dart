import 'package:conditional_questions/conditional_questions.dart';

List<Question> questions() {
  return [
    Question(
      question: "What is your full name?",
      //isMandatory: true,
      validate: (field) {
        if (field.isEmpty) return "Field cannot be empty";
        return null;
      },
    ),
    Question(
      question: "What is your birth-date?",
      //isMandatory: true,
      validate: (field) {
        if (field.isEmpty) return "Field cannot be empty";
        return null;      
      },
    ),
    Question(
      question: "What is your location?",
      //isMandatory: true,
      validate: (field) {
        if (field.isEmpty) return "Field cannot be empty";
        return null;      
      },
    ),
    PolarQuestion(
        question: "Please enter your gender?",
        answers: ["Female", "Male"],
        isMandatory: true),
    NestedQuestion(
      question: "Which vaccine is applied?",
      answers: ["Sinovac", "Biontech"],),  
          PolarQuestion(
              question: "Please mention any side-effect after vaccination",
              answers: ["Headache", "Loss of smell", "Backache",  "Other"]),
          Question(
            question: "Please mention any PCR positive cases and Covid-19 symptoms after 3rd vaccination.",
          ),
  ];
}