import React from 'react'
import { Stack, useLocalSearchParams } from 'expo-router'

const StackLayout = () => {

  return (
    <Stack
      screenOptions={{
        headerShown: false,
        headerShadowVisible : false,
        contentStyle :{
          backgroundColor : 'white'
        }
      }}
    >
      {/* Podemos configurar las rutas y opciones a través de StackScreen */}
      <Stack.Screen
        name='home/index'
        options={{
          title : 'Pantalla inicial'
        }}
      />
      <Stack.Screen
        name='productos/index'
        options={{
          title : 'Productos'
        }}
      />
      <Stack.Screen
        name='nosotros/index'
        options={{
          title : 'Nosotros',
          animation : 'fade_from_bottom'
        }}
      />
      <Stack.Screen
        name='settings/index'
        options={{
          title : 'Settings'
        }}
      />

    </Stack>
  )
}

export default StackLayout