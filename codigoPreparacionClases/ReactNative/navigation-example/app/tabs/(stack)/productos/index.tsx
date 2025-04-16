import {fetch} from 'expo/fetch'
import { View, Text, FlatList} from 'react-native'
import {Link} from 'expo-router'
import React,{useEffect, useState} from 'react'

import { productos } from '@/store/product_data'



const ProductosScreen = () => {
  const [loading,setLoading] = useState(true);
  const [productosApi,setProductosApi] = useState([]);
  const apiUrl = "http://192.168.0.108:3000/products"

  const fectchProducts = async () => {
    try{
      const response = await fetch(apiUrl);
      const products = await response.json();
      //console.log(products);
      setProductosApi(products);
      return products
    } catch (error: any){
      console.log(error);
    } finally{
      setLoading(false)
    }
  }

  useEffect(()=>{fectchProducts()},[])

  return (
    <View className='flex flex-1 px-4'>
      <FlatList
        data = {productosApi}
        keyExtractor={(item)=>item.id}
        renderItem={({item})=>
        <View className='mt-10'>
          <Text className='text-2xl font-work-black'>{item.model}</Text>
          <Text>{item.brand}</Text>
          <View className='flex flex-row justify-between'>
            <Text className='font-work-black'>{item.price}</Text>
            <Link href={`/tabs/(stack)/productos/${item.id}`} className='text-primary'>Ver detalles</Link>
          </View>
        </View>  
        }
      >
      </FlatList>
    </View>
  )
}

export default ProductosScreen