/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useState } from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  TextInput,
  TouchableOpacity
} from 'react-native';

import { Formik } from 'formik';
import * as Yup from 'yup'

import BouncyCheckbox from "react-native-bouncy-checkbox";

//PASO 1: ESQUEMA
const PasswordEsquema = Yup.object().shape({
  passwordLong: Yup.number()
  .min(4, 'Debe tener un mínimo de 4 caracteres')
  .max(16, 'DEbe tener un máximo de 16 caracteres')
  .required('Longitud es requerida')
})



function App(): JSX.Element {
  const [password, setPassword] = useState('')
  const [isPassGenerated, setIsPassGenerated] = useState(false)

  const [lowerCase, setLowerCase] = useState(true)
  const [upperCase, setupperCase] = useState(false)
  const [numbers, setNumbers] = useState(false)
  const [symbols, setSymbols] = useState(false)

  const resetPasswordState = () => {
    setPassword('')
    setIsPassGenerated(false)
    setLowerCase(true)
    setupperCase(false)
    setNumbers(false)
    setSymbols(false)
    
    
  }
//PASO 5: DEJAR FUNCION GENERACION PASSWORD MARCADA
  const generarPasswordString = (passwordLength: number) => {
    let characterList = '';

    const upperCaseChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    const lowerCaseChars = 'abcdefghijklmnopqrstuvwxyz';
    const digitChars = '0123456789';
    const specialChars = '!@#$%^&*()_+';

    if (upperCase) {
      characterList += upperCaseChars
    }
    if (lowerCase) {
      characterList += lowerCaseChars
    }
    if (numbers) {
      characterList += digitChars
    }
    if (symbols) {
      characterList += specialChars
    }

    const passwordResult = createPassword(characterList, passwordLength )

    setPassword(passwordResult)
    setIsPassGenerated(true)
    
  }
  const createPassword = (characters: string, passwordLength: number) => {
    let result = ''
    for (let i = 0; i < passwordLength; i++) {
      const characterIndex = Math.round(Math.random() * characters.length)
      result += characters.charAt(characterIndex)
    }
    return result
    console.log("hitesh");
    
  }
  return (
    <SafeAreaView>
      <ScrollView keyboardShouldPersistTaps="handled">
        <View style={styles.formContainer}>
          <Text style={styles.title}>Generador del password</Text>
          {/*PASO 2 Copiar Formik original*/}
          <Formik
          /*PASO 3 Modificar el valor inicial*/
       initialValues={{ passwordLong: ''}}
       /*PASO 4 Eliminamos la validación para poner un validationSchema*/
       validationSchema={PasswordEsquema}
       /*PASO 6 */
       onSubmit={ values => {
        console.log(values);
        generarPasswordString(parseInt(values.passwordLong)) 
       }}
     >
       {({
         values,
         errors,
         touched,
         isValid,
         handleChange,
         handleSubmit,
         handleReset,
         /* PASO 7 añadimos isValid, eliminamos Blur, eliminamos isSubmitting */
       }) => (
         /* PASO 8 Eliminamos todo el código que es de REACT comenzamos con NAtive*/
         <>
          {/* PASO 9 Escribimos 6 veces <View style={styles.inputWrapper}></View>*/}
          <View style={styles.inputWrapper}>
            <View style={styles.inputColumn}>
              <Text style={styles.heading}>Longitud del password</Text>
              {/* PASO 13 Incluimos el manejo de los errores */}
              {/* PASO 13 Siempre que las condiciones sean correctas se inyecta un componente */}
              {touched.passwordLong && errors.passwordLong && (
                <Text style={styles.errorText}>
                  {errors.passwordLong}
                </Text>
              )}
            </View>
              {/* PASO 11 TextInput */}
              {/* PASO 12 handleChange Este handle directamente se encarga de actualizar el valor */}

            <TextInput
                style={styles.inputStyle}
                value={values.passwordLong}
                onChangeText={handleChange('passwordLength')}
                placeholder="8"
                keyboardType='numeric'
              />
          </View>
          {/* PASO 14 Checkers todos */}
          <View style={styles.inputWrapper}>
            <Text style={styles.heading}>Include lowercase</Text>
            <BouncyCheckbox
              disableBuiltInState
              isChecked={lowerCase}
              onPress={() => setLowerCase(!lowerCase)}
              fillColor="#29AB87"
            />
          </View>
          <View style={styles.inputWrapper}>
                  <Text style={styles.heading}>Include Uppercase letters</Text>
                  <BouncyCheckbox
                    disableBuiltInState
                    isChecked={upperCase}
                    onPress={() => setupperCase(!upperCase)}
                    fillColor="#FED85D"
                  />
                </View>
                <View style={styles.inputWrapper}>
                  <Text style={styles.heading}>Include Numbers</Text>
                  <BouncyCheckbox
                    disableBuiltInState
                    isChecked={numbers}
                    onPress={() => setNumbers(!numbers)}
                    fillColor="#C9A0DC"
                  />
                </View>
                <View style={styles.inputWrapper}>
                  <Text style={styles.heading}>Include Symbols</Text>
                  <BouncyCheckbox
                    disableBuiltInState
                    isChecked={symbols}
                    onPress={() => setSymbols(!symbols)}
                    fillColor="#FC80A5"
                  />
          </View>
          {/* PASO 10 IR a fichero PASO 10 */}
          <View style={styles.formActions}>
            {/* PASO 15 Modificamos Touchable con onPress */}
            <TouchableOpacity
              disabled={!isValid}
              style={styles.primaryBtn}
              onPress={handleSubmit}
              >
                <Text style={styles.primaryBtnTxt}>Generate Password</Text>
            </TouchableOpacity>
            {/* PASO 16 Modificamos el segundo Touchable */}
            <TouchableOpacity
          style={styles.secondaryBtn}
          onPress={ () => {
            handleReset();
            resetPasswordState()
          }}
          >
            <Text style={styles.secondaryBtnTxt}>Reset</Text>
          </TouchableOpacity>
          </View>
         </>
       )}
          </Formik>
        </View>
        {isPassGenerated ? (
          <View style={[styles.card, styles.cardElevated]}>
            <Text style={styles.subTitle}>Result:</Text>
            <Text style={styles.description}>Long Press to copy</Text>
            <Text selectable={true} style={styles.generatedPassword}>{password}</Text>
          </View>
        ) : null}

      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  appContainer: {
    flex: 1,
  },
  formContainer: {
    margin: 8,
    padding: 8,
  },
  title: {
    fontSize: 32,
    fontWeight: '600',
    marginBottom: 15,
  },
  subTitle: {
    fontSize: 26,
    fontWeight: '600',
    marginBottom: 2,
  },
  description: {
    color: '#758283',
    marginBottom: 8,
  },
  heading: {
    fontSize: 15,
  },
  inputWrapper: {
    marginBottom: 15,
    alignItems: 'center',
    justifyContent: 'space-between',
    flexDirection: 'row',
  },
  inputColumn: {
    flexDirection: 'column',
  },
  inputStyle: {
    padding: 8,
    width: '30%',
    borderWidth: 1,
    borderRadius: 4,
    borderColor: '#16213e',
  },
  errorText: {
    fontSize: 12,
    color: '#ff0d10',
  },
  formActions: {
    flexDirection: 'row',
    justifyContent: 'center',
  },
  primaryBtn: {
    width: 120,
    padding: 10,
    borderRadius: 8,
    marginHorizontal: 8,
    backgroundColor: '#5DA3FA',
  },
  primaryBtnTxt: {
    color: '#fff',
    textAlign: 'center',
    fontWeight: '700',
  },
  secondaryBtn: {
    width: 120,
    padding: 10,
    borderRadius: 8,
    marginHorizontal: 8,
    backgroundColor: '#CAD5E2',
  },
  secondaryBtnTxt: {
    textAlign: 'center',
  },
  card: {
    padding: 12,
    borderRadius: 6,
    marginHorizontal: 12,
  },
  cardElevated: {
    backgroundColor: '#ffffff',
    elevation: 1,
    shadowOffset: {
      width: 1,
      height: 1,
    },
    shadowColor: '#333',
    shadowOpacity: 0.2,
    shadowRadius: 2,
  },
  generatedPassword: {
    fontSize: 22,
    textAlign: 'center',
    marginBottom: 12,
    color:'#000'
  },
});

export default App;
