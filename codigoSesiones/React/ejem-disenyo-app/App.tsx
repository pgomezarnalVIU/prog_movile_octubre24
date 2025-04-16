import React from 'react';

import {
  SafeAreaView,
  ScrollView,
  StyleSheet,
  View,
} from 'react-native';

import FlatCard from './components/FlatCard';
import FlatcardScroll from './components/FlatCardScroll';
import FancyCard from './components/FancyCard';
import ContactList from './components/ContactList';
import ActionCard from './components/ActionCard';


function App(): React.JSX.Element {

  return (
    <SafeAreaView style={styles.sectionContainer}>
      <ScrollView >
        <FlatCard/>
        <FlatcardScroll/>
        <FancyCard/>
        <ContactList/>
        <ActionCard/>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;
