import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import CompView from './components/CompView';
import CompFlex from './components/CompFlex';
import CompImage from './components/CompImage';

//ENUM de los diferentes componentes que voy a usar
const EJEMPLOS={
  COMPVIEW:0,
  FLEX:1,
  IMAGE:2
}
const componenteActual=EJEMPLOS.IMAGE


export default function App() {
    //Logica de la aplicacion
    let compCarga
    if(componenteActual==EJEMPLOS.COMPVIEW) compCarga=<CompView/>
    else if(componenteActual==EJEMPLOS.FLEX) compCarga=<CompFlex/>
    else if(componenteActual==EJEMPLOS.IMAGE) compCarga=<CompImage/>
  return (
    <View style={styles.container}>
      {compCarga}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'stretch',
    justifyContent: 'center',
  },
});
