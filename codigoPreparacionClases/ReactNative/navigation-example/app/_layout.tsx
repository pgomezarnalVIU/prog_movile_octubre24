import {useFonts} from 'expo-font'
import { Slot, SplashScreen, Stack } from 'expo-router'
import React, { useEffect } from 'react'

import "./global.css"

const RootLayout = () => {

  const [loaded,error] = useFonts  ({
    'WorkSans-Black' : require('../assets/fonts/WorkSans-Black.ttf'),
    'WorkSans-Light' : require('../assets/fonts/WorkSans-Light.ttf'),
    'WorkSans-Medium' : require('../assets/fonts/WorkSans-Medium.ttf'),
  })

  //Control de carga de fuentes
  useEffect( ()=>{
    if(error) throw error;
    if(loaded) SplashScreen.hideAsync();
  },[loaded,error])

  if(!loaded && !error) return null;

  return (
    <Slot/>
  )
}

export default RootLayout