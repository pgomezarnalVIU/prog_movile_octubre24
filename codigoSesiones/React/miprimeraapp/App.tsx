import { requireNativeComponent, StyleSheet, Text, View } from 'react-native';
import { Gato } from './Gato';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Como estas Pakito</Text>
      <Gato></Gato>
      <Gato></Gato>
      <Gato></Gato>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
