import { SafeAreaView, StyleSheet} from 'react-native';

import CompView from './components/CompView';
import CompFlex from './components/CompFlex';
import CompImage from './components/CompImage';
import CompScrollView from './components/CompScrollView';
import CompTouch from './components/CompTouch';

//ENUM de los diferentes componentes que voy a usar
const EJEMPLOS={
  COMPVIEW:0,
  FLEX:1,
  IMAGE:2,
  SCROLLVIEW:3,
  COMPTOUCH:4
}
const componenteActual=EJEMPLOS.COMPTOUCH


export default function App() {
    //Logica de la aplicacion
    let compCarga
    if(componenteActual==EJEMPLOS.COMPVIEW) compCarga=<CompView/>
    else if(componenteActual==EJEMPLOS.FLEX) compCarga=<CompFlex/>
    else if(componenteActual==EJEMPLOS.IMAGE) compCarga=<CompImage/>
    else if(componenteActual==EJEMPLOS.SCROLLVIEW) compCarga=<CompScrollView/>
    else if(componenteActual==EJEMPLOS.COMPTOUCH) compCarga=<CompTouch/>
  return (
    <SafeAreaView style={styles.container}>
      {compCarga}
    </SafeAreaView>
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
