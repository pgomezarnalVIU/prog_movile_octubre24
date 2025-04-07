import 'package:flutter/material.dart';

class IntroScreen extends StatelessWidget {
  const IntroScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Welcome Screen'),
        ),
        body: Center(
          child: Text(
            'Welcome',
            style: TextStyle(fontSize: 24),
          ),
        ));
  }
}
