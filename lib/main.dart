import 'package:flutter/material.dart';
import 'package:survey_app/form_submited_page.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    const appTitle = 'COVID-19 Vaccination Survey';
    return MaterialApp(
      title: appTitle,
      home: Scaffold(
          appBar: AppBar(
            title: const Text(appTitle),
          ),
          body: SingleChildScrollView(child: MyCustomForm())),
    );
  }
}

// Create a Form widget.
class MyCustomForm extends StatefulWidget {
  @override
  MyCustomFormState createState() {
    return MyCustomFormState();
  }
}

enum SingingCharacter { Male, Female }
final validCharacters = RegExp(r'^[a-zA-Z ]+$');

// Create a corresponding State class, which holds data related to the form.
class MyCustomFormState extends State<MyCustomForm> {
  // Create a global key that uniquely identifies the Form widget
  // and allows validation of the form.
  final _formKey = GlobalKey<FormState>();
  SingingCharacter? _character = SingingCharacter.Male;
  String _selectedValue = "-";
  String _selectedValue1 = "-";
  List<String> listOfVaccine = ["-", "Sinovac", "Turkovac", "Biontech"];
  List<String> listOfValue = [
    "-",
    "Adana",
    "Adıyaman",
    "Afyonkarahisar",
    "Ağrı",
    "Aksaray",
    "Amasya",
    "Ankara",
    "Antalya",
    "Ardahan",
    "Artvin",
    "Aydın",
    "Balıkesir",
    "Bartın",
    "Batman",
    "Bayburt",
    "Bilecik",
    "Bingöl",
    "Bitlis",
    "Bolu",
    "Burdur",
    "Bursa",
    "Çanakkale",
    "Çankırı",
    "Çorum",
    "Denizli",
    "Diyarbakır",
    "Düzce",
    "Edirne",
    "Elazığ",
    "Erzincan",
    "Erzurum",
    "Eskişehir",
    "Gaziantep",
    "Giresun",
    "Gümüşhane",
    "Hakkâri",
    "Hatay",
    "Iğdır",
    "Isparta",
    "İstanbul",
    "İzmir",
    "Kahramanmaraş",
    "Karabük",
    "Karaman",
    "Kars",
    "Kastamonu",
    "Kayseri",
    "Kilis",
    "Kırıkkale",
    "Kırklareli",
    "Kırşehir",
    "Kocaeli",
    "Konya",
    "Kütahya",
    "Malatya",
    "Manisa",
    "Mardin",
    "Mersin",
    "Muğla",
    "Muş",
    "Nevşehir",
    "Niğde",
    "Ordu",
    "Osmaniye",
    "Rize",
    "Sakarya",
    "Samsun",
    "Şanlıurfa",
    "Siirt",
    "Sinop",
    "Sivas",
    "Şırnak",
    "Tekirdağ",
    "Tokat",
    "Trabzon",
    "Tunceli",
    "Uşak",
    "Van",
    "Yalova",
    "Yozgat",
    "Zonguldak"
  ];
  bool status = false;

  late TextEditingController textEditingController;
  late TextEditingController textEditingController2;
  late TextEditingController textEditingController3;
  late TextEditingController textEditingController4;
  late TextEditingController textEditingController5;
  late TextEditingController textEditingController6;
  disableButton() {
    setState(() {
      status = false;
    });
  }

  enableButton() {
    setState(() {
      status = true;
    });
  }

  checkAllFields() {
    if ((validCharacters.hasMatch(textEditingController.text.trim())) &&
        ((isNumeric(textEditingController2.text) &&
            int.parse(textEditingController2.text) > 0 &&
            int.parse(textEditingController2.text) <= 31 &&
            textEditingController2.text.length == 2)) &&
        ((isNumeric(textEditingController3.text) &&
            int.parse(textEditingController3.text) > 0 &&
            int.parse(textEditingController3.text) <= 12 &&
            textEditingController3.text.length == 2)) &&
        ((isNumeric(textEditingController4.text) &&
            int.parse(textEditingController4.text) <= 2022 &&
            int.parse(textEditingController4.text) >= 1900 &&
            textEditingController4.text.length == 4)) &&
        (textEditingController5.text.trim() != "") &&
        (textEditingController6.text.trim() != "") &&
        (_selectedValue != "-") &&
        (_selectedValue1 != "-")) {
      enableButton();
    } else {
      disableButton();
    }
  }

  bool isNumeric(String s) {
    return double.tryParse(s) != null;
  }

  @override
  void initState() {
    super.initState();
    textEditingController = TextEditingController();
    textEditingController2 = TextEditingController();
    textEditingController3 = TextEditingController();
    textEditingController4 = TextEditingController();
    textEditingController5 = TextEditingController();
    textEditingController6 = TextEditingController();

    textEditingController.addListener(() {
      checkAllFields();

      setState(() => this.status = status);
    });

    textEditingController2.addListener(() {
      checkAllFields();

      setState(() => this.status = status);
    });
    textEditingController3.addListener(() {
      checkAllFields();

      setState(() => this.status = status);
    });
    textEditingController4.addListener(() {
      checkAllFields();

      setState(() => this.status = status);
    });
    textEditingController5.addListener(() {
      checkAllFields();

      setState(() => this.status = status);
    });
    textEditingController6.addListener(() {
      checkAllFields();

      setState(() => this.status = status);
    });
  }

  @override
  void dispose() {
    textEditingController.dispose();
    textEditingController2.dispose();
    textEditingController3.dispose();
    textEditingController4.dispose();
    textEditingController5.dispose();
    textEditingController6.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    // Build a Form widget using the _formKey created above.
    return Form(
      key: _formKey,
      child: Column(
        key: ValueKey('nameField'),
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Container(
            alignment: Alignment.topLeft,
            child: const Text(
              ' Your name and surname:',
              style: TextStyle(
                color: Colors.black,
                fontSize: 18,
              ),
              textAlign: TextAlign.left,
            ),
          ),
          TextFormField(
            decoration: const InputDecoration(
              prefixIcon: Icon(Icons.person),
              hintText: 'Please enter your full name',
              labelText: 'Name Surname',
            ),
            controller: textEditingController,
            validator: (value) {
              if (value!.isEmpty) {
                return 'Name cannot be empty';
              }
              return null;
            },
          ),
          Container(
            alignment: Alignment.topLeft,
            height: 30,
            child: const Text(
              ' Your birth date in DD/MM/YYYY format:',
              style: TextStyle(
                color: Colors.black,
                fontSize: 18,
              ),
              textAlign: TextAlign.left,
            ),
          ),
          Container(
            child: Row(
              mainAxisSize: MainAxisSize.max,
              children: [
                //const SizedBox(width: 10),
                Expanded(
                  flex: 2,
                  child: TextFormField(
                    controller: textEditingController2,
                    decoration: const InputDecoration(
                      prefixIcon: Icon(Icons.calendar_today),
                      //border: OutlineInputBorder(),
                      hintText: 'Day',
                    ),
                    validator: (value) {
                      if (isNumeric(value!) &&
                          int.parse(value) <= 31 &&
                          value.length == 2) {
                        return null;
                      }
                      return 'Enter a valid day';
                    },
                  ),
                ),
                Expanded(
                  flex: 2,
                  child: TextFormField(
                    controller: textEditingController3,
                    decoration: const InputDecoration(
                      prefixIcon: Icon(Icons.remove),
                      //border: OutlineInputBorder(),
                      hintText: 'Month',
                    ),
                    validator: (value) {
                      if (isNumeric(value!) &&
                          int.parse(value) <= 12 &&
                          value.length == 2) {
                        return null;
                      }
                      return 'Enter a valid month';
                    },
                  ),
                ),
                Expanded(
                  flex: 3,
                  child: TextFormField(
                    controller: textEditingController4,
                    decoration: const InputDecoration(
                      helperMaxLines: 2,
                      prefixIcon: Icon(Icons.remove),
                      //border: OutlineInputBorder(),
                      hintText: 'Year',
                    ),
                    validator: (value) {
                      if (isNumeric(value!) &&
                          int.parse(value) <= 2022 &&
                          value.length == 4) {
                        return null;
                      }
                      return 'Enter a valid year';
                    },
                  ),
                ),
                //const SizedBox(width: 50),
              ],
            ),
          ),
          Column(
            children: [
              const SizedBox(
                height: 10,
              ),
              Container(
                alignment: Alignment.topLeft,
                child: const Text(
                  ' Choose your city:',
                  style: TextStyle(
                    color: Colors.black,
                    fontSize: 18,
                  ),
                  textAlign: TextAlign.left,
                ),
              ),
              DropdownButtonFormField(
                decoration: const InputDecoration(
                  prefixIcon: Icon(Icons.location_city),
                ),
                value: _selectedValue,
                isExpanded: true,
                onChanged: (value) {
                  setState(() {
                    _selectedValue = value.toString();
                  });
                  checkAllFields();
                },
                onSaved: (value) {
                  setState(() {
                    _selectedValue = value.toString();
                  });
                },
                validator: (value) {
                  if (value!.toString().isEmpty) {
                    return ' Please enter a valid city';
                  }
                  return null;
                },
                items: listOfValue.map((String val) {
                  return DropdownMenuItem(
                    value: val,
                    child: Text(
                      val,
                    ),
                  );
                }).toList(),
              )
            ],
          ),
          const SizedBox(
            height: 10,
          ),
          Container(
            alignment: Alignment.topLeft,
            child: const Text(
              ' Your gender:',
              style: TextStyle(
                color: Colors.black,
                fontSize: 18,
              ),
              textAlign: TextAlign.left,
            ),
          ),
          Row(mainAxisSize: MainAxisSize.max, children: [
            Expanded(
              child: ListTile(
                title: const Text('Male'),
                leading: Radio<SingingCharacter>(
                  value: SingingCharacter.Male,
                  groupValue: _character,
                  onChanged: (SingingCharacter? value) {
                    setState(() {
                      _character = value;
                    });
                  },
                ),
              ),
            ),
            Expanded(
              child: ListTile(
                title: const Text('Female'),
                leading: Radio<SingingCharacter>(
                  value: SingingCharacter.Female,
                  groupValue: _character,
                  onChanged: (SingingCharacter? value) {
                    setState(() {
                      _character = value;
                    });
                  },
                ),
              ),
            ),
          ]),
          Container(
            alignment: Alignment.topLeft,
            child: const Text(
              ' The vaccine type you applied:',
              style: TextStyle(
                color: Colors.black,
                fontSize: 18,
              ),
              textAlign: TextAlign.left,
            ),
          ),
          DropdownButtonFormField(
            decoration: const InputDecoration(
              prefixIcon: Icon(Icons.vaccines),
            ),
            value: _selectedValue1,
            isExpanded: true,
            onChanged: (value) {
              setState(() {
                _selectedValue1 = value.toString();
              });
              checkAllFields();
            },
            onSaved: (value) {
              setState(() {
                _selectedValue1 = value.toString();
              });
            },
            validator: (value) {
              if (value!.toString().isEmpty) {
                return 'Enter a valid city';
              }
              return null;
            },
            items: listOfVaccine.map((String val) {
              return DropdownMenuItem(
                value: val,
                child: Text(
                  val,
                ),
              );
            }).toList(),
          ),
          const SizedBox(
            height: 10,
          ),
          Container(
            alignment: Alignment.topLeft,
            child: const Text(
              ' Any side effects after vaccination:',
              style: TextStyle(
                color: Colors.black,
                fontSize: 18,
              ),
              textAlign: TextAlign.left,
            ),
          ),
          TextFormField(
            controller: textEditingController5,
            decoration: const InputDecoration(
              helperMaxLines: 2,
              prefixIcon: Icon(Icons.coronavirus_sharp),
              //border: OutlineInputBorder(),
              hintText: 'Ex: Headache, fever...',
            ),
            validator: (value) {
              if (value!.isEmpty) {
                return 'Do not leave this field empty, write \"none\" if you did not observe side effects';
              }
              return null;
            },
          ),
          const SizedBox(
            height: 10,
          ),
          Container(
            alignment: Alignment.topLeft,
            child: const Text(
              ' Any PCR positive cases and Covid-19 symptoms after 3rd vaccination:',
              style: TextStyle(
                color: Colors.black,
                fontSize: 18,
              ),
              textAlign: TextAlign.left,
            ),
          ),
          TextFormField(
            controller: textEditingController6,
            decoration: const InputDecoration(
              helperMaxLines: 2,
              prefixIcon: Icon(Icons.coronavirus_sharp),
              //border: OutlineInputBorder(),
              hintText: 'Ex: Headache, fever...',
            ),
            validator: (value) {
              if (value!.isEmpty) {
                return 'Do not leave this field empty, write \"none\" if you did not observe positive cases';
              }
              return null;
            },
          ),
          Container(
              padding: const EdgeInsets.only(left: 175.0, top: 20.0),
              child: status
                  ? ElevatedButton(
                      child: const Text('Send'),
                      onPressed: status
                          ? () {
                              // It returns true if the form is valid, otherwise returns false
                              if (_formKey.currentState!.validate()) {
                                //disableButton();
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                      builder: (context) => SubmitedPage()),
                                );
                                // If the form is valid, display a Snackbar.
                                // ignore: deprecated_member_use
                                Scaffold.of(context).showSnackBar(
                                    const SnackBar(
                                        content:
                                            Text('Data is in processing.')));
                              }
                            }
                          : null,
                    )
                  : new Container()),
        ],
      ),
    );
  }
}
