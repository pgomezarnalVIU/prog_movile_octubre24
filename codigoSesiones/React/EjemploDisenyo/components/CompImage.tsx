import { View, StyleSheet, Image } from "react-native";

export default function CompImage(){
    return(
        <View style={styles.container}>
            <Image 
            style={styles.imgIA}
            source={require('../assets/img03.jpg')}>
            </Image>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex:1,
        justifyContent:'center',
        alignItems:'center',
        paddingTop: 50,
    },
    tinyLogo: {
        width: 50,
        height: 50,
    },
    imgIA:{
        width: 200,
        height: 200,       
    }
})