import { View, Text, SafeAreaView } from 'react-native'
import { Link, router } from 'expo-router'

import React from 'react'
import CustomLinkButton from '@/components/CustomLinkButton'

const NosotrosScreen = () => {
  return (
    <SafeAreaView>
      {/*
        <View className='mt-10'>
          <Text className='text-xl font-work-black text-primary'>Hola Paco</Text>
          <Text className='text-xl font-work-medium text-morado-500'>Hola Paco</Text>
          <Text className='text-xl font-work-light'>Hola Paco</Text>
        </View>
        <View className='m-10 bg-morado-100'>  
      
      */}
      <View className='m-2'>
        <CustomLinkButton  color='primary'
          onPress={() => router.push("/tabs/(stack)/productos")}
          >Productos</CustomLinkButton>
      </View>
      <View className='m-2'>
        <CustomLinkButton color='secondary' 
          onPress={() => router.push("/tabs/(stack)/nosotros")}>
            Nosotros</CustomLinkButton>
      </View>
      <View className='m-2'>
        <CustomLinkButton color='tertiary' 
          onPress={() => router.push("/tabs/(stack)/settings")}>
            Settings</CustomLinkButton>
      </View>
    </SafeAreaView>
  )
}

export default NosotrosScreen