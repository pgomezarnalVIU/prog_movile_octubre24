import 'package:flutter/material.dart';
import 'package:mis_imagenes/screens/settings_screen.dart';

class IntroScreen extends StatelessWidget {
  const IntroScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Welcome Screen'),
        ),
        body: Stack(children: [
          Positioned.fill(
              child: Image.asset(
            'assets/Sea.jpg',
            fit: BoxFit.cover,
          )),
          const Center(
            child: Text(
              'Welcome',
              style: TextStyle(color: Colors.white, fontSize: 24),
            ),
          ),
          Align(
              alignment: const Alignment(0, 0.5),
              child: ElevatedButton(
                  onPressed: () {
                    Navigator.of(context).push(MaterialPageRoute(
                        builder: (BuildContext context) =>
                            const SettingsScreen()));
                  },
                  child: const Text('Start')))
        ]));
  }
}
