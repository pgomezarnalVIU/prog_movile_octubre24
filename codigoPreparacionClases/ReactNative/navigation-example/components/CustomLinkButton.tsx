import { Text, PressableProps, Pressable, View } from 'react-native'
import React from 'react'

interface Props extends PressableProps{
    children: string;
    color : 'primary' | 'secondary' | 'tertiary'
}

const CustomLinkButton = ({children,color='primary', onPress}:Props) => {

  //Realizamos la equivalencia del theme de color al bg
  const btnColor = {
    primary: 'bg-primary',
    secondary: 'bg-secundary',
    tertiary: 'bg-tertiary',
  }[color];

  return (
    <Pressable 
      className={`p-3 rounded-md ${btnColor} active:opacity-85`}
      onPress={onPress}
    >
        <Text className='text-white text-center'>{children}</Text>
    </Pressable>
  )
}

export default CustomLinkButton