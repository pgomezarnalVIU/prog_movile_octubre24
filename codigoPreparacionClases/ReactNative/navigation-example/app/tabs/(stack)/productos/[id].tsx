import { View, Text } from 'react-native'
import React from 'react'
import { Redirect, Stack, useLocalSearchParams } from 'expo-router'
import { productos } from '@/store/product_data';

const ProductDetail = () => {
  //REcogemos los parametros de entrada
  //const params = useLocalSearchParams();
  //console.log({params});
  const {id} = useLocalSearchParams();

  //Buscamos el producto
  const producto = productos.find (p=> p.id == id)
  if(!producto){
    return <Redirect href="/"/>;
  }
  


  return (
    <View className='px-5 mt-10'>
      <Stack.Screen
        options={{
          title: `Detalle de producto ${id}`,
        }}
      />
      <Text className='font-work-black text-2xl'>{producto.model}</Text>
      <Text className=''>{producto.brand}</Text>
      <Text className='font-work-black'>{producto.price}</Text>
    </View>
  )
}

export default ProductDetail