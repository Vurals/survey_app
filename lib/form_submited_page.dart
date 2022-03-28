import 'package:flutter/material.dart';

class SubmitedPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final appTitle = 'COVID-19 Vaccination Survey';
    return MaterialApp(
      title: appTitle,
      home: Scaffold(
          appBar: AppBar(
            title: Text(appTitle),
          ),
          body: SingleChildScrollView(
            child: Container(
              alignment: Alignment.center,
              height: 100,
              child: const Text(
                ' Your answers have been recorded, thank you.',
                style: TextStyle(
                  color: Colors.black,
                  fontSize: 25,
                ),
                textAlign: TextAlign.left,
              ),
            ),
          )),
    );
  }
}
