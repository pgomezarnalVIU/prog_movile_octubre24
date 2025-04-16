import React from 'react'

import { Tabs } from 'expo-router'
import FontAwesome from '@expo/vector-icons/FontAwesome';

const TabsLayout = () => {
  return (
    <Tabs screenOptions={{ tabBarActiveTintColor: 'blue' }}>
      <Tabs.Screen
        name="(stack)"
        options={{
          title: 'Home',
          tabBarIcon: ({ color }) => <FontAwesome size={28} name="home" color={color} />,
        }}
      />
      <Tabs.Screen
        name="favoritos/index"
        options={{
          title: 'Favoritos',
          tabBarIcon: ({ color }) => <FontAwesome size={28} name="cog" color={color} />,
        }}
      />
    </Tabs>
  )
}

export default TabsLayout