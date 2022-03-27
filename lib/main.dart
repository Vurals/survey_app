import 'package:flutter/material.dart';
import 'package:survey_app/form_submited_page.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    const appTitle = 'COVİD-19 Anket Uygulaması';
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

enum SingingCharacter { Erkek, Kadin }

// Create a corresponding State class, which holds data related to the form.
class MyCustomFormState extends State<MyCustomForm> {
  // Create a global key that uniquely identifies the Form widget
  // and allows validation of the form.
  final _formKey = GlobalKey<FormState>();
  SingingCharacter? _character = SingingCharacter.Erkek;
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
    if ((textEditingController.text.trim() != "") &&
        ((isNumeric(textEditingController2.text) &&
            int.parse(textEditingController2.text) <= 31 &&
            textEditingController2.text.length == 2)) &&
        ((isNumeric(textEditingController3.text) &&
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
              ' Lütfe tam adınızı giriniz.',
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
              hintText: 'Tam adınızı giriniz',
              labelText: 'İsim',
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
              ' Doğum Tarihinizi Giriniz.',
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
                      hintText: 'Gün',
                    ),
                    validator: (value) {
                      if (isNumeric(value!) &&
                          int.parse(value) <= 31 &&
                          value.length == 2) {
                        return null;
                      }
                      return 'Lütfen geçerli bir gün giriniz';
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
                      hintText: 'Ay',
                    ),
                    validator: (value) {
                      if (isNumeric(value!) &&
                          int.parse(value) <= 12 &&
                          value.length == 2) {
                        return null;
                      }
                      return 'Lütfen geçerli bir ay giriniz';
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
                      hintText: 'Yıl',
                    ),
                    validator: (value) {
                      if (isNumeric(value!) &&
                          int.parse(value) <= 2022 &&
                          value.length == 4) {
                        return null;
                      }
                      return 'Lütfen geçerli bir yıl giriniz';
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
                  ' İkamet ettiğiniz şehri seçiniz.',
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
                    return 'Geçerli bir şehir giriniz';
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
              ' Cinsiyetinizi seçiniz.',
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
                title: const Text('Erkek'),
                leading: Radio<SingingCharacter>(
                  value: SingingCharacter.Erkek,
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
                title: const Text('Kadın'),
                leading: Radio<SingingCharacter>(
                  value: SingingCharacter.Kadin,
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
              ' Uygulanan aşı tipini seçiniz.',
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
                return 'Geçerli bir şehir giriniz';
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
              ' Aşı uygulamasından sonra gözlenen yan etkiler.',
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
              hintText: 'Örn: Baş ağrısı, Yüksek ateş',
            ),
            validator: (value) {
              if (value!.isEmpty) {
                return 'Yan etkiler boş bırakılamaz, yan etki gözlemlemediyseniz "yok" yazınız.';
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
              ' 3. Aşı uygulamasından sonra gözlenen COVİD-19 belirtileri veya pozitif PCR testiniz varsa belirtiniz.',
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
              hintText: 'Örn: Baş ağrısı, Yüksek ateş',
            ),
            validator: (value) {
              if (value!.isEmpty) {
                return 'Belirtiniz veya pozitif PCR sonucunuz yoksa "yok" yazınız.';
              }
              return null;
            },
          ),
          Container(
              padding: const EdgeInsets.only(left: 175.0, top: 20.0),
              child: status
                  ? ElevatedButton(
                      child: const Text('Gönder'),
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
